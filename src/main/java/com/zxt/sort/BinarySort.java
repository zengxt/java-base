package com.zxt.sort;

public class BinarySort {

	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		BinarySort bs = new BinarySort();
		// 输出初始数组
		System.out.print("初始数组：");
		bs.print(arr);

		// 从第1个元素开始循环，第0个看成是已经排序好的有序表
		for (int i = 1; i < arr.length; i++) {
			// 在有序表中找出待排序元素要插入的位置
			int insertindex = bs.binaryFind(0, i - 1, arr[i], arr);
			bs.insertvalue(insertindex, i, arr[i], arr);

			// 输出中间结果
			System.out.printf("第%d躺排序：", i);
			bs.print(arr);
		}

		// 输出最后结果
		System.out.print("最终结果：");
		bs.print(arr);
	}

	// 二分查找法
	public int binaryFind(int leftIndex, int rightIndex, int val, int[] arr) {
		// 首先找到中间的数
		int midIndex = ((rightIndex + leftIndex) / 2);
		int midVal = arr[midIndex];

		if (rightIndex >= leftIndex) {
			// 如果要找的数比midVal大
			if (midVal > val) {
				// 在arr数组左边数列中找
				return binaryFind(leftIndex, midIndex - 1, val, arr);
			} else if (midVal < val) {
				// 在arr数组右边数列中找
				return binaryFind(midIndex + 1, rightIndex, val, arr);
			} else if (midVal == val) {
				return midIndex + 1;
			}
		} else {
			return leftIndex;
		}

		return -1;
	}

	// 插入排序，数组分成有序表和无序表，插入只是在有序表中，last表示有序表的边界
	// 如果是在整个数组中插入，则last = arr.length-1
	public void insertvalue(int index, int last, int value, int[] arr) {
		if (last > arr.length - 1) {
			System.out.println("out of index!");
			return;
		}

		int i = last - 1;
		while (index <= i) {
			arr[i + 1] = arr[i];
			i--;
		}
		arr[i + 1] = value;
	}

	public void print(int[] arr) {
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + "\t");
		}
		System.out.println();
	}
}