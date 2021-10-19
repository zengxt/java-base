package com.zxt.threadbase;

import java.util.Random;

/**
 * 
 * @Description: �����̵߳ĵڶ��ַ�����ʵ��Runnable�ӿڣ�����ʹ�����ַ�����������������̵��ص�
 *
 * @author�� zxt
 *
 * @time: 2018��4��6�� ����12:21:47
 *
 */
public class TestRunnable {

	public static void main(String[] args) {
		DoSomething ds1 = new DoSomething("����");
		DoSomething ds2 = new DoSomething("����");

		Thread t1 = new Thread(ds1);
		Thread t2 = new Thread(ds2);

		t1.start();
		t2.start();
	}
}

// ʵ��Runnable�ӿڵ���
class DoSomething implements Runnable {
	private String name;

	public DoSomething(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(new Random().nextInt(10) * 100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + ": " + i);
		}
	}
}
