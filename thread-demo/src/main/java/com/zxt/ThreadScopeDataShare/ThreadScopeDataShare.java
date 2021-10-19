package com.zxt.ThreadScopeDataShare;

import java.util.HashMap;
import java.util.Map;
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
public class ThreadScopeDataShare {
	
	// ʹ��һ��map����֤��ͬ�̼߳�����ݲ����໥Ӱ�죬ͳһ�߳��е����ݹ���
	private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();
	
	public static void main(String[] args) {
		// �½������̣߳���Ҫ��֤�������߳�֮������ݲ����໥Ӱ�죩
		for(int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				
				public void run() {
					int putData = new Random().nextInt();
					// �Ե�ǰ�߳�Ϊkeyֵ���뵽map�У���ȡֵʱ���ݸ��Ե��߳�ȡ���Ե����� 
					threadData.put(Thread.currentThread(), putData);
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
			int data = threadData.get(Thread.currentThread());
			System.out.println("A from " + Thread.currentThread().getName() + " get data��" + data);
		}
	}
	
	static class B {
		public static void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println("B from " + Thread.currentThread().getName() + " get data��" + data);
		}
	}
}