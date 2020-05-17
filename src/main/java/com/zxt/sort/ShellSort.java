package com.zxt.sort;

public class ShellSort {
	
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		// �����ʼ����
		System.out.print("��ʼ���飺");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		
		// ���Ʋ�������ֻ�ǲ�������������1������������dk,��1����dk�Ϳ�����
		int dk = arr.length / 2;
		while (dk >= 1) {
			
			// �ӵ�dk��Ԫ�ؿ�ʼѭ��
			for (int i = dk; i < arr.length; i++) {
				int insertVal = arr[i];
				// insertVal׼����ǰһ�����Ƚ�
				int index = i - dk;
				while (index >= 0 && insertVal < arr[index]) {
					// ����arr[index]����ƶ�dkλ
					arr[index + dk] = arr[index];
					// ��index��ǰ�ƶ�dkλ
					index = index - dk;
				}

				// ��insertVal���뵽�ʵ�λ��
				arr[index + dk] = insertVal;
				
				// ����м���
				System.out.printf("dk =%d:", dk);
				for (int k = 0; k < arr.length; k++) {
					System.out.print(arr[k] + "\t");
				}
				System.out.println();
			}
			
			dk = dk / 2;
		}

		// ��������
		System.out.print("���ս����");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}