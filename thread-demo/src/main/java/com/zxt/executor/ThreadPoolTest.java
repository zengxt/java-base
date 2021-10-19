package com.zxt.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 
 * @Description: 创建线程池的集中方法
 *
 * @author： zxt
 *
 * @time: 2018年4月8日 下午7:44:28
 *
 */
public class ThreadPoolTest {

	public static void main(String[] args) {
		// 延迟delay时间后执行
		Executors.newScheduledThreadPool(3).schedule(
				new Runnable() {
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName() + " bombing!!");
					}
				}, 
				3, 
				TimeUnit.SECONDS);
		
		// 固定频率的定时器
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
	 * @Description:固定大小的线程池
	 *
	 */
	@Test
	public void fixedThreadPoolTest() {
		// 创建一个固定大小的线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		// 往线程池中添加10个任务
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
		
		// 当线程池中的所有线程都没有任务在执行时，关闭线程池
		threadPool.shutdown();
	}
	
	/**
	 * 
	 * @Description:可变大小的线程池
	 *
	 */
	@Test
	public void cachedThreadPoolTest() {
		// 创建一个可变大小的线程池
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// 往线程池中添加10个任务
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
		
		// 当线程池中的所有线程都没有任务在执行时，关闭线程池
		threadPool.shutdown();
	}
	
	/**
	 * 
	 * @Description:单线程线程池（和单线程的区别在于，池中始终能保持有一个线程在）
	 *
	 */
	@Test
	public void singleThreadExecutorTest() {
		// 创建一个可变大小的线程池
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		// 往线程池中添加10个任务
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
		
		// 当线程池中的所有线程都没有任务在执行时，关闭线程池
		threadPool.shutdown();
	}
}
