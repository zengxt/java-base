package com.zxt.codeblock;

public class ParentTest {
	public static String PARENT_STATIC_FIELD = "父类-静态属性";

	// 父类-静态块
	static {
		System.out.println(PARENT_STATIC_FIELD);
		System.out.println("父类-静态代码块");
	}

	public static String parentField = "父类-非静态属性";

	// 父类-非静态块
	{
		System.out.println(parentField);
		System.out.println("父类-非静态代码块");
	}

	public ParentTest() {
		System.out.println("父类—无参构造函数");
	}
}
