package com.zxt.producer;

public class Consumer extends Thread {
	// ������Ʒ������
	private int neednum;
	// �ֿ�
	private Godown godown;

	Consumer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run() {
		// ����ָ�������Ĳ�Ʒ
		godown.consume(neednum);
	}
}