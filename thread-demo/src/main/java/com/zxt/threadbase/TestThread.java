package com.zxt.threadbase;

import java.util.Random;

/**
 * 
 * @Description: 创建线程的第一种方法，继承Thread类（Thread类本质也是实现了Runnable接口）
 *
 * @author： zxt
 *
 * @time: 2018年4月6日 下午12:17:48
 *
 */
public class TestThread extends Thread {

	public static void main(String[] args) {
		TestThread t1 = new TestThread("张三");
		TestThread t2 = new TestThread("李四");

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
