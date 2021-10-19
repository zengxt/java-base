package com.zxt.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @Description: Lockʹ��ʵ��
 *
 * @author�� zxt
 *
 * @time: 2018��4��9�� ����3:20:30
 *
 */
public class LockTest {

	public static void main(String[] args) {
		final Output output = new Output();

		// �߳�1
		new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 50; i++) {
					output.output(Thread.currentThread().getName() + " hello!!");
				}

			}
		}).start();
		
		// �߳�2
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
		// ���ڵ����⣬�����ȥ���������쳣������һֱ�����ͷ��ˣ�����߳̾���Ҳ����ȥ�ˡ�
		lock.lock();
		try {
			// ��һ���ַ���������ӡ��
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
			
		} finally {
			// ����취��������ߵĴ�����try��Χ��������finally���unlock�������Ƿ�������Ҫ�ͷ�����
			lock.unlock();
		}
	}
}