package com.zxt.regex;

import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {

		// ʹ��Pattern.compile��������һ��������ʽ������һ��ƥ��ģʽ
		Pattern pattern = Pattern.compile("\\?|\\*");

		
		// pattern()��������������ʽ���ַ�����ʽ ����\?\*
		String patternStr = pattern.pattern();
		System.out.println(patternStr);
		// flags()���ص�ǰPattern��ƥ��flag���������ﲢû�ж���
		int flag = pattern.flags();
		System.out.println(flag);

		
		// split�������ַ������зָ�
		// 123 123 456 456
		String[] splitStrs = pattern.split("123?123*456*456");
		for (int i = 0; i < splitStrs.length; i++) {
			System.out.print(splitStrs[i] + "  ");
		}
		System.out.println();
		
		// 123 123*456*456
		String[] splitStrs2 = pattern.split("123?123*456*456", 2);
		for (int i = 0; i < splitStrs2.length; i++) {
			System.out.print(splitStrs2[i] + "  ");
		}
		System.out.println();

		Pattern p = Pattern.compile("\\d+");
		String[] str = p.split("�ҵ�QQ��:456456�ҵĵ绰��:0532214�ҵ�������:aaa@aaa.com");
		for (int i = 0; i < str.length; i++) {
			System.out.printf("str[%d] = %s\n", i, str[i]);
		}
		System.out.println();

		
		// Pattern.matches�ø�����ģʽ���ַ�������һ��ƥ�䣬����Ҫȫƥ��ʱ�ŷ���true��
		System.out.println("Pattern.matches(\"\\\\d+\", \"2223\") is " + Pattern.matches("\\d+", "2223"));
		// ����false����Ҫƥ�䵽�����ַ������ܷ���true������aa����ƥ�䵽
		System.out.println("Pattern.matches(\"\\\\d+\", \"2223aa\") is " + Pattern.matches("\\d+", "2223aa"));
		// ����false,��Ҫƥ�䵽�����ַ������ܷ���true,����bb����ƥ�䵽
		System.out.println("Pattern.matches(\"\\\\d+\", \"22bb23\") is " + Pattern.matches("\\d+", "22bb23"));

	}

}
