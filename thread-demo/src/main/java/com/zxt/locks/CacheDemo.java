package com.zxt.locks;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @Description: ʵ��һ�������ڻ���ϵͳ�Ĺ��ܣ�����̶߳�ĳ�����ݣ�����������Ϊ�գ�����һ���߳�д����
 *
 * @author�� zxt
 *
 * @time: 2018��4��9�� ����10:36:50
 *
 */
public class CacheDemo {

	// ����һ����д��
	private static ReadWriteLock rwLock = new ReentrantReadWriteLock();

	// �洢���ݵ� map
	private static Map<String, Object> map = new HashMap<String, Object>();

	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			final String key = i + "";
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						System.out.println(Thread.currentThread().getName() + " read data�� " + getData(key));
					}
				}
			}).start();
		}
	}

	/**
	 * 
	 * @Description:ͨ��key��ȡ���ݣ���û�У���д���ö�д����ͬ��
	 * 
	 * @param key
	 * @return
	 */
	public static Object getData(String key) {
		// ���ȳ��Զ�ȡ���ݣ��Ӷ���
		rwLock.readLock().lock();
		Object value = null;
		try {
			value = map.get(key);
			if (value == null) {
				// û�����ݿɹ���ȡ������д������
				// ���ͷŶ������ڼ�д��
				rwLock.readLock().unlock();
				rwLock.writeLock().lock();

				try {
					// �����ʱ�ж���߳�ͬʱȥ��ȡд��,����֪��ֻ�е�һ���߳��ܹ���ȡ����ô�������߳�ֻ�ܵȴ���
					// �����һ���̰߳�����ִ����󣬸ղŵȴ����߳̿��Եõ�д���ˣ� Ȼ����žͿ����޸�������(��ֵ)�����Լ����ٴ��ж�!
					if (value == null) {
						// �˴���ʵ��Ӧ���У����ܾ��Ǵ����ݿ��в������ݣ����뻺����
						value = Thread.currentThread().getName() + new Date();
					}

				} finally {
					// д���ݽ������ͷ�д��
					rwLock.writeLock().unlock();
				}

				// ��ʱ��Ҫ�ٴμ��϶�������ȡ����
				rwLock.readLock().lock();
			}

		} finally {
			rwLock.readLock().unlock();
		}

		return value;
	}
}
