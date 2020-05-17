package com.zxt.integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 问题描述
   给定n个十六进制正整数，输出它们对应的八进制数。
   
   输入格式： 输入的第一行为一个正整数n （1<=n<=10）。
                        接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
   输出格式： 输出n行，每行为输入对应的八进制正整数。
 
   注意： 输入的十六进制数不会有前导0，比如012A。 输出的八进制数也不能有前导0。

   样例输入
 2
 39
 123ABC
   样例输出
 71
 4435274
 
   提示： 先将十六进制数转换成某进制数，再由某进制数转换成八进制。

 */

public class Main14 {

	public static void main(String args[]) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}
		for (int j = 0; j < n; j++) {
			transform(str[j]);
		}
		
		// 可以直接使用Integer类的方法实现转化
		// valueOf(String s, int radix) 返回一个 Integer 对象，该对象中保存了用第二个参数提供的基数进行解析时从指定的 String 中提取的值。
		for (int j = 0; j < n; j++) {
			// 输入的是16进制的字符串，先将其转换为整数
			int int_16 = Integer.valueOf(str[j], 16);
			// toOctalString(int i)：以八进制（基数 8）无符号整数形式返回一个整数参数的字符串表示形式。
			String str_8 = Integer.toOctalString(int_16);
			
			System.out.println(str_8);
		}
	}

	public static void transform(String s) {
		StringBuffer st = new StringBuffer();
		char c[] = s.toCharArray();
		// 将十六进制转化为二进制字符串
		for (int i = 0; i < c.length; i++) {
			switch (c[i]) {
				case '0': {
					st.append("0000");
					break;
				}
				case '1': {
					st.append("0001");
					break;
				}
				case '2': {
					st.append("0010");
					break;
				}
				case '3': {
					st.append("0011");
					break;
				}
				case '4': {
					st.append("0100");
					break;
				}
				case '5': {
					st.append("0101");
					break;
				}
				case '6': {
					st.append("0110");
					break;
				}
				case '7': {
					st.append("0111");
					break;
				}
				case '8': {
					st.append("1000");
					break;
				}
				case '9': {
					st.append("1001");
					break;
				}
				case 'A': {
					st.append("1010");
					break;
				}
				case 'B': {
					st.append("1011");
					break;
				}
				case 'C': {
	
					st.append("1100");
					break;
				}
				case 'D': {
					st.append("1101");
					break;
				}
				case 'E': {
					st.append("1110");
					break;
				}
				case 'F': {
					st.append("1111");
					break;
				}
			}

		}
		
		// 将二进制转化为8进制
		transform_02(st);
	}

	public static void transform_02(StringBuffer s) {
		int i = s.length();
		
		// 3位二进制是一位8进制，所以需要补齐二进制字符串为3的倍数
		if (i % 3 == 0) {
			if (s.substring(0, 3).equals("000")) {
				s.delete(0, 3);
			}
		}
		
		if (i % 3 == 1) {
			
			if (s.substring(0, 1).equals("0")) {
				s.delete(0, 1);
			} else {
				s.insert(0, "00");
			}
		}
		
		if (i % 3 == 2) {
			
			if (s.substring(0, 2).equals("00")) {
				s.delete(0, 2);
			} else {
				s.insert(0, "0");
			}
		}

		int n = s.length() / 3;
		String[] s1 = new String[n];
		StringBuffer sbf = new StringBuffer();
		
		for (int j = 0; j < n; j++) {
			// 3位二进制
			s1[j] = s.substring(j * 3, j * 3 + 3);
			if (s1[j].equals("000")) {
				sbf.append("0");
			}
			if (s1[j].equals("001")) {
				sbf.append("1");
			}
			if (s1[j].equals("010")) {
				sbf.append("2");
			}
			if (s1[j].equals("011")) {
				sbf.append("3");
			}
			if (s1[j].equals("100")) {
				sbf.append("4");
			}
			if (s1[j].equals("101")) {
				sbf.append("5");
			}
			if (s1[j].equals("110")) {
				sbf.append("6");
			}
			if (s1[j].equals("111")) {
				sbf.append("7");
			}
		}
		
		String s2 = sbf.toString();
		System.out.println(s2);
	}
}