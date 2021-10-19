package com.zxt.producer;

public class Consumer extends Thread {
	// 生产产品的数量
	private int neednum;
	// 仓库
	private Godown godown;

	Consumer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run() {
		// 消费指定数量的产品
		godown.consume(neednum);
	}
}