package com.zxt.synchronize.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		// ����һ���̳߳�
		ExecutorService service = Executors.newCachedThreadPool();

		// ͬʱ�������߳���
		final Semaphore sp = new Semaphore(3);

		// �½�10���̹߳���
		for (int i = 0; i < 10; i++) {

			Runnable runnable = new Runnable() {

				@Override
				public void run() {

					try {
						// ���Ի�ȡ�������
						sp.acquire();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("�߳�  " + Thread.currentThread().getName() + " ���룬��ǰ����  "
							+ (3 - sp.availablePermits()) + " ������");
					
					try {
						Thread.sleep((long)(Math.random()*10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("�߳�  " + Thread.currentThread().getName() + " �����뿪");
					sp.release();

					// ���������ʱ��ִ�в�׼ȷ����Ϊ��û�к�����Ĵ���ϳ�ԭ�ӵ�Ԫ
					System.out.println("�߳�  " + Thread.currentThread().getName() + " ���뿪����ǰ����  "
							+ (3 - sp.availablePermits()) + " ������");
				}
			};

			// �߳��ύ����
			service.execute(runnable);
		}
	}
}
