package com.zxt.base;

public class PrintGraph {

	public static void main(String[] args) {
		// ��ʾ�ж��ٲ�
		int lay = 4;
		
		for (int i = 1; i <= lay; i++) {
			// ��ӡ*
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// ������
		lay = 10;
		for (int i = 1; i <= lay; i++) {
			// 1->3 2->2 3->1 4->0�ҳ��ո�
			for (int k = 1; k <= lay - i; k++) {
				System.out.print(" ");
			}
			// ��ӡ*
			// 1->1 2->3 3->5 4->7�ҳ��ǵĹ���
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// �οս�����
		lay = 10;
		for (int i = 1; i <= lay; i++) {
			for (int k = 1; k <= lay - i; k++) {
				System.out.print(" ");
			}
			// ��ӡ*
			// 1->1 2->3 3->5 4->7�ҳ��ǵĹ���
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
				// �жϸò��Ƿ��Ƕ�������ǵײ�
				if (i == 1 || i == lay) {
					System.out.print("*");
				} else {
					// ����ǵ�һ��*
					if (j == 1 || j == (i - 1) * 2 + 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}

		// ��������
		// �����ϰ벿����
		lay = 4;
		// �ж�ѭ���ϰ벿��
		for (int i = 1; i <= lay - 1; i++) {
			// �ж�ѭ���ϰ벿��
			for (int k = 1; k <= lay - i; k++) {
				System.out.print(" ");
			}
			// ����������ǵ�λ��
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
				// �ж�����С���Ⱥ���󳤶ȣ�������С���Ⱥ���󳤶������*�ţ�����������ո�
				if (j == 1 || j == (i - 1) * 2 + 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		// �ж�ѭ�������°벿��
		for (int i = 1; i <= lay; i++) { 
			// �ж�ѭ����*��ǰҪ����ո�
			for (int k = 1; k <= i - 1; k++) {
				System.out.print(" ");
			}
			// �ж�ѭ���г���
			for (int j = 1; j <= (lay - i) * 2 + 1; j++) {
				// �ж�����С���Ⱥ���󳤶ȣ�������С���Ⱥ���󳤶������*�ţ�����������ո�
				if (j == 1 || j == (lay - i) * 2 + 1) { 
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}