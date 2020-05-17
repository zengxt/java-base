package com.zxt.statictest;

public class Test1 extends Base {
	static {
		System.out.println("test static");
	}

	public Test1() {
		System.out.println("test constructor");
		super.a(); // super语句建议放在构造器的最前面
		System.out.println(super.aa);
	}

	public static void main(String[] args) {
		new Test1();
		
	}
}

class Base {
	public int aa = 0;
	public int a() {
		return 1;
	}
	static {
		System.out.println("base static");
	}

	public Base() {
		System.out.println("base constructor");
	}
}