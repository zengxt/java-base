package com.zxt.locks;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @Description: 实现一个类似于缓存系统的功能：多个线程读某个数据，若发现数据为空，则由一个线程写数据
 *
 * @author： zxt
 *
 * @time: 2018年4月9日 下午10:36:50
 *
 */
public class CacheDemo {

	// 定义一个读写锁
	private static ReadWriteLock rwLock = new ReentrantReadWriteLock();

	// 存储数据的 map
	private static Map<String, Object> map = new HashMap<String, Object>();

	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			final String key = i + "";
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						System.out.println(Thread.currentThread().getName() + " read data： " + getData(key));
					}
				}
			}).start();
		}
	}

	/**
	 * 
	 * @Description:通过key来取数据，若没有，则写，用读写锁来同步
	 * 
	 * @param key
	 * @return
	 */
	public static Object getData(String key) {
		// 首先尝试读取数据，加读锁
		rwLock.readLock().lock();
		Object value = null;
		try {
			value = map.get(key);
			if (value == null) {
				// 没有数据可供读取，则尝试写入数据
				// 先释放读锁，在加写锁
				rwLock.readLock().unlock();
				rwLock.writeLock().lock();

				try {
					// 假设此时有多个线程同时去获取写锁,我们知道只有第一个线程能够获取，那么其他的线程只能等待。
					// 如果第一个线程按流程执行完后，刚才等待的线程可以得到写锁了， 然后接着就可以修改数据了(赋值)。所以加上再次判断!
					if (value == null) {
						// 此处在实际应用中，可能就是从数据库中查找数据，放入缓存中
						value = Thread.currentThread().getName() + new Date();
					}

				} finally {
					// 写数据结束，释放写锁
					rwLock.writeLock().unlock();
				}

				// 此时需要再次加上读锁，读取数据
				rwLock.readLock().lock();
			}

		} finally {
			rwLock.readLock().unlock();
		}

		return value;
	}
}
