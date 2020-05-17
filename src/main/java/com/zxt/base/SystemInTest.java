package com.zxt.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * @Description: BufferReader �� Scanner ���ֲ�ͬ�����뷽����Ӧ��
 *
 * @author�� zxt
 *
 * @time: 2018��3��5�� ����3:29:12
 *
 */
public class SystemInTest {

	private static Scanner sc;

	public static void main(String[] args) {
		// ʹ��Scanner����
		sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println("num1 + num2 = " + (num1 + num2));

		// ʹ��BufferReader����
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int num3 = Integer.parseInt(br.readLine());
			int num4 = Integer.parseInt(br.readLine());
			System.out.println("num3 + num4 = " + (num3 + num4));

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		
		// ʹ��Scanner���������������
		System.out.println();
		System.out.print("Enter an Integer:");
		int intValue = sc.nextInt();
		System.out.print("Enter a String:");
		String strValue = sc.nextLine();
		System.out.printf("You have entered intValue is " + intValue + " and strValue is " + strValue);
		
		// ����ԭ������nextXXX()�������Ի��з�������nextLine()�������������������������nextXXX()��������ʹ��nextLine()�����������
		// ��������ǣ���ʹ��nextXXX()��������ʹ��nextLine()��ȡ��һ������ǰ����ʹ��һ��nextLine()�������Ļ��з�
		// int intValue = sc.nextInt();
		// sc.nextLine();
		// String strValue = sc.nextLine();
		
		// ����ʹ��BufferReader������ָ�����
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
