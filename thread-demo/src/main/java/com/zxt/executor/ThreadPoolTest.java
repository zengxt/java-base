package com.zxt.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 
 * @Description: �����̳߳صļ��з���
 *
 * @author�� zxt
 *
 * @time: 2018��4��8�� ����7:44:28
 *
 */
public class ThreadPoolTest {

	public static void main(String[] args) {
		// �ӳ�delayʱ���ִ��
		Executors.newScheduledThreadPool(3).schedule(
				new Runnable() {
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName() + " bombing!!");
					}
				}, 
				3, 
				TimeUnit.SECONDS);
		
		// �̶�Ƶ�ʵĶ�ʱ��
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
				new Runnable() {
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName() + " bombing!!");
					}
				}, 
				4, 
				2,
				TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @Description:�̶���С���̳߳�
	 *
	 */
	@Test
	public void fixedThreadPoolTest() {
		// ����һ���̶���С���̳߳�
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		// ���̳߳������10������
		for (int i = 1; i <= 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					for (int j = 1; j <= 5; j++) {
						System.out.println(
								Thread.currentThread().getName() + " is looping of " + j + " for task " + task);
					}

				}
			});
		}
		
		// ���̳߳��е������̶߳�û��������ִ��ʱ���ر��̳߳�
		threadPool.shutdown();
	}
	
	/**
	 * 
	 * @Description:�ɱ��С���̳߳�
	 *
	 */
	@Test
	public void cachedThreadPoolTest() {
		// ����һ���ɱ��С���̳߳�
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// ���̳߳������10������
		for (int i = 1; i <= 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					for (int j = 1; j <= 5; j++) {
						System.out.println(
								Thread.currentThread().getName() + " is looping of " + j + " for task " + task);
					}

				}
			});
		}
		
		// ���̳߳��е������̶߳�û��������ִ��ʱ���ر��̳߳�
		threadPool.shutdown();
	}
	
	/**
	 * 
	 * @Description:���߳��̳߳أ��͵��̵߳��������ڣ�����ʼ���ܱ�����һ���߳��ڣ�
	 *
	 */
	@Test
	public void singleThreadExecutorTest() {
		// ����һ���ɱ��С���̳߳�
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		// ���̳߳������10������
		for (int i = 1; i <= 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					for (int j = 1; j <= 5; j++) {
						System.out.println(
								Thread.currentThread().getName() + " is looping of " + j + " for task " + task);
					}

				}
			});
		}
		
		// ���̳߳��е������̶߳�û��������ִ��ʱ���ر��̳߳�
		threadPool.shutdown();
	}
}
