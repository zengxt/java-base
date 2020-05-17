package com.zxt.timer;

// import java.util.TimerTask;

/*
public interface TimerInterface {
	// true:说明这个timer以daemon方式运行（优先级低，程序结束timer也自动结束）
	// 注意，javax.swing包中也有一个Timer类，如果import中用到swing包，要注意名字的冲突。
	java.util.Timer timer = new java.util.Timer(true);

	TimerTask task = new TimerTask() {   
		public void run() {
			... // 每次需要执行的代码放到这里面。   
		}
	};
	  
	//以下是几种调度task的方法:
	
	// time为Date类型：在指定时间执行一次。
	timer.schedule(task, time);
	
	// firstTime为Date类型,period为long   
	// 从firstTime时刻开始，每隔period毫秒执行一次。
	timer.schedule(task, firstTime, period);
	   
	// delay 为long类型：从现在起过delay毫秒执行一次   
	timer.schedule(task, delay);
	
	// delay为long, period为long：从现在起过delay毫秒以后，每隔period毫秒执行一次。  
	timer.schedule(task, delay, period);
	
	// 安排指定的任务在指定的时间开始进行重复的固定速率执行。
	timer.scheduleAtFixedRate(task, firstTime, period);
    
	// 安排指定的任务在指定的延迟后开始进行重复的固定速率执行。
	timer.scheduleAtFixedRate(task, delay, period);
}
*/