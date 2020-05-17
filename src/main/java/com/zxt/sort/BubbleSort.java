package com.zxt.sort;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		int temp = 0;
		// 输出初始数组
		System.out.print("初始数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		// 外层循环，可以决定一共走趟
		for (int i = 0; i < arr.length - 1; i++) {
			// 内层循环，开始逐个比较，如果发现前一个数比后一个数大则交换
			for (int j = 0; j < arr.length - 1 - i; j++) {
				// 换位
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			
			// 输出中间结果
			System.out.printf("第%d躺排序：", i);
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