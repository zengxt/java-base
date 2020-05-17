package com.zxt.codeblock;

public class ChildTest extends ParentTest {
	public static String STATIC_FIELD = "子类-静态属性";

	// 静态块
	static {
		System.out.println(STATIC_FIELD);
		System.out.println("子类-静态代码块");
	}

	public String field = "子类-非静态属性";

	// 非静态块
	{
		System.out.println(field);
		System.out.println("子类-非静态代码块");
	}

	public ChildTest() {
		System.out.println("子类-无参构造函数");
	}

	public static void main(String[] args) {
		new ChildTest();
	}
}
