package com.zxt.statictest;

public class TestMain {
	static {
		System.out.println("static block1");
	}
	
	public static void main(String[] args) {
		// 在执行main方法之前会首先加载这个类，所以即使main方法中没有语句，静态代码块还是会执行
	}
	
	static {
		System.out.println("static block2");
	}
}
