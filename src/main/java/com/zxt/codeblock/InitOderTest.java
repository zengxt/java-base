package com.zxt.codeblock;

/**
 * 
 * @Description: 不同代码块的执行顺序测试
 *
 * @author： zxt
 *
 * @time: 2018年4月3日 上午9:55:22
 *
 */
public class InitOderTest {
	public static String STATIC_FIELD = "静态属性";
	
	public static void main(String[] args) {
		new InitOderTest();
	}

	// 静态块（最先执行，只执行一次）
	static {
		System.out.println(STATIC_FIELD);
		System.out.println("静态代码块");
	}

	public String field = "非静态属性";

	// 非静态块（构造代码块，每次new对象，执行构造方法之前执行）
	{
		System.out.println(field);
		System.out.println("非静态代码块");
	}

	public InitOderTest() {
		System.out.println("无参构造函数");
	}
}
