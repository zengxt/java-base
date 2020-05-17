package com.zxt.sort;

public class ShellSort {
	
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		// 输出初始数组
		System.out.print("初始数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		
		// 类似插入排序，只是插入排序增量是1，这里增量是dk,把1换成dk就可以了
		int dk = arr.length / 2;
		while (dk >= 1) {
			
			// 从第dk个元素开始循环
			for (int i = dk; i < arr.length; i++) {
				int insertVal = arr[i];
				// insertVal准备和前一个数比较
				int index = i - dk;
				while (index >= 0 && insertVal < arr[index]) {
					// 将把arr[index]向后移动dk位
					arr[index + dk] = arr[index];
					// 让index向前移动dk位
					index = index - dk;
				}

				// 将insertVal插入到适当位置
				arr[index + dk] = insertVal;
				
				// 输出中间结果
				System.out.printf("dk =%d:", dk);
				for (int k = 0; k < arr.length; k++) {
					System.out.print(arr[k] + "\t");
				}
				System.out.println();
			}
			
			dk = dk / 2;
		}

		// 输出最后结果
		System.out.print("最终结果：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}