package com.zxt.algorithm;

/*
 * 某财务部门结账时发现总金额不对头。很可能是从明细上漏掉了某1笔或几笔。
 * 如果已知明细账目清单，能通过编程找到漏掉的是哪1笔或几笔吗？ 如果有多种可能，则输出所有可能的情况。
 * 我们规定：用户输入的第一行是：有错的总金额。 接下来是一个整数n，表示下面将要输入的明细账目的条数。 再接下来是n行整数，分别表示每笔账目的金额。
 * 要求程序输出：所有可能漏掉的金额组合。每个情况1行。金额按照从小到大排列，中间用空格分开。
 * 
 * 比如：
 * 用户输入：
 * 6
 * 5
 * 3
 * 2
 * 4
 * 3
 * 1
 * 表明：有错的总金额是6；明细共有5笔。 此时，程序应该输出：
 * 1 3 3
 * 1 2 4
 * 3 4
 * 为了方便，不妨假设所有的金额都是整数；每笔金额不超过1000，金额的明细条数不超过100。
 */
public class Main3 {
	// 金额明细
	public static int[] a = { 3, 2, 4, 3, 1 };
	// 错误总金额
	public static int err_sum = 6;
	
	public static void main(String[] args) {
		//boolean[] used = new boolean[a.length];
		//count(0, 0, used);
	}

	// cur_index:当前要考虑的项
	// cur_sum:当前的累加和
	// used:记录取舍的数组
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
