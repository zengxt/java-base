package com.zxt.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * @Description: BufferReader 与 Scanner 两种不同的输入方法的应用
 *
 * @author： zxt
 *
 * @time: 2018年3月5日 下午3:29:12
 *
 */
public class SystemInTest {

	private static Scanner sc;

	public static void main(String[] args) {
		// 使用Scanner输入
		sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println("num1 + num2 = " + (num1 + num2));

		// 使用BufferReader输入
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int num3 = Integer.parseInt(br.readLine());
			int num4 = Integer.parseInt(br.readLine());
			System.out.println("num3 + num4 = " + (num3 + num4));

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		
		// 使用Scanner输入会遇到的问题
		System.out.println();
		System.out.print("Enter an Integer:");
		int intValue = sc.nextInt();
		System.out.print("Enter a String:");
		String strValue = sc.nextLine();
		System.out.printf("You have entered intValue is " + intValue + " and strValue is " + strValue);
		
		// 问题原因：由于nextXXX()方法忽略换行符，但是nextLine()并不忽略它。所以如果我们在nextXXX()方法后面使用nextLine()将会出现问题
		// 解决方案是：在使用nextXXX()方法后，在使用nextLine()读取下一行数据前，多使用一个nextLine()用来消耗换行符
		// int intValue = sc.nextInt();
		// sc.nextLine();
		// String strValue = sc.nextLine();
		
		// 或者使用BufferReader不会出现该问题
		System.out.println();
		try {
			System.out.print("Enter an Integer:");
			int intValue1 = Integer.parseInt(br.readLine());
			System.out.print("Enter a String:");
			String strValue1 = br.readLine();
			System.out.printf("You have entered intValue1 is " + intValue1 + " and strValue1 is " + strValue1);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
