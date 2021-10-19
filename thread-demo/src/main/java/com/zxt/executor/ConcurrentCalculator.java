package com.zxt.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 
 * @Description: ���м�������ĺ�
 *
 * @author�� zxt
 *
 * @time: 2018��4��8�� ����8:19:28
 *
 */
public class ConcurrentCalculator {
	
	private ExecutorService exec;
	private int cpuCoreNumber;
	private List<Future<Long>> tasks = new ArrayList<Future<Long>>();
	
	public ConcurrentCalculator() {
		// �õ�cpu�ں˵ĸ���
		cpuCoreNumber = Runtime.getRuntime().availableProcessors();
		// �м���cpu���򴴽��м����̵߳��̳߳�
		exec = Executors.newFixedThreadPool(cpuCoreNumber);
	}
	
	public void close() {
        exec.shutdown();
    }
	
	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11 };
		ConcurrentCalculator calc = new ConcurrentCalculator();
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
			// FutureTask<V>ʵ����Future<V>��Runable<V>
			FutureTask<Long> task = new FutureTask<Long>(subCalc);
			tasks.add(task);
			if (!exec.isShutdown()) {
				// ��Ϊ FutureTask ʵ���� Runnable�����Կɽ� FutureTask �ύ�� Executor ִ�С�
				exec.submit(task);
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
		for (Future<Long> task : tasks) {
			try {
				// �������δ���������  (Future�б������Callable��ִ�н��������ʹ��get�õ�)
				Long subSum = task.get();
				result += subSum;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
