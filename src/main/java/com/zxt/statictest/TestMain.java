package com.zxt.statictest;

public class TestMain {
	static {
		System.out.println("static block1");
	}
	
	public static void main(String[] args) {
		// ��ִ��main����֮ǰ�����ȼ�������࣬���Լ�ʹmain������û����䣬��̬����黹�ǻ�ִ��
	}
	
	static {
		System.out.println("static block2");
	}
}
