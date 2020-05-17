package com.zxt.algorithm;

import java.util.Scanner;

/**
 * 题目：现有‘abcdefghijkl’12个字符，将其所有的排列按字典序进行排序，给出任意一组排列，说出这租排列在所有排列中是第几小的。
 * 
 * 思路是：假如，给出的第一位是b（给出的这个字符串简称str），那么所有以a开头的字符串都会排在str前面。
 * 以a开头的字符串的数量就是后面11位字符所有的排列组合，也就是11的阶乘。
 * 
 * 如果第一位是c，那么所有以a或者b开头的所有字符串就会排在str的前面，也就是 2*11！依次类推，可以知道第一位是任意字符时排在str前面的字符串的数量
 * 
 * 接着看第二位，第二位的思路和第一位一样，同样可以知道第二位是任意字符时排在str前面的字符串的数量，以此类推，后面的字符都算完之后，把全部结果相加
 * 
 * 但是，这个时候还有一个问题，在这道题中12个字符是固定的，所以假如第一位不是a，是b，那么a在后面的字符中一定会出现，同时b也不会再出现，
 * 所以在进行上面的计算时，不能直接以字典序来进行计算，在计算每一位时要根据尚未出现过的字符的顺序，来排列未出现的字符的顺序
 * 
 * @author zxt
 *
 */
public class SequenceSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			String[] str = new String[n];
			for (int i = 0; i < n; i++) {
				str[i] = sc.nextLine();
				System.out.println(getSortNum(str[i]));
			}

		}

//		System.out.println(getSortNum("abcdefghijkl")); // 1
//		System.out.println(getSortNum("hgebkflacdji")); // 302715242
//		System.out.println(getSortNum("gfkedhjblcia")); // 260726926
//
//		System.out.println(getSortNum2("abcdefghijkl")); // 1
//		System.out.println(getSortNum2("hgebkflacdji")); // 302715242
//		System.out.println(getSortNum2("gfkedhjblcia")); // 260726926

		sc.close();
	}

	/**
	 * 样例输出
	 * 
	 * System.out.println(getSortNum("abcdefghijlk")); // 1
	 * System.out.println(getSortNum("hgebkflacdji")); // 302715242
	 * System.out.println(getSortNum("gfkedhjblcia")); // 260726926
	 */
	// 程序分析：例如hgebkflacdji，第一位取出来是h，本来h应该在第七位（sort中得到该值），所以第七位前的所有字母在第一位的顺序都应该比这个字符串顺序靠前
	// 接下来分析第二位的字符，此时相当于h的顺序已经固定，不用在考虑，所以将它放到第一位
	public static int getSortNum(String value) {
		// 记录已经出现过的字符和未出现的字符顺序
		String sort = "abcdefghijkl";

		int res = 1;

		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			// 查看该字符在所有字符中的当前顺序
			int head = sort.lastIndexOf(c);
			// 计算排在前面的字符串数量
			res += ((head - i) * factorial(11 - i));

			// 修改字符顺序，将当前出现的字符，交换到字符最前面,因为我们不关心已经出现过得字符的顺序，我们只要知道出现过哪些字符以及未出现的字符的字典序
			sort = change(sort, head);
		}

		return res;
	}

	// 按照该思路，其实我们可以使用StrinfBufer，先按字典序保存下12个字符，然后将当前出现的字符直接删除就好了。
	// 然后重新计算，再计算下一个字符的本来的位置，从而确定有几个字符排在它前面。
	public static int getSortNum2(String value) {
		// 记录已经出现过的字符和未出现的字符顺序
		StringBuffer sort = new StringBuffer("abcdefghijkl");

		int res = 1;

		for (int i = 0; i < value.length(); i++) {
			String c = value.charAt(i) + "";
			// 查看该字符在所有字符中的当前顺序
			int head = sort.lastIndexOf(c);
			// 计算排在前面的字符串数量 (sort.length()-1)表示全排列，即第一位是b，那么所有以a开头的字符串都会排在它前面的意思
			res += ((head) * factorial(sort.length() - 1));

			// 将出现过的字符删除
			sort.deleteCharAt(head);
		}

		return res;
	}

	/**
	 * 求阶乘
	 */
	public static int factorial(int n) {
		int result = 1;

		if (n == 0) {
			result = 0;

		} else {
			for (int i = 1; i <= n; i++) {
				result *= i;
			}
		}

		return result;
	}

	/**
	 * 将字符串第index位换到最前面
	 */
	public static String change(String str, int index) {
		StringBuffer temp = new StringBuffer(str.charAt(index) + "");
		for (int i = 0; i < str.length(); i++) {
			if (i != index) {
				temp.append(str.charAt(i));
			}
		}

		return temp.toString();
	}
}
