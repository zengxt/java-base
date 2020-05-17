package com.zxt.algorithm;

/*
 * ĳ�����Ž���ʱ�����ܽ���ͷ���ܿ����Ǵ���ϸ��©����ĳ1�ʻ򼸱ʡ�
 * �����֪��ϸ��Ŀ�嵥����ͨ������ҵ�©��������1�ʻ򼸱��� ����ж��ֿ��ܣ���������п��ܵ������
 * ���ǹ涨���û�����ĵ�һ���ǣ��д���ܽ� ��������һ������n����ʾ���潫Ҫ�������ϸ��Ŀ�������� �ٽ�������n���������ֱ��ʾÿ����Ŀ�Ľ�
 * Ҫ�������������п���©���Ľ����ϡ�ÿ�����1�С����մ�С�������У��м��ÿո�ֿ���
 * 
 * ���磺
 * �û����룺
 * 6
 * 5
 * 3
 * 2
 * 4
 * 3
 * 1
 * �������д���ܽ����6����ϸ����5�ʡ� ��ʱ������Ӧ�������
 * 1 3 3
 * 1 2 4
 * 3 4
 * Ϊ�˷��㣬�����������еĽ���������ÿ�ʽ�����1000��������ϸ����������100��
 */
public class Main3 {
	// �����ϸ
	public static int[] a = { 3, 2, 4, 3, 1 };
	// �����ܽ��
	public static int err_sum = 6;
	
	public static void main(String[] args) {
		//boolean[] used = new boolean[a.length];
		//count(0, 0, used);
	}

	// cur_index:��ǰҪ���ǵ���
	// cur_sum:��ǰ���ۼӺ�
	// used:��¼ȡ�������
	public static void count(int cur_index, int cur_sum, boolean[] used) {
		if (cur_sum > err_sum) {
			return;
		}

		if (err_sum == cur_sum) {
			for (int i = 0; i < used.length; i++) {
				if (!used[i]) {
					System.out.print(a[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		if (cur_index >= a.length) {
			return;
		}

		used[cur_index] = false;
		count(cur_index + 1, cur_sum, used);

		used[cur_index] = true;
		cur_sum += a[cur_index];
		count(cur_index + 1, cur_sum, used);
		
		used[cur_index] = false;
	}
}
