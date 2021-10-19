package com.zxt.locks;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	public static void main(String[] args) {
		final Mydata mydata = new Mydata();
		
		// 构造6个线程，3个读，3个写
		for(int i = 0; i < 3; i++) {
			// 读线程
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						mydata.get();
					}
				}
			}).start();
			
			// 写线程
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						mydata.put(new Random().nextInt(10000));
					}
				}
			}).start();
		}
	}
}

/**
 * 
 * @Description: 共线数据类，里面有获取数据的读方法和存放数据的写方法
 *
 * @author： zxt
 *
 * @time: 2018年4月9日 下午4:29:26
 *
 */
class Mydata {
	// 共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据。
	private Object data = null;
	
	// 读写锁，（这里不能使用Lock，因为Lock会阻止所有的线程，而读数据的时候可以多个线程同时读）
	ReadWriteLock rwLock = new ReentrantReadWriteLock();

	/**
	 * 
	 * @Description:获取数据
	 *
	 */
	public void get() {
		// 读数据，上读锁
		rwLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " is ready to read data!");
			Thread.sleep((long) Math.random() * 1000);
			System.out.println(Thread.currentThread().getName() + " have read data :" + data);

		} catch (InterruptedException e) {
			e.printStackTrace();
			
		} finally {
			rwLock.readLock().unlock();
		}
	}

	/**
	 * 
	 * @Description:存放数据
	 *
	 */
	public void put(Object data) {
		// 写数据上写锁
		rwLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " is ready to write data!");
			Thread.sleep((long) Math.random() * 1000);
			this.data = data;
			System.out.println(Thread.currentThread().getName() + " have write data :" + data);

		} catch (InterruptedException e) {
			e.printStackTrace();
			
		} finally {
			rwLock.writeLock().unlock();
		}
	}
}
