package com.zxt.sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		// 输出初始数组
		System.out.print("初始数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		// 从第1个元素开始循环，第0个看成是已经排序好的有序表
		for (int i = 1; i < arr.length; i++) {
			int insertVal = arr[i];
			// insertVal准备和前一个数比较
			int index = i - 1;
			while (index >= 0 && insertVal < arr[index]) {
				// 将把arr[index]向后移动一位
				arr[index + 1] = arr[index];
				// 让index向前移动一位
				index--;
			}

			// 将insertVal插入到适当位置
			arr[index + 1] = insertVal;

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