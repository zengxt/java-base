package com.zxt.synch;

/**
 * 
 * @Description: 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次
 * 				   使用synchronized与wait和notify技术实现
 *
 * @author： zxt
 *
 * @time: 2018年4月6日 下午7:12:39
 *
 */
public class ThreadCommunication {

	public static void main(String[] args) {
		// 分析，子线程和主线程各自的循环应该不被打乱，所以应该加锁同步，而如此循环50次的逻辑，应该由需要此功能的调用者处理
		final Business business = new Business();
		
		// 子线程
		new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}

			}
		}).start();

		// 主线程
		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}
	}

}

/**
 * 
 * @Description: 同步的功能封装在资源内部（这样调用它的线程则不再需要考虑线程同步问题）
 *
 * @author： zxt
 *
 * @time: 2018年4月6日 下午7:36:02
 *
 */
class Business {
	// 表示是否应该sub函数执行（为true表示sub执行）
	private boolean bSubShould = true;
	
	public synchronized void sub(int i) {
		while(!bSubShould) {
			try {
				// 非sub函数执行时，则等待
				this.wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("this is sub thread sequence of " + j + ", loop of " + i);
		}
		
		// 下次执行是main函数
		bSubShould = false;
		// 同时需要唤醒等待的线程
		this.notify();
	}

	public synchronized void main(int i) {
		while(bSubShould) {
			try {
				// 非住线程执行时，则等待
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 100; j++) {
			System.out.println("this is main thread sequence of " + j + ", loop of " + i);
		}
		
		// 下次执行的是sub函数
		bSubShould = true;
		// 同时需要唤醒等待的线程
		this.notify();
	}
}
