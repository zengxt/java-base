package com.zxt.base;

public class StaticVarTest {
	static int i = 1;
	static {
		// 该静态区域块只被执行一次
		i++;
		System.out.println("执行一次");
	}

	// 建立StaticVarTest()构造函数
	public StaticVarTest() {
		System.out.println("执行二次");
		i++;
	}

	public static void main(String[] args) {
		// 创建t1对象实例并调用StaticVarTest函数
		new StaticVarTest(); 
		System.out.println(StaticVarTest.i);

		new StaticVarTest();
		System.out.println(StaticVarTest.i);
	}
}