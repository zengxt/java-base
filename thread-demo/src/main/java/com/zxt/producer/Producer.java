package com.zxt.producer;

public class Producer extends Thread {
	// ������Ʒ������
	private int neednum;
	// �ֿ�
	private Godown godown;

	Producer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run() {
		// ����ָ�������Ĳ�Ʒ
		godown.produce(neednum);
	}
}