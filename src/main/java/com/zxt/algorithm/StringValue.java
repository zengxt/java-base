package com.zxt.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 题目描述：有一种有趣的字符串价值计算方式，统计字符串中每种字符出现的次数，然后求所有字符次数的平方和作为字符串的价值。
 * 		     例如：字符串“abacaba”，里卖弄包括4个‘a’，2个‘b’，1个‘c’，于是这个字符串的价值为 4*4 + 2*2 + 1*1 = 21。
 * 
 * 		    牛牛有一个字符串s，并且允许你从s中移除最多k个字符，你的目标是让得到的字符串的价值最小。
 * 
 * 输入描述：输入包括两行，第一行一个字符串s，字符串s的长度length（1 <= length <= 50），其中只包含小写字母（'a' - 'z'）,
 * 		    第二行包含一个整数k（0 <= k <= length），即允许移除的字符个数。
 * 输出描述：输出一个整数，表示得到的最小价值。
 * 
 * 示例：
 * aba
 * 1
 * 
 * 2
 */
public class StringValue {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		// 输入
		String str = sc.nextLine();
		int k = sc.nextInt();

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		char[] chars = str.toCharArray();
		for (char c : chars) {
			if (!hm.containsKey(c)) {
				hm.put(c, 1);
			} else {
				hm.put(c, hm.get(c) + 1);
			}
		}

		int[] arr = new int[hm.size()];
		int index = 0;
		for (Integer value : hm.values()) {
			arr[index] = value;
			index++;
		}
		Arrays.sort(arr);

		index = 0;
		while (index < k) {
			arr[arr.length - 1] = arr[arr.length - 1] - 1;
			if (arr[arr.length - 1] < arr[arr.length - 2]) {
				Arrays.sort(arr);
			}
			index++;
		}

		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res = res + arr[i] * arr[i];
		}

		System.out.println(res);
	}
}
