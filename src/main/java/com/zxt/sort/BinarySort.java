package com.zxt.sort;

public class BinarySort {

	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		BinarySort bs = new BinarySort();
		// �����ʼ����
		System.out.print("��ʼ���飺");
		bs.print(arr);

		// �ӵ�1��Ԫ�ؿ�ʼѭ������0���������Ѿ�����õ������
		for (int i = 1; i < arr.length; i++) {
			// ����������ҳ�������Ԫ��Ҫ�����λ��
			int insertindex = bs.binaryFind(0, i - 1, arr[i], arr);
			bs.insertvalue(insertindex, i, arr[i], arr);

			// ����м���
			System.out.printf("��%d������", i);
			bs.print(arr);
		}

		// ��������
		System.out.print("���ս����");
		bs.print(arr);
	}

	// ���ֲ��ҷ�
	public int binaryFind(int leftIndex, int rightIndex, int val, int[] arr) {
		// �����ҵ��м����
		int midIndex = ((rightIndex + leftIndex) / 2);
		int midVal = arr[midIndex];

		if (rightIndex >= leftIndex) {
			// ���Ҫ�ҵ�����midVal��
			if (midVal > val) {
				// ��arr���������������
				return binaryFind(leftIndex, midIndex - 1, val, arr);
			} else if (midVal < val) {
				// ��arr�����ұ���������
				return binaryFind(midIndex + 1, rightIndex, val, arr);
			} else if (midVal == val) {
				return midIndex + 1;
			}
		} else {
			return leftIndex;
		}

		return -1;
	}

	// ������������ֳ����������������ֻ����������У�last��ʾ�����ı߽�
	// ����������������в��룬��last = arr.length-1
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