package com.zxt.sort;

import java.util.Scanner;

public class BinarySeach {

	private static Scanner sr;

	public static void main(String[] args) {
		// 定义arr数组并赋值
		int arr[] = { 2, 5, 7, 12, 25 };

		System.out.print("请输入你需要查找的数：");
		sr = new Scanner(System.in);
		int a = sr.nextInt();

		BinarySeach bf = new BinarySeach();
		bf.binaryFind(0, arr.length - 1, a, arr);
	}

	// 二分查找法
	public void binaryFind(int leftIndex, int rightIndex, int val, int arr[]) {
		// 首先找到中间的数
		int midIndex = ((rightIndex + leftIndex) / 2);
		int midVal = arr[midIndex];
		
		if (rightIndex >= leftIndex) {
			// 如果要找的数比midVal大
			if (midVal > val) {
				// 在arr数组左边数列中找
				binaryFind(leftIndex, midIndex - 1, val, arr);
			} else if (midVal < val) {
				// 在arr数组右边数列中找
				binaryFind(midIndex + 1, rightIndex, val, arr);
			} else if (midVal == val) {
				System.out.println("数组arr[" + midIndex + "]中的数字是" + arr[midIndex]);
			}
		} else {
			System.out.println("没有找到你要找的数!");
		}
	}
}