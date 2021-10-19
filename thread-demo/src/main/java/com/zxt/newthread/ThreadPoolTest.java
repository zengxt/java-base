package com.zxt.newthread;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ThreadPoolTest {
	private static Scanner in;

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
		String directory = in.nextLine();
		System.out.print("Enter keyword (e.g. volatile): ");
		String keyword = in.nextLine();

		ExecutorService pool = Executors.newCachedThreadPool();

		MatchCounter counter = new MatchCounter(new File(directory), keyword,
				pool);
		Future<Integer> result = pool.submit(counter);

		try {
			System.out.println(result.get() + " matching files.");
			
		} catch (ExecutionException e) {
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			
		}
		pool.shutdown();

		int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("largest pool size=" + largestPoolSize);
	}
}

class MatchCounter implements Callable<Integer> {
	private File directory;
	private String keyword;
	private ExecutorService pool;
	private int count;

	public MatchCounter(File directory, String keyword, ExecutorService pool) {
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}

	public Integer call() {
		count = 0;
		try {
			File[] files = directory.listFiles();
			ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();

			for (File file : files)
				if (file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyword, pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);
					
				} else {
					if (search(file))
						count++;
				}

			for (Future<Integer> result : results)
				try {
					count += result.get();
					
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
		} catch (InterruptedException e) {
			
		}
		
		return count;
	}

	public boolean search(File file) {
		try {
			Scanner in = new Scanner(new FileInputStream(file));
			boolean found = false;
			while (!found && in.hasNextLine()) {
				String line = in.nextLine();
				if (line.contains(keyword))
					found = true;
			}
			in.close();
			return found;
			
		} catch (IOException e) {
			return false;
		}
	}
}