package com.zxt.sort;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		int temp = 0;
		// �����ʼ����
		System.out.print("��ʼ���飺");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		// ���ѭ�������Ծ���һ������
		for (int i = 0; i < arr.length - 1; i++) {
			// �ڲ�ѭ������ʼ����Ƚϣ��������ǰһ�����Ⱥ�һ�������򽻻�
			for (int j = 0; j < arr.length - 1 - i; j++) {
				// ��λ
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			
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