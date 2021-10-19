package com.zxt.ThreadScopeDataShare;

import java.util.HashMap;
import java.util.Map;
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
public class ThreadScopeDataShare {
	
	// 使用一个map来保证不同线程间的数据不会相互影响，统一线程中的数据共享
	private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();
	
	public static void main(String[] args) {
		// 新建两个线程（需要保证这两个线程之间的数据不会相互影响）
		for(int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				
				public void run() {
					int putData = new Random().nextInt();
					// 以当前线程为key值放入到map中，当取值时根据各自的线程取各自的数据 
					threadData.put(Thread.currentThread(), putData);
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
			int data = threadData.get(Thread.currentThread());
			System.out.println("A from " + Thread.currentThread().getName() + " get data：" + data);
		}
	}
	
	static class B {
		public static void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println("B from " + Thread.currentThread().getName() + " get data：" + data);
		}
	}
}