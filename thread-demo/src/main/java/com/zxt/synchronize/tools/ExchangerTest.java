package com.zxt.synchronize.tools;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger<String> exchanger = new Exchanger<String>();
		
		service.execute(new Runnable() {
			public void run() {
				try {
					String data1 = Thread.currentThread().getName() + Math.random() * 10000;
					System.out.println("�߳�" + Thread.currentThread().getName() + "���ڰ����ݣ�" + data1 + "����ȥ");
					
					Thread.sleep((long) (Math.random() * 1000));
					String data2 = (String) exchanger.exchange(data1);
					System.out.println("�߳�" + Thread.currentThread().getName() + "���ص�����Ϊ��" + data2);
					
				} catch (Exception e) {

				}
			}
		});
		
		service.execute(new Runnable() {
			public void run() {
				try {
					String data1 = Thread.currentThread().getName() + Math.random() * 10000;
					System.out.println("�߳�" + Thread.currentThread().getName() + "���ڰ����ݣ�" + data1 + "����ȥ");
					
					Thread.sleep((long) (Math.random() * 1000));
					String data2 = (String) exchanger.exchange(data1);
					System.out.println("�߳�" + Thread.currentThread().getName() + "���ص�����Ϊ��" + data2);
					
				} catch (Exception e) {

				}
			}
		});
	}
}
