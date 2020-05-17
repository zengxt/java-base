package com.zxt.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * �������к�Ϊ����ֵ������������
 * 
 * �磺����[1,2,3,4,5,6]��sum=7ʱ��������������������[1,2,4],[3,4],[2,5],[1,6];
 * 
 * @author zxt
 *
 */
public class FixedSumSequence {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 5, 5, 5, 6, 1, 4, 4 };
		// ������������
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[arr.length];
		
		// ���Ϊsum�����������
		backTrack(arr, visited, 0, 0, 7, lists);
		System.out.println(lists);
		System.out.println(lists.size());
	}

	// ��һ�������к�Ϊ��ֵ������������
	public static void backTrack(int[] input, boolean[] visited, int n, int sum, int key,
			ArrayList<ArrayList<Integer>> lists) {

		// �������Ϊ��if (sum % key == 0 && sum != 0) ���������к�Ϊ��ֵ������������
		if (sum == key) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j <= n; j++) {
				if (visited[j]) {
					list.add(input[j]);
				}
			}
			lists.add(list);
			return;
		}

		for (int i = n; i < input.length; i++) {
			if (!visited[i]) {
				sum += input[i];
				visited[i] = true;
				if (i != input.length - 1) {
					backTrack(input, visited, i + 1, sum, key, lists);
				} else {
					backTrack(input, visited, i, sum, key, lists);
				}

				visited[i] = false;
				sum -= input[i];
				
				// �ظ���Ԫ��ֻͳ��һ�Σ����������ظ������β�����ǰ���ǣ������Ѿ��������Բ���input����������õģ�
				while (i < input.length - 1 && input[i] == input[i + 1]) {
					i++;
				}
			}
		}
	}
}