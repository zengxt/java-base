package com.zxt.threadbase;

import java.util.Random;

/**
 * 
 * @Description: �����̵߳ĵ�һ�ַ������̳�Thread�ࣨThread�౾��Ҳ��ʵ����Runnable�ӿڣ�
 *
 * @author�� zxt
 *
 * @time: 2018��4��6�� ����12:17:48
 *
 */
public class TestThread extends Thread {

	public static void main(String[] args) {
		TestThread t1 = new TestThread("����");
		TestThread t2 = new TestThread("����");

		t1.start();
		t2.start();
	}

	public TestThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(new Random().nextInt(10) * 100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
