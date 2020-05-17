package com.zxt.integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ��������
   ����n��ʮ��������������������Ƕ�Ӧ�İ˽�������
   
   �����ʽ�� ����ĵ�һ��Ϊһ��������n ��1<=n<=10����
                        ������n�У�ÿ��һ����0~9����д��ĸA~F��ɵ��ַ�������ʾҪת����ʮ��������������ÿ��ʮ�����������Ȳ�����100000��
   �����ʽ�� ���n�У�ÿ��Ϊ�����Ӧ�İ˽�����������
 
   ע�⣺ �����ʮ��������������ǰ��0������012A�� ����İ˽�����Ҳ������ǰ��0��

   ��������
 2
 39
 123ABC
   �������
 71
 4435274
 
   ��ʾ�� �Ƚ�ʮ��������ת����ĳ������������ĳ������ת���ɰ˽��ơ�

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
		
		// ����ֱ��ʹ��Integer��ķ���ʵ��ת��
		// valueOf(String s, int radix) ����һ�� Integer ���󣬸ö����б������õڶ��������ṩ�Ļ������н���ʱ��ָ���� String ����ȡ��ֵ��
		for (int j = 0; j < n; j++) {
			// �������16���Ƶ��ַ������Ƚ���ת��Ϊ����
			int int_16 = Integer.valueOf(str[j], 16);
			// toOctalString(int i)���԰˽��ƣ����� 8���޷���������ʽ����һ�������������ַ�����ʾ��ʽ��
			String str_8 = Integer.toOctalString(int_16);
			
			System.out.println(str_8);
		}
	}

	public static void transform(String s) {
		StringBuffer st = new StringBuffer();
		char c[] = s.toCharArray();
		// ��ʮ������ת��Ϊ�������ַ���
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
		
		// ��������ת��Ϊ8����
		transform_02(st);
	}

	public static void transform_02(StringBuffer s) {
		int i = s.length();
		
		// 3λ��������һλ8���ƣ�������Ҫ����������ַ���Ϊ3�ı���
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
			// 3λ������
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