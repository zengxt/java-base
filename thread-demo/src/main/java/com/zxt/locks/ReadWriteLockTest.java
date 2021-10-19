package com.zxt.locks;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	public static void main(String[] args) {
		final Mydata mydata = new Mydata();
		
		// ����6���̣߳�3������3��д
		for(int i = 0; i < 3; i++) {
			// ���߳�
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						mydata.get();
					}
				}
			}).start();
			
			// д�߳�
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
 * @Description: ���������࣬�����л�ȡ���ݵĶ������ʹ�����ݵ�д����
 *
 * @author�� zxt
 *
 * @time: 2018��4��9�� ����4:29:26
 *
 */
class Mydata {
	// �������ݣ�ֻ����һ���߳���д�����ݣ��������ж���߳�ͬʱ�������ݡ�
	private Object data = null;
	
	// ��д���������ﲻ��ʹ��Lock����ΪLock����ֹ���е��̣߳��������ݵ�ʱ����Զ���߳�ͬʱ����
	ReadWriteLock rwLock = new ReentrantReadWriteLock();

	/**
	 * 
	 * @Description:��ȡ����
	 *
	 */
	public void get() {
		// �����ݣ��϶���
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
	 * @Description:�������
	 *
	 */
	public void put(Object data) {
		// д������д��
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
