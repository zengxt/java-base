package com.zxt.timer;

import java.awt.Toolkit;
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
public class TestTimer {
	private static Toolkit toolkit = Toolkit.getDefaultToolkit();

	public static void main(String[] args) {
		Timer timer = new Timer();
		
		// 匿名TimerTask类，1秒后开始执行，每隔2秒执行一次
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

// 继承TimerTask的应用类
class RemindTask extends TimerTask {
	public void run() {
		System.out.println("Time's up!");
	}
}
