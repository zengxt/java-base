package com.zxt.thread;

/*
 * 子线程循环10次，接着主线程循环5，接着又回到子线程循环10次，接着再回到主线程又循环5，如此循环50次
 */
public class MainThreadAndSubThread2 {
	private static boolean bShouldSub = true;

	public static void main(String[] args) {
		MainThreadAndSubThread2 mt = new MainThreadAndSubThread2();
		
		SubThread st = mt.new SubThread();
		Thread t = new Thread(st, "子线程");
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