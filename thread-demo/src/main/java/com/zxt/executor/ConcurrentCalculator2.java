package com.zxt.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @Description: ���м�������ĺ�
 *
 * @author�� zxt
 *
 * @time: 2018��4��8�� ����8:19:28
 *
 */
public class ConcurrentCalculator2 {
	
	private ExecutorService exec;
	private int cpuCoreNumber;
	private CompletionService<Long> completionService;
	
	public ConcurrentCalculator2() {
		// �õ�cpu�ں˵ĸ���
		cpuCoreNumber = Runtime.getRuntime().availableProcessors();
		// �м���cpu���򴴽��м����̵߳��̳߳�
		exec = Executors.newFixedThreadPool(cpuCoreNumber);
		// ����������ɵ�˳�������ǵĽ��
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

	// �ڲ��࣬ʵ��Callable�ӿڣ�����ʵ���ύ��Executor��ִ��
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
		// ����CPU���ĸ���������񣬴���FutureTask���ύ��Executor
		for (int i = 0; i < cpuCoreNumber; i++) {
			// ������ֳɶ�ˣ�ʹ�ö���������
			int increment = numbers.length / cpuCoreNumber + 1;
			int start = increment * i;
			int end = increment * i + increment;
			if (end > numbers.length) {
				end = numbers.length;
			}
			
			SumCalculator subCalc = new SumCalculator(numbers, start, end);
			if (!exec.isShutdown()) {
				// ͨ��CompletionService�����ύCallable����ִ��
				completionService.submit(subCalc);
			}
		}
		
		return getResult();
	}

	/**
	 * ����ÿ��ֻ���񣬻�ò��ֺͣ���ӷ���
	 * 
	 * @return
	 */
	public Long getResult() {
		Long result = 0l;
		for (int i = 0; i < cpuCoreNumber; i++) {
			try {
				// ��������ɵ�˳��õ����ؽ��
				Long subSum = completionService.take().get();
				result += subSum;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
