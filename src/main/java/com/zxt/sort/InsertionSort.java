package com.zxt.sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		// �����ʼ����
		System.out.print("��ʼ���飺");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		// �ӵ�1��Ԫ�ؿ�ʼѭ������0���������Ѿ�����õ������
		for (int i = 1; i < arr.length; i++) {
			int insertVal = arr[i];
			// insertVal׼����ǰһ�����Ƚ�
			int index = i - 1;
			while (index >= 0 && insertVal < arr[index]) {
				// ����arr[index]����ƶ�һλ
				arr[index + 1] = arr[index];
				// ��index��ǰ�ƶ�һλ
				index--;
			}

			// ��insertVal���뵽�ʵ�λ��
			arr[index + 1] = insertVal;

			// ����м���
			System.out.printf("��%d������", i);
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