package com.zxt.sort;

public class MergeSort {
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		
		ms.print(arr);
		ms.merge_sort(arr, 0, arr.length - 1);
	}

	// �ݹ�ֳ�С����
	public void merge_sort(int[] arrays, int start, int end) {
		if (start < end) {
			int m = (start + end) / 2;
			merge_sort(arrays, start, m);
			merge_sort(arrays, m + 1, end);
			combin_arrays(arrays, start, m, end);
			
			print(arrays);
		}
	}

	// �ϲ�����
	public void combin_arrays(int[] arrays, int start, int m, int end) {
		int length = end - start + 1;
		// ������űȽϵ����飬���긴�ƻص�ԭ��������
		int temp[] = new int[length];
		int i = start;
		int j = m + 1;
		int c = 0;
		
		while (i <= m && j <= end) {
			if (arrays[i] < arrays[j]) {
				temp[c++] = arrays[i++];
			} else {
				temp[c++] = arrays[j++];
			}
		}
		
		while (i <= m) {
			temp[c++] = arrays[i++];
		}
		while (j <= end) {
			temp[c++] = arrays[j++];
		}
		
		c = 0;
		for (int t = start; t <= end; t++) {
			arrays[t] = temp[c++];
		}
	}

	// ��ӡ����
	public void print(int[] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + "\t");
		}
		System.out.println();
	}
}