package com.zxt.math;

public class MathTest {

	public static void main(String[] args) {
		System.out.println("round：四舍五入，返回整数");
		System.out.println(Math.round(11.46));  // 11
		System.out.println(Math.round(-11.46));  // -11
		System.out.println(Math.round(11.68));  // 12
		System.out.println(Math.round(-11.68));  // -12

		System.out.println("ceil：向上取整，返回浮点数");
		System.out.println(Math.ceil(11.46));  // 12.0
		System.out.println(Math.ceil(11.68));  // 12.0
		System.out.println(Math.ceil(-11.46));  // -11.0
		System.out.println(Math.ceil(-11.68));  // -11.0

		System.out.println("floor：向下取整，返回浮点数");
		System.out.println(Math.floor(11.46));  // 11.0
		System.out.println(Math.floor(11.68));  // 11.0
		System.out.println(Math.floor(-11.46));  // -12.0
		System.out.println(Math.floor(-11.68));  // -12.0
	}
}
