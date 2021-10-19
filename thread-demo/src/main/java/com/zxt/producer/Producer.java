package com.zxt.producer;

public class Producer extends Thread {
	// 生产产品的数量
	private int neednum;
	// 仓库
	private Godown godown;

	Producer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run() {
		// 生产指定数量的产品
		godown.produce(neednum);
	}
}