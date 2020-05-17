package com.zxt.regex;

import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {

		// 使用Pattern.compile方法编译一个正则表达式，创建一个匹配模式
		Pattern pattern = Pattern.compile("\\?|\\*");

		
		// pattern()函数返回正则表达式的字符串形式 返回\?\*
		String patternStr = pattern.pattern();
		System.out.println(patternStr);
		// flags()返回当前Pattern的匹配flag参数，这里并没有定义
		int flag = pattern.flags();
		System.out.println(flag);

		
		// split方法对字符串进行分割
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
		String[] str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
		for (int i = 0; i < str.length; i++) {
			System.out.printf("str[%d] = %s\n", i, str[i]);
		}
		System.out.println();

		
		// Pattern.matches用给定的模式对字符串进行一次匹配，（需要全匹配时才返回true）
		System.out.println("Pattern.matches(\"\\\\d+\", \"2223\") is " + Pattern.matches("\\d+", "2223"));
		// 返回false，需要匹配到所有字符串才能返回true，这里aa不能匹配到
		System.out.println("Pattern.matches(\"\\\\d+\", \"2223aa\") is " + Pattern.matches("\\d+", "2223aa"));
		// 返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到
		System.out.println("Pattern.matches(\"\\\\d+\", \"22bb23\") is " + Pattern.matches("\\d+", "22bb23"));

	}

}
