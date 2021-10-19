package com.zxt.executor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @Description: 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次
 * 				   使用 Lock 与 Condition 技术实现
 *
 * @author： zxt
 *
 * @time: 2018年4月6日 下午7:12:39
 *
 */
public class ThreadCommunication {

	public static void main(String[] args) {
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
	// 构造一把锁
	Lock lock = new ReentrantLock();
	// 由锁创建一个条件阻塞Condition对象
	Condition condition = lock.newCondition();
	
	// 表示是否应该sub函数执行（为true表示sub执行）
	private boolean bSubShould = true;
	
	public void sub(int i) {
		lock.lock();
		try {
			while(!bSubShould) {
				try {
					// 非sub函数执行时，则等待
					condition.await();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 10; j++) {
				System.out.println(Thread.currentThread().getName() + " sequence of " + j + ", loop of " + i);
			}
			
			// 下次执行是main函数
			bSubShould = false;
			// 同时需要唤醒等待的线程（由condition给一个信号）
			condition.signal();
			
		} finally {
			// 释放锁对象
			lock.unlock();
		}
	}

	public void main(int i) {
		lock.lock();
		try {
			while(bSubShould) {
				try {
					// 非住线程执行时，则等待
					condition.await();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 100; j++) {
				System.out.println(Thread.currentThread().getName() + " sequence of " + j + ", loop of " + i);
			}
			
			// 下次执行的是sub函数
			bSubShould = true;
			// 同时需要唤醒等待的线程（由condition给一个信号）
			condition.signal();
			
		} finally {
			// 释放锁对象
			lock.unlock();
		}
	}
}
