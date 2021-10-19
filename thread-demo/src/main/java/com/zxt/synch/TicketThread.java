package com.zxt.synch;

/**
 * 
 * @Description: ʹ��synchronized������ʵ�ֶ��߳�ͬ��
 *
 * @author�� zxt
 *
 * @time: 2018��4��6�� ����5:44:15
 *
 */
public class TicketThread {

	public static void main(String[] args) {

		// ����һ��������Ʊ   ��������(�����̲߳���)
		TicketWindow tw1 = new TicketWindow();

		Thread t1 = new Thread(tw1);
		Thread t2 = new Thread(tw1);
		Thread t3 = new Thread(tw1);

		t1.start();
		t2.start();
		t3.start();
	}
}

// ��Ʊ������
class TicketWindow implements Runnable {
	// һ����ǧ��Ʊ
	private static int nums = 2000;

	public void run() {

		while (true) {
			
			try {
				// ��Ʊ�ٶ�1���һ��
				Thread.sleep(100);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			// ������뱣֤�����ԭ���� ��ȷ��nums�Ļ������
			// ͬ�������  ������ʹ��ͬһ��������м�����
			synchronized (this) {
				// �ж��Ƿ���Ʊ
				if (nums > 0) {
					// ��ʾ��Ʊ��Ϣ
					System.out.println(Thread.currentThread().getName()
							+ "���۳��� " + nums + "��Ʊ");
					nums--;
					
				} else {
					break;
				}
			}
		}
	}
}