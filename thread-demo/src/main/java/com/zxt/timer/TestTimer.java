package com.zxt.timer;

import java.awt.Toolkit;
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
public class TestTimer {
	private static Toolkit toolkit = Toolkit.getDefaultToolkit();

	public static void main(String[] args) {
		Timer timer = new Timer();
		
		// ����TimerTask�࣬1���ʼִ�У�ÿ��2��ִ��һ��
		timer.schedule(new TimerTask() {
			int runTime = 5;

			public void run() {
				if (runTime > 0) {
					toolkit.beep();
					System.out.println("This run is" + runTime);
					runTime--;

				} else {
					toolkit.beep();
					System.out.println("Time is up");
					System.exit(0);
				}
			}
		}, 1000, 2000);

		timer.schedule(new RemindTask(), 1000, 2000);
	}
}

// �̳�TimerTask��Ӧ����
class RemindTask extends TimerTask {
	public void run() {
		System.out.println("Time's up!");
	}
}
