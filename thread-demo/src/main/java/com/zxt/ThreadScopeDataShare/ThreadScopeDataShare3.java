package com.zxt.ThreadScopeDataShare;

import java.util.Random;

/**
 * 
 * @Description: �̷߳�Χ�ڵ����ݹ���
 *
 * @author�� zxt
 *
 * @time: 2018��4��6�� ����10:11:14
 *
 */
public class ThreadScopeDataShare3 {

	public static void main(String[] args) {
		// �½������̣߳���Ҫ��֤�������߳�֮������ݲ����໥Ӱ�죩
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {

				public void run() {
					int putData = new Random().nextInt();

					// ���̵߳����ݷ��뵽ThreadLocal��
					MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
					myData.setName(Thread.currentThread().getName());
					myData.setData(putData);
					System.out.println(Thread.currentThread().getName() + " has put data��" + myData);

					// ��ͬһ���߳��У���ͬ�Ķ���ȡ����
					A.get();
					B.get();
				}

			}).start();
		}
	}

	static class A {
		public static void get() {
			// ��ȡ�߳���ThreadLocal�б���ı���
			MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
			System.out.println("A from " + Thread.currentThread().getName() + " get data��" + myData);
		}
	}

	static class B {
		public static void get() {
			// ��ȡ�߳���ThreadLocal�б���ı���
			MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
			System.out.println("B from " + Thread.currentThread().getName() + " get data��" + myData);
		}
	}
}

/**
 * 
 * @Description: ��װ�߳���Ҫ����ľֲ������������캯������Ϊ˽�У���ֹ�ⲿ������ֻ���ڽ����ݱ��浽ThreadLocal��ʱ�򴴽�
 * 				  ���������ʱ�����ж��Ƿ��Ѿ�����������͵����ݣ�����������򽫸�ʵ�����أ�ֱ���޸ļ��ɣ���û�У����ȴ�������������
 *
 * @author�� zxt
 *
 * @time: 2018��4��7�� ����8:09:56
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
		return name + "��" + data;
	}
}
