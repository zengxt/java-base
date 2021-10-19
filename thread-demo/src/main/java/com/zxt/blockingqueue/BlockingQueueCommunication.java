package com.zxt.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueCommunication {

	public static void main(String[] args) {
		final Business business = new Business();
		
		// 子线程
		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}

			}
		}).start();
		
		// 主线程
		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}

	}

	static class Business {
		// 每次执行之前都先在对于的队列中放值，用满队列来阻塞线程，操作完成之后，清空另一个队列，相当于一个通知
		BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);
		BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);
		
		// 在每次新建对象，调用构造方法之前执行
		{
			try {
				// 初始时  queue2 满了，此时再往 queue2 中放数据则会阻塞，只有当另一个线程将 queue2 的值取走，相当于给它一个通知
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