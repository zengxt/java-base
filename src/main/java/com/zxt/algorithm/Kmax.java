package com.zxt.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求一个数组中第k大的元素的值
 * 
 * @author zxt
 *
 */
public class Kmax {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			int k = Integer.parseInt(sc.nextLine());

			int[] arr = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Arrays.sort(arr);

			System.out.println(arr[str.length - k]);
		}

		sc.close();
	}
}
