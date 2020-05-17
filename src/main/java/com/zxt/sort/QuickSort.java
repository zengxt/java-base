package com.zxt.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @Description: 快速排序算法的实现
 *
 * @author： zxt
 *
 * @time: 2018年3月19日 上午8:49:26
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		
		// 输出初始数组
		System.out.print("初始数组：");
		System.out.println(Arrays.toString(arr));
		
		
		// 排序
		// quick_sort(0, arr.length - 1, arr);
		
		quickSort(arr, 0, arr.length - 1);
		
		
		// 输出最后结果
		System.out.print("最终结果：");
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 
	 * @Description:方法一：每次让中间的数作为基数
	 * 
	 * @param left
	 * @param right
	 * @param arr
	 */
	public static void quick_sort(int left, int right, int[] arr) {
		int l = left;
		int r = right;
		// 找中间位置的值作为基数
		int pivot = arr[(left + right) / 2];
		
		while (l < r) {
			// 小于基数
			while (arr[l] < pivot) {
				l++;
			}
			// 大于基数
			while (arr[r] > pivot) {
				r--;
			}
			if (l >= r) {
				break;
			}
			
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			// 如果出现左右两个指针指向的数都等于中间值，这时候不做判断则会死循环
			if (arr[l] == pivot) {
				--r;
			}
			if (arr[r] == pivot) {
				++l;
			}
		}
		
		if (l == r) {
			l++;
			r--;
		}
		if (left < r) {
			quick_sort(left, r, arr);
		}
		if (right > l) {
			quick_sort(l, right, arr);
		}
	}
	
	/**
	 * 
	 * @Description:方法二：随机生成位置，将数组分成俩部分
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] array, int start, int end) {
		if(start == end) {
			return;
		}
		
		int index = partition(start, end, array);
		System.out.println(index);
		if(index > start) {
			quickSort(array, start, index - 1);
		}
		if(index < end) {
			quickSort(array, index + 1, end);
		}
	}
	
	/**
	 * 
	 * @Description:随机生成一个位置，然后将小于该位置值的数据都交换到该位置前面，并返回不大于该数的最大下标值
	 * 
	 * @param start
	 * @param end
	 * @param array
	 * @return
	 */
	public static int partition(int start, int end, int[] array) {
		if(start >= end || array.length <= 0 || start < 0 || end >= array.length) {
			return -1;
		}
		
		Random random = new Random();
		int index = random.nextInt(end - start + 1) + start;
		swap(array, index, end);
		
		int small = start - 1;
		for(index = start; index < end; index++) {
			if(array[index] < array[end]) {
				small++;
				if(small != index) {
					swap(array, index, small);
				}
			}
		}
		
		++small;
		swap(array, small, end);
		
		return small;
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}