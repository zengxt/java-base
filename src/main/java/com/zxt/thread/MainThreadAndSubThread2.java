package com.zxt.thread;

/*
 * ���߳�ѭ��10�Σ��������߳�ѭ��5�������ֻص����߳�ѭ��10�Σ������ٻص����߳���ѭ��5�����ѭ��50��
 */
public class MainThreadAndSubThread2 {
	private static boolean bShouldSub = true;

	public static void main(String[] args) {
		MainThreadAndSubThread2 mt = new MainThreadAndSubThread2();
		
		SubThread st = mt.new SubThread();
		Thread t = new Thread(st, "���߳�");
		t.start();

		for (int i = 0; i < 50; i++) {
			mt.MainThreadRun(i);
		}
	}

	private class SubThread implements Runnable {
		public void run() {
			for (int i = 0; i < 50; i++) {
				SubThreadRun(i);
			}
		}
	}

	private synchronized void MainThreadRun(int i) {
		if (bShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int j = 0; j < 5; j++) {
			System.out.println(Thread.currentThread().getName() + ":i=" + i + ",j=" + j);
		}
		bShouldSub = true;
		this.notify();
	}

	private synchronized void SubThreadRun(int i) {
		if (!bShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int j = 0; j < 10; j++) {
			System.out.println(Thread.currentThread().getName() + ":i=" + i + ",j=" + j);
		}
		bShouldSub = false;
		this.notify();
	}
}