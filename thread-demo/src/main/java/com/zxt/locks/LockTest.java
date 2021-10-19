package com.zxt.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @Description: Lock使用实例
 *
 * @author： zxt
 *
 * @time: 2018年4月9日 下午3:20:30
 *
 */
public class LockTest {

	public static void main(String[] args) {
		final Output output = new Output();

		// 线程1
		new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 50; i++) {
					output.output(Thread.currentThread().getName() + " hello!!");
				}

			}
		}).start();
		
		// 线程2
		new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 50; i++) {
					output.output(Thread.currentThread().getName() + " world!!");
				}

			}
		}).start();
	}

}

class Output {
	
	Lock lock = new ReentrantLock();
	
	public void output(String name) {
		// 存在的问题，如果进去后程序出现异常，锁就一直不能释放了，别的线程就再也进不去了。
		lock.lock();
		try {
			// 将一个字符串挨个打印出
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
			
		} finally {
			// 解决办法：将锁里边的代码用try包围起来，在finally里边unlock，无论是否正常都要释放锁。
			lock.unlock();
		}
	}
}