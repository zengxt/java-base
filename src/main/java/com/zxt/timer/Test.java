package com.zxt.timer;

import java.util.Timer;

public class Test {

	public static void main(String[] args) {
		Timer timer = new Timer();
		// ��1���,ÿ��2��ִ��һ�γ��� 
		timer.schedule(new TimerTaskTest(), 1000, 2000);
	}
}