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
public class ThreadCommunication {

	public static void main(String[] args) {
		final Business business = new Business();
		
		// ���߳�
		new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}

			}
		}).start();

		// ���߳�
		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}
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
class Business {
	// ����һ����
	Lock lock = new ReentrantLock();
	// ��������һ����������Condition����
	Condition condition = lock.newCondition();
	
	// ��ʾ�Ƿ�Ӧ��sub����ִ�У�Ϊtrue��ʾsubִ�У�
	private boolean bSubShould = true;
	
	public void sub(int i) {
		lock.lock();
		try {
			while(!bSubShould) {
				try {
					// ��sub����ִ��ʱ����ȴ�
					condition.await();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 10; j++) {
				System.out.println(Thread.currentThread().getName() + " sequence of " + j + ", loop of " + i);
			}
			
			// �´�ִ����main����
			bSubShould = false;
			// ͬʱ��Ҫ���ѵȴ����̣߳���condition��һ���źţ�
			condition.signal();
			
		} finally {
			// �ͷ�������
			lock.unlock();
		}
	}

	public void main(int i) {
		lock.lock();
		try {
			while(bSubShould) {
				try {
					// ��ס�߳�ִ��ʱ����ȴ�
					condition.await();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 100; j++) {
				System.out.println(Thread.currentThread().getName() + " sequence of " + j + ", loop of " + i);
			}
			
			// �´�ִ�е���sub����
			bSubShould = true;
			// ͬʱ��Ҫ���ѵȴ����̣߳���condition��һ���źţ�
			condition.signal();
			
		} finally {
			// �ͷ�������
			lock.unlock();
		}
	}
}
