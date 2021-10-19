package com.zxt.timer;

import java.awt.Toolkit;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @Description: java.util.Timer��ʱ����ʵ�����Ǹ��̣߳���ʱ������ӵ�е�TimerTasks��
 *               һ��TimerTaskʵ���Ͼ���һ��ӵ��run�������࣬��Ҫ��ʱִ�еĴ���ŵ�run�������ڣ�TimerTaskһ������������ķ�ʽ������
 *
 * @author�� zxt
 *
 * @time: 2018��4��6�� ����5:01:48
 *
 */
public class TestTimer2 {
	private static Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	private static int count = 1;

	public static void main(String[] args) {
		
		TestTimer2 a = new TestTimer2();
		new Timer().schedule(a.new MyTimerTask(), 2000);
		
		// ��ӡ��ǰʱ��  ��
		while(true) {
			System.out.println(new Date().getTime());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 
	 * @Description: �̳�TimerTask��Ӧ����
	 *
	 * @author�� zxt
	 *
	 * @time: 2018��4��6�� ����5:05:17
	 *
	 */
	class MyTimerTask extends TimerTask {
		
		public void run() {
			// ��MyTimerTask���ڲ����ִ���һ����ʱ����Ȼ��һֱѭ��
			toolkit.beep();
			System.out.println("Timer runing!!!");
			
			// ÿ�μ����ʱ�䲻һ��
			count = (count + 1) % 2;
			System.out.println(count);
			new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count);
		}
	}
}
