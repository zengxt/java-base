package com.zxt.math;

public class MathTest {

	public static void main(String[] args) {
		System.out.println("round���������룬��������");
		System.out.println(Math.round(11.46));  // 11
		System.out.println(Math.round(-11.46));  // -11
		System.out.println(Math.round(11.68));  // 12
		System.out.println(Math.round(-11.68));  // -12

		System.out.println("ceil������ȡ�������ظ�����");
		System.out.println(Math.ceil(11.46));  // 12.0
		System.out.println(Math.ceil(11.68));  // 12.0
		System.out.println(Math.ceil(-11.46));  // -11.0
		System.out.println(Math.ceil(-11.68));  // -11.0

		System.out.println("floor������ȡ�������ظ�����");
		System.out.println(Math.floor(11.46));  // 11.0
		System.out.println(Math.floor(11.68));  // 11.0
		System.out.println(Math.floor(-11.46));  // -12.0
		System.out.println(Math.floor(-11.68));  // -12.0
	}
}
