package com.zxt.sort;

public class SelectSort {
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		int temp = 0;
		// 输出初始数组
		System.out.print("初始数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		for (int j = 0; j < arr.length - 1; j++) {
			// 认为第一个数就是最小数
			int min = arr[j];
			// 记录最小数的下标
			int minIndex = j;
			for (int k = j + 1; k < arr.length; k++) {
				if (min > arr[k]) {
					// 修改最小值
					min = arr[k];
					minIndex = k;
				}
			}
			// 当退出for循环时就找到这次的最小值
			temp = arr[j];
			arr[j] = arr[minIndex];
			arr[minIndex] = temp;

			// 输出中间结果
			System.out.printf("第%d躺排序：", j);
			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k] + "\t");
			}
			System.out.println();
		}

		// 输出最后结果
		System.out.print("最终结果：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}