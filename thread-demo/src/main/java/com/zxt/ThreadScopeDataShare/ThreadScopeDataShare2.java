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
public class ThreadScopeDataShare2 {
	
	// ʹ��ThreadLocal�����治ͬ�̵߳ľֲ���������
	private static ThreadLocal<String> threadLocalData = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		// �½������̣߳���Ҫ��֤�������߳�֮������ݲ����໥Ӱ�죩
		for(int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				
				public void run() {
					int putData = new Random().nextInt();
					
					// ���̵߳����ݷ��뵽ThreadLocal��
					threadLocalData.set(Thread.currentThread().getName() + ", " + putData);
					System.out.println(Thread.currentThread().getName() + " has put data��" + putData);
					
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
			String data = threadLocalData.get();
			System.out.println("A from " + Thread.currentThread().getName() + " get data��" + data);
		}
	}
	
	static class B {
		public static void get() {
			// ��ȡ�߳���ThreadLocal�б���ı���
			String data = threadLocalData.get();
			System.out.println("B from " + Thread.currentThread().getName() + " get data��" + data);
		}
	}
}
