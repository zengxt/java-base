package com.zxt.executor;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		// 接收一个Callable接口的实例对象, 返回一个Future对象
		Future<String> future = threadPool.submit(new Callable<String>() {
			
			// 覆盖Callable接口中的call方法，抛出异常
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "hello!";
			}
		});

		System.out.println("等待结果");
		try {
			System.out.println("拿到结果：" + future.get());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CompletionService使用实例：按照任务完成的顺序处理它们的结果
		ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);
		// 提交10个任务
		for(int i = 1; i <= 10; i++) {
			final int seq = i;
			completionService.submit(new Callable<Integer>() {
				
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return seq;
				}
			});
		}
		
		// 获取任务的返回结果
		for(int i = 1; i <= 10; i++) {
			try {
				System.out.println(completionService.take().get());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
