package com.zxt.sort;

import java.util.Scanner;

public class BinarySeach {

	private static Scanner sr;

	public static void main(String[] args) {
		// ����arr���鲢��ֵ
		int arr[] = { 2, 5, 7, 12, 25 };

		System.out.print("����������Ҫ���ҵ�����");
		sr = new Scanner(System.in);
		int a = sr.nextInt();

		BinarySeach bf = new BinarySeach();
		bf.binaryFind(0, arr.length - 1, a, arr);
	}

	// ���ֲ��ҷ�
	public void binaryFind(int leftIndex, int rightIndex, int val, int arr[]) {
		// �����ҵ��м����
		int midIndex = ((rightIndex + leftIndex) / 2);
		int midVal = arr[midIndex];
		
		if (rightIndex >= leftIndex) {
			// ���Ҫ�ҵ�����midVal��
			if (midVal > val) {
				// ��arr���������������
				binaryFind(leftIndex, midIndex - 1, val, arr);
			} else if (midVal < val) {
				// ��arr�����ұ���������
				binaryFind(midIndex + 1, rightIndex, val, arr);
			} else if (midVal == val) {
				System.out.println("����arr[" + midIndex + "]�е�������" + arr[midIndex]);
			}
		} else {
			System.out.println("û���ҵ���Ҫ�ҵ���!");
		}
	}
}