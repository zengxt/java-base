package com.zxt.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @Description: ���������㷨��ʵ��
 *
 * @author�� zxt
 *
 * @time: 2018��3��19�� ����8:49:26
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		
		// �����ʼ����
		System.out.print("��ʼ���飺");
		System.out.println(Arrays.toString(arr));
		
		
		// ����
		// quick_sort(0, arr.length - 1, arr);
		
		quickSort(arr, 0, arr.length - 1);
		
		
		// ��������
		System.out.print("���ս����");
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 
	 * @Description:����һ��ÿ�����м������Ϊ����
	 * 
	 * @param left
	 * @param right
	 * @param arr
	 */
	public static void quick_sort(int left, int right, int[] arr) {
		int l = left;
		int r = right;
		// ���м�λ�õ�ֵ��Ϊ����
		int pivot = arr[(left + right) / 2];
		
		while (l < r) {
			// С�ڻ���
			while (arr[l] < pivot) {
				l++;
			}
			// ���ڻ���
			while (arr[r] > pivot) {
				r--;
			}
			if (l >= r) {
				break;
			}
			
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			// ���������������ָ��ָ������������м�ֵ����ʱ�����ж������ѭ��
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
	 * @Description:���������������λ�ã�������ֳ�������
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
	 * @Description:�������һ��λ�ã�Ȼ��С�ڸ�λ��ֵ�����ݶ���������λ��ǰ�棬�����ز����ڸ���������±�ֵ
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