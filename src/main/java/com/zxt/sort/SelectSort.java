package com.zxt.sort;

public class SelectSort {
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		int temp = 0;
		// �����ʼ����
		System.out.print("��ʼ���飺");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		for (int j = 0; j < arr.length - 1; j++) {
			// ��Ϊ��һ����������С��
			int min = arr[j];
			// ��¼��С�����±�
			int minIndex = j;
			for (int k = j + 1; k < arr.length; k++) {
				if (min > arr[k]) {
					// �޸���Сֵ
					min = arr[k];
					minIndex = k;
				}
			}
			// ���˳�forѭ��ʱ���ҵ���ε���Сֵ
			temp = arr[j];
			arr[j] = arr[minIndex];
			arr[minIndex] = temp;

			// ����м���
			System.out.printf("��%d������", j);
			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k] + "\t");
			}
			System.out.println();
		}

		// ��������
		System.out.print("���ս����");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}