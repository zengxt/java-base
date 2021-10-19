package com.zxt.executor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @Description: ���߳�ѭ��10�Σ��������߳�ѭ��100�������ֻص����߳�ѭ��10�Σ������ٻص����߳���ѭ��100�����ѭ��50��
 * 				   ʹ�� Lock �� Condition ����ʵ��
 *
 * @author�� zxt
 *
 * @time: 2018��4��6�� ����7:12:39
 *
 */
public class ThreeThreadCommunication {

	public static void main(String[] args) {
		final Business business = new Business();
		
		// ���߳�1
		new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}

			}
		}).start();
		
		// ���߳�2
		new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub2(i);
				}

			}
		}).start();

		// ���߳�
		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}
	}
	
	/**
	 * 
	 * @Description: ͬ���Ĺ��ܷ�װ����Դ�ڲ����������������߳�������Ҫ�����߳�ͬ�����⣩
	 *
	 * @author�� zxt
	 *
	 * @time: 2018��4��6�� ����7:36:02
	 *
	 */
	static class Business {
		// ����һ����
		Lock lock = new ReentrantLock();
		// ����������������Condition����  (���߳�1 ֪ͨ ���߳�2�� ���߳�2 ֪ͨ ���̣߳� ���߳� ֪ͨ  ���߳�1)
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();
		
		// ��ʾ�Ƿ�Ӧ���ĸ�����ִ�У�1�����߳�1��2�����߳�2�� 3�����̣߳�
		private int subShould = 1;
		
		public void sub(int i) {
			lock.lock();
			try {
				while(subShould != 1) {
					try {
						// ��sub����ִ��ʱ����ȴ�
						condition1.await();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j <= 10; j++) {
					System.out.println(Thread.currentThread().getName() + " sequence of " + j + ", loop of " + i);
				}
				
				// �´�ִ����sub2����
				subShould = 2;
				// ͬʱ��Ҫ���ѵȴ����߳�2����condition��һ���źţ�
				condition2.signal();
				
			} finally {
				// �ͷ�������
				lock.unlock();
			}
		}
		
		public void sub2(int i) {
			lock.lock();
			try {
				while(subShould != 2) {
					try {
						// ��sub2����ִ��ʱ����ȴ�
						condition2.await();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j <= 10; j++) {
					System.out.println(Thread.currentThread().getName() + " sequence of " + j + ", loop of " + i);
				}
				
				// �´�ִ����m����
				subShould = 3;
				// ͬʱ��Ҫ���ѵȴ������̣߳���condition��һ���źţ�
				condition3.signal();
				
			} finally {
				// �ͷ�������
				lock.unlock();
			}
		}

		public void main(int i) {
			lock.lock();
			try {
				while(subShould != 3) {
					try {
						// �����߳�ִ��ʱ����ȴ�
						condition3.await();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j <= 100; j++) {
					System.out.println(Thread.currentThread().getName() + " sequence of " + j + ", loop of " + i);
				}
				
				// �´�ִ�е���sub����
				subShould = 1;
				// ͬʱ��Ҫ���ѵȴ����߳�1����condition��һ���źţ�
				condition1.signal();
				
			} finally {
				// �ͷ�������
				lock.unlock();
			}
		}
	}
}