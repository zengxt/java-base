package com.zxt.base;

/*
 * java移位操作符详解
 * 首先，移位运算符有三种，其操作类型只支持：byte / short / char / int和long五种。
 * <<	：左移运算符，表示将左边的操作数的二进制数据向左移动n位，移动后空缺位以0填充，多余位舍弃。（等同于乘2的n次方）
 * >>	：右移运算符，二进制数据向右移动n位，（等同于除2的n次方）  >>是带符号右移，负数高位补1，正数补0
 * >>>	：无符号右移运算符，不管移动前最高位是0还是1，右移后左侧产生的空位部分都以0来填充。
 */
public class MoveBitTest {

	public static void main(String[] args) {
		int a = 13;
		System.out.println("移动前 a = " + a + ", 二进制表示为：" + Integer.toBinaryString(a));

		int b = a << 2; // a左移两位，相当于a * 2的2次方
		System.out.println("左移后 a = " + b + ", 二进制表示为：" + Integer.toBinaryString(b));

		int c = a >> 2; // a右移两位，相当于a / 2的2次方
		System.out.println("右移后 a = " + c + ", 二进制表示为：" + Integer.toBinaryString(c));

		int d = -12;
		System.out.println("移动前 d = " + d + ", 二进制表示为：" + Integer.toBinaryString(d));
		System.out.println(bitInfo(d));

		// 带符号右移
		int e = d >> 2;
		System.out.println("带符号右移后 d = " + e + ", 二进制表示为：" + Integer.toBinaryString(e));
		// 无符号右移
		int f = d >>> 2;
		System.out.println("无符号右移后 d = " + f + ", 二进制表示为：" + Integer.toBinaryString(f));
	}
	
	private static String bitInfo(int num) {
		StringBuffer str = new StringBuffer();
		
		String binaryStr = Integer.toBinaryString(num);
		int i = 0;
		while(i < binaryStr.length()) {
			str.append(binaryStr.substring(i, i+4));
			str.append(" ");
			i += 4;
		}
		
		return str.toString();
	}
}