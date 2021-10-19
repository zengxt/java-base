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
public class ThreadScopeDataShare3 {

	public static void main(String[] args) {
		// 新建两个线程（需要保证这两个线程之间的数据不会相互影响）
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {

				public void run() {
					int putData = new Random().nextInt();

					// 将线程的数据放入到ThreadLocal中
					MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
					myData.setName(Thread.currentThread().getName());
					myData.setData(putData);
					System.out.println(Thread.currentThread().getName() + " has put data：" + myData);

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
			MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
			System.out.println("A from " + Thread.currentThread().getName() + " get data：" + myData);
		}
	}

	static class B {
		public static void get() {
			// 获取线程在ThreadLocal中保存的变量
			MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
			System.out.println("B from " + Thread.currentThread().getName() + " get data：" + myData);
		}
	}
}

/**
 * 
 * @Description: 封装线程需要保存的局部变量，将构造函数设置为私有，防止外部创建，只有在将数据保存到ThreadLocal的时候创建
 * 				  并且其操作时，先判断是否已经保存过该类型的数据，若保存过，则将该实例返回，直接修改即可，若没有，则先创建，再填数据
 *
 * @author： zxt
 *
 * @time: 2018年4月7日 下午8:09:56
 *
 */
class MyThreadScopeData {

	private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();

	private MyThreadScopeData() {
	}

	public static MyThreadScopeData getThreadInstance() {
		MyThreadScopeData instance = map.get();
		if (instance == null) {
			instance = new MyThreadScopeData();
			map.set(instance);
		}

		return instance;
	}

	private String name;
	private int data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public String toString() {
		return name + "：" + data;
	}
}
