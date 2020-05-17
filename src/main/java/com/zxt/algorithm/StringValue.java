package com.zxt.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * ��Ŀ��������һ����Ȥ���ַ�����ֵ���㷽ʽ��ͳ���ַ�����ÿ���ַ����ֵĴ�����Ȼ���������ַ�������ƽ������Ϊ�ַ����ļ�ֵ��
 * 		     ���磺�ַ�����abacaba��������Ū����4����a����2����b����1����c������������ַ����ļ�ֵΪ 4*4 + 2*2 + 1*1 = 21��
 * 
 * 		    ţţ��һ���ַ���s�������������s���Ƴ����k���ַ������Ŀ�����õõ����ַ����ļ�ֵ��С��
 * 
 * ��������������������У���һ��һ���ַ���s���ַ���s�ĳ���length��1 <= length <= 50��������ֻ����Сд��ĸ��'a' - 'z'��,
 * 		    �ڶ��а���һ������k��0 <= k <= length�����������Ƴ����ַ�������
 * ������������һ����������ʾ�õ�����С��ֵ��
 * 
 * ʾ����
 * aba
 * 1
 * 
 * 2
 */
public class StringValue {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		// ����
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
