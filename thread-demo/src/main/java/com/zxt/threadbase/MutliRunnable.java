package com.zxt.threadbase;

/**
 * 
 * @Description: ���߳̾���
 *
 * @author�� zxt
 *
 * @time: 2018��4��6�� ����4:10:17
 *
 */
public class MutliRunnable {

	public static void main(String[] args) {
		
		Pig pig = new Pig(10);
		Bird bird = new Bird(10);
		
		Thread t1 = new Thread(pig);
		Thread t2 = new Thread(bird);
		
		t1.start();
		t2.start();
	}
}

class animal {
	int age = 0;
	int times = 0;

	public animal(int age) {
		this.age = age;
	}
}

// ��ӡ
class Pig extends animal implements Runnable {

	public Pig(int age) {
		super(age);
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			times++;
			System.out.println("����һ���̣߳��������" + times + "�� Hello World!");
			if (times == age) {
				break;
			}
		}
	}
}

// ����
class Bird extends animal implements Runnable {
	int res = 0;

	public Bird(int age) {
		super(age);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			res += (++times);
			System.out.println("��ǰ����ǣ�" + res);
			if (times == age) {
				System.out.println("������ǣ�" + res);
				break;
			}
		}
	}
}