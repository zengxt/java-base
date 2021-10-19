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
public class ThreeThreadCommunication {

	public static void main(String[] args) {
		final Business business = new Business();
		
		// 子线程1
		new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}

			}
		}).start();
		
		// 子线程2
		new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub2(i);
				}

			}
		}).start();

		// 主线程
		for (int i = 1; i <= 50; i++) {
			business.main(i);
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
	static class Business {
		// 构造一把锁
		Lock lock = new ReentrantLock();
		// 由锁创建条件阻塞Condition对象  (子线程1 通知 子线程2， 子线程2 通知 主线程， 主线程 通知  子线程1)
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();
		
		// 表示是否应该哪个函数执行（1：子线程1，2：子线程2， 3：主线程）
		private int subShould = 1;
		
		public void sub(int i) {
			lock.lock();
			try {
				while(subShould != 1) {
					try {
						// 非sub函数执行时，则等待
						condition1.await();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j <= 10; j++) {
					System.out.println(Thread.currentThread().getName() + " sequence of " + j + ", loop of " + i);
				}
				
				// 下次执行是sub2函数
				subShould = 2;
				// 同时需要唤醒等待的线程2（由condition给一个信号）
				condition2.signal();
				
			} finally {
				// 释放锁对象
				lock.unlock();
			}
		}
		
		public void sub2(int i) {
			lock.lock();
			try {
				while(subShould != 2) {
					try {
						// 非sub2函数执行时，则等待
						condition2.await();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j <= 10; j++) {
					System.out.println(Thread.currentThread().getName() + " sequence of " + j + ", loop of " + i);
				}
				
				// 下次执行是m函数
				subShould = 3;
				// 同时需要唤醒等待的主线程（由condition给一个信号）
				condition3.signal();
				
			} finally {
				// 释放锁对象
				lock.unlock();
			}
		}

		public void main(int i) {
			lock.lock();
			try {
				while(subShould != 3) {
					try {
						// 非主线程执行时，则等待
						condition3.await();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j <= 100; j++) {
					System.out.println(Thread.currentThread().getName() + " sequence of " + j + ", loop of " + i);
				}
				
				// 下次执行的是sub函数
				subShould = 1;
				// 同时需要唤醒等待的线程1（由condition给一个信号）
				condition1.signal();
				
			} finally {
				// 释放锁对象
				lock.unlock();
			}
		}
	}
}