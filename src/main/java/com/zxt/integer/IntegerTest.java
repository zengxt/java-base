package com.zxt.integer;

public class IntegerTest {

	public static void main(String[] args) {
		// highestOneBit：返回具有至多单个 1 位的 int 值，在指定的 int 值中最高位（最左边）的 1 位的位置。
		// 意思就是保留改数的最高位的1，其余数字置为0。即获得一个跟它最靠近的比它小的2的N次方（若参数为负数，返回-2147483648）
		// 0001 0001 ---> 0001 0000
		System.out.println(Integer.highestOneBit(17));
		// 1111 ---> 1000
		System.out.println(Integer.highestOneBit(15));
		System.out.println(Integer.highestOneBit(32));
		System.out.println(Integer.highestOneBit(63));
		System.out.println(Integer.highestOneBit(0));
		System.out.println(Integer.highestOneBit(-1));
		
		
		// lowestOneBit(int i)：返回具有至多单个 1 位的 int 值，在指定的 int 值中最低位（最右边）的 1 位的位置。
		// 即最低一位1保留，其余位置为0.
		// 0001 0001 ---> 0000 0001
		System.out.println(Integer.lowestOneBit(17));
		// 1100 ---> 0100
		System.out.println(Integer.lowestOneBit(12));
		
		
		// rotateLeft(int i, int distance)：返回根据指定的位数循环左移指定的 int 值的二进制补码表示形式而得到的值。
		// 二进制左移一位相当于乘以2，左移distance相当于乘以2^distance
		System.out.println(Integer.rotateLeft(12, 3));
		System.out.println(Integer.rotateLeft(3, 2));
		// rotateRight(int i, int distance)：返回根据指定的位数循环右移指定的 int 值的二进制补码表示形式而得到的值。
		// 二进制右移一位相当于除以2，左移distance相当于除以2^distance
		System.out.println(Integer.rotateRight(12, 2));
		
		
		// 不同进制之间互相转换 
		// 字符串十进制转成二进制
		System.out.println(Integer.toBinaryString(14));
		System.out.println(Integer.toString(14, 2));
		// 字符串十进制转成八进制
		System.out.println(Integer.toOctalString(14));
		System.out.println(Integer.toString(14, 8));
		// 字符串十进制转成十六进制
		System.out.println(Integer.toHexString(14));
		System.out.println(Integer.toString(14, 16));
		// toString可以方便得将Integer转换为任意进制
		System.out.println(Integer.toString(14, 7));
		
		// valueOf以及parseInt可将任意进制表示的字符串转换为Integer
		// 提供的进制参数表示用该进制基数来解析字符串，转换为10进制的int值
		System.out.println(Integer.valueOf("0110", 2));
		System.out.println(Integer.valueOf("A6", 16));
		System.out.println(Integer.parseInt("0110", 2));
		System.out.println(Integer.parseInt("A6", 16));
	}
}
