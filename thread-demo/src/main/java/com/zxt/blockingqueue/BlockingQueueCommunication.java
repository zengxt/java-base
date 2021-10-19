package com.zxt.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueCommunication {

	public static void main(String[] args) {
		final Business business = new Business();
		
		// ���߳�
		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}

			}
		}).start();
		
		// ���߳�
		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}

	}

	static class Business {
		// ÿ��ִ��֮ǰ�����ڶ��ڵĶ����з�ֵ�����������������̣߳��������֮�������һ�����У��൱��һ��֪ͨ
		BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);
		BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);
		
		// ��ÿ���½����󣬵��ù��췽��֮ǰִ��
		{
			try {
				// ��ʼʱ  queue2 ���ˣ���ʱ���� queue2 �з��������������ֻ�е���һ���߳̽� queue2 ��ֵȡ�ߣ��൱�ڸ���һ��֪ͨ
				queue2.put(1);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void sub(int i) {
			try {
				queue1.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for (int j = 1; j <= 10; j++) {
				System.out.println("sub thread sequece of " + j + ",loop of " + i);
			}
			
			try {
				queue2.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void main(int i) {
			try {
				queue2.put(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			for (int j = 1; j <= 100; j++) {
				System.out.println("main thread sequece of " + j + ",loop of " + i);
			}
			
			try {
				queue1.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}