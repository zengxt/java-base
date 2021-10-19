package com.zxt.threadbase;

import java.util.Random;

/**
 * 
 * @Description: 创建线程的第二种方法，实现Runnable接口，尽量使用这种方法，体现面向对象编程的特点
 *
 * @author： zxt
 *
 * @time: 2018年4月6日 下午12:21:47
 *
 */
public class TestRunnable {

	public static void main(String[] args) {
		DoSomething ds1 = new DoSomething("阿三");
		DoSomething ds2 = new DoSomething("李四");

		Thread t1 = new Thread(ds1);
		Thread t2 = new Thread(ds2);

		t1.start();
		t2.start();
	}
}

// 实现Runnable接口的类
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
