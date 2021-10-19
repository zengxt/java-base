package com.zxt.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @Description: 并行计算数组的和
 *
 * @author： zxt
 *
 * @time: 2018年4月8日 下午8:19:28
 *
 */
public class ConcurrentCalculator2 {
	
	private ExecutorService exec;
	private int cpuCoreNumber;
	private CompletionService<Long> completionService;
	
	public ConcurrentCalculator2() {
		// 得到cpu内核的个数
		cpuCoreNumber = Runtime.getRuntime().availableProcessors();
		// 有几个cpu，则创建有几个线程的线程池
		exec = Executors.newFixedThreadPool(cpuCoreNumber);
		// 按照任务完成的顺序处理它们的结果
		completionService = new ExecutorCompletionService<Long>(exec);
	}
	
	public void close() {
        exec.shutdown();
    }
	
	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11 };
		ConcurrentCalculator2 calc = new ConcurrentCalculator2();
		Long sum = calc.sum(numbers);
		System.out.println(sum);
		calc.close();
	}

	// 内部类，实现Callable接口，将其实例提交给Executor可执行
	class SumCalculator implements Callable<Long> {
		private int[] numbers;
		private int start;
		private int end;

		public SumCalculator(final int[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}

		public Long call() throws Exception {
			Long sum = 0l;
			for (int i = start; i < end; i++) {
				sum += numbers[i];
			}
			
			return sum;
		}
	}


	public Long sum(final int[] numbers) {
		// 根据CPU核心个数拆分任务，创建FutureTask并提交到Executor
		for (int i = 0; i < cpuCoreNumber; i++) {
			// 将数组分成多端，使用多个任务计算
			int increment = numbers.length / cpuCoreNumber + 1;
			int start = increment * i;
			int end = increment * i + increment;
			if (end > numbers.length) {
				end = numbers.length;
			}
			
			SumCalculator subCalc = new SumCalculator(numbers, start, end);
			if (!exec.isShutdown()) {
				// 通过CompletionService服务提交Callable任务执行
				completionService.submit(subCalc);
			}
		}
		
		return getResult();
	}

	/**
	 * 迭代每个只任务，获得部分和，相加返回
	 * 
	 * @return
	 */
	public Long getResult() {
		Long result = 0l;
		for (int i = 0; i < cpuCoreNumber; i++) {
			try {
				// 按任务完成的顺序得到返回结果
				Long subSum = completionService.take().get();
				result += subSum;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
