package com.zxt.ThreadScopeDataShare;

import java.util.Random;

/**
 * 
 * @Description: 线程范围内的数据共享
 *
 * @author： zxt
 *
 * @time: 2018年4月6日 下午10:11:14
 *
 */
public class ThreadScopeDataShare2 {
	
	// 使用ThreadLocal来保存不同线程的局部变量副本
	private static ThreadLocal<String> threadLocalData = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		// 新建两个线程（需要保证这两个线程之间的数据不会相互影响）
		for(int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				
				public void run() {
					int putData = new Random().nextInt();
					
					// 将线程的数据放入到ThreadLocal中
					threadLocalData.set(Thread.currentThread().getName() + ", " + putData);
					System.out.println(Thread.currentThread().getName() + " has put data：" + putData);
					
					// 在同一个线程中，不同的对象取数据
					A.get();
					B.get();
				}
				
			}).start();
		}
	}
	
	static class A {
		public static void get() {
			// 获取线程在ThreadLocal中保存的变量
			String data = threadLocalData.get();
			System.out.println("A from " + Thread.currentThread().getName() + " get data：" + data);
		}
	}
	
	static class B {
		public static void get() {
			// 获取线程在ThreadLocal中保存的变量
			String data = threadLocalData.get();
			System.out.println("B from " + Thread.currentThread().getName() + " get data：" + data);
		}
	}
}
