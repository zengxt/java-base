package com.zxt.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		
		// 固定大小为3的阻塞队列
		final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
		
		for (int i = 0; i < 2; i++) {
			// 往队列中放数据的队列
			new Thread() {
				public void run() {
					while (true) {
						try {
							Thread.sleep((long) (Math.random() * 1000));
							System.out.println(Thread.currentThread().getName() + " 准备放数据!");
							// 若队列满了则会阻塞
							queue.put(1);
							
							System.out.println(
									Thread.currentThread().getName() + " 已经放了数据，" + "队列目前有 " + queue.size() + " 个数据");
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}

			}.start();
		}
		
		// 从队列中取数据的队列
		new Thread() {
			public void run() {
				while (true) {
					try {
						// 将此处的睡眠时间分别改为100和1000，观察运行结果
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + " 准备取数据!");
						// 队列为空则阻塞
						queue.take();
						
						System.out
								.println(Thread.currentThread().getName() + " 已经取走数据，" + "队列目前有 " + queue.size() + " 个数据");
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}.start();
	}
}
