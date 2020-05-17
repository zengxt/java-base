package com.zxt.arrays;

import java.util.Arrays;

/**
 * Arrays������ʹ��ʾ��
 * 
 * @author zxt
 *
 */
public class ArraysTest {

	public static void main(String[] args) {
		int[] arr = {7, 8, 9, 5, 6, 3};
		System.out.print("the oriange arr is :");
		printArr(arr);
		
		// ����
		Arrays.sort(arr);
		System.out.print("sort of the arr is :");
		printArr(arr);
		
		// ����
		System.out.println();
		System.out.println("index of 5 in arr is��" + Arrays.binarySearch(arr, 5));
		System.out.println("index of 2 in arr is��" + Arrays.binarySearch(arr, 2));
		System.out.println("index of 10 in arr is��" + Arrays.binarySearch(arr, 10));
		// Arrays.binarySearch������ʧ�ܷ��ص��Ǹ�ֵ�������У�- ����� - 1��
		// ����(-Arrays.binarySearch(arr, 10)) - 1������10������������������λ��
		
		// ָ��������Χ������飬�������2,3λ�����10
		Arrays.fill(arr, 2, 4, 10);
		System.out.println();
		System.out.print("end of fill the arr is :");
		printArr(arr);
		
		int[] arr2 = {7, 8, 9, 5, 6, 3};
		System.out.println();
		System.out.println("hashCode of array arr1 is��" + Arrays.hashCode(arr));
		System.out.println("hashCode of array arr2 is��" + Arrays.hashCode(arr2));
		System.out.println("arr equqls arr2 is " + Arrays.equals(arr, arr2));
		
		// ��¡����
		int[] arr3 = Arrays.copyOf(arr2, arr2.length);
		System.out.println("arr equqls arr2 is " + Arrays.equals(arr2, arr3));
		
		// ����������ַ�����ʾ
		System.out.println();
		System.out.println("arr.toString is :" + Arrays.toString(arr));
	}
	
	public static void printArr(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}