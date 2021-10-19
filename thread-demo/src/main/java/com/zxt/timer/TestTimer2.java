package com.zxt.timer;

import java.awt.Toolkit;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @Description: java.util.Timer定时器，实际上是个线程，定时调度所拥有的TimerTasks。
 *               一个TimerTask实际上就是一个拥有run方法的类，需要定时执行的代码放到run方法体内，TimerTask一般是以匿名类的方式创建。
 *
 * @author： zxt
 *
 * @time: 2018年4月6日 下午5:01:48
 *
 */
public class TestTimer2 {
	private static Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	private static int count = 1;

	public static void main(String[] args) {
		
		TestTimer2 a = new TestTimer2();
		new Timer().schedule(a.new MyTimerTask(), 2000);
		
		// 打印当前时间  秒
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
	 * @Description: 继承TimerTask的应用类
	 *
	 * @author： zxt
	 *
	 * @time: 2018年4月6日 下午5:05:17
	 *
	 */
	class MyTimerTask extends TimerTask {
		
		public void run() {
			// 在MyTimerTask的内部，又创建一个定时器，然后一直循环
			toolkit.beep();
			System.out.println("Timer runing!!!");
			
			// 每次间隔的时间不一样
			count = (count + 1) % 2;
			System.out.println(count);
			new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count);
		}
	}
}
