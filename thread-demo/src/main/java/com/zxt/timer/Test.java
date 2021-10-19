package com.zxt.timer;

import java.util.Timer;

public class Test {

	public static void main(String[] args) {
		Timer timer = new Timer();
		// 在1秒后,每隔2秒执行一次程序 
		timer.schedule(new TimerTaskTest(), 1000, 2000);
	}
}