package com.zxt.synch;

/**
 * 
 * @Description: ���߳�ѭ��10�Σ��������߳�ѭ��100�������ֻص����߳�ѭ��10�Σ������ٻص����߳���ѭ��100�����ѭ��50��
 * 				   ʹ��synchronized��wait��notify����ʵ��
 *
 * @author�� zxt
 *
 * @time: 2018��4��6�� ����7:12:39
 *
 */
public class ThreadCommunication {

	public static void main(String[] args) {
		// ���������̺߳����̸߳��Ե�ѭ��Ӧ�ò������ң�����Ӧ�ü���ͬ���������ѭ��50�ε��߼���Ӧ������Ҫ�˹��ܵĵ����ߴ���
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
	// ��ʾ�Ƿ�Ӧ��sub����ִ�У�Ϊtrue��ʾsubִ�У�
	private boolean bSubShould = true;
	
	public synchronized void sub(int i) {
		while(!bSubShould) {
			try {
				// ��sub����ִ��ʱ����ȴ�
				this.wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("this is sub thread sequence of " + j + ", loop of " + i);
		}
		
		// �´�ִ����main����
		bSubShould = false;
		// ͬʱ��Ҫ���ѵȴ����߳�
		this.notify();
	}

	public synchronized void main(int i) {
		while(bSubShould) {
			try {
				// ��ס�߳�ִ��ʱ����ȴ�
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 100; j++) {
			System.out.println("this is main thread sequence of " + j + ", loop of " + i);
		}
		
		// �´�ִ�е���sub����
		bSubShould = true;
		// ͬʱ��Ҫ���ѵȴ����߳�
		this.notify();
	}
}
