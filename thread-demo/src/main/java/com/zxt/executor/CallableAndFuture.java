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
		// ����һ��Callable�ӿڵ�ʵ������, ����һ��Future����
		Future<String> future = threadPool.submit(new Callable<String>() {
			
			// ����Callable�ӿ��е�call�������׳��쳣
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "hello!";
			}
		});

		System.out.println("�ȴ����");
		try {
			System.out.println("�õ������" + future.get());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CompletionServiceʹ��ʵ��������������ɵ�˳�������ǵĽ��
		ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);
		// �ύ10������
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
		
		// ��ȡ����ķ��ؽ��
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
