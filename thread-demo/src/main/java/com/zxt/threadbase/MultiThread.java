package com.zxt.threadbase;

/**
 * 
 * @Description: ��ʾ���ͨ���̳�Thread�������߳�
 *
 * @author�� zxt
 *
 * @time: 2018��4��6�� ����10:15:31
 *
 */
public class MultiThread {
	private static Lefthand left;
	private static Righthand right;

	public static void main(String[] args) {
		left = new Lefthand();
		right = new Righthand();
		left.start();
		right.start();
	}
}

class Lefthand extends Thread {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("You are Stedents!");
			try {
				sleep(500);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}

class Righthand extends Thread {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("I am a teacher!");
			try {
				sleep(300);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}