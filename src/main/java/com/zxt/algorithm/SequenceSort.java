package com.zxt.algorithm;

import java.util.Scanner;

/**
 * ��Ŀ�����С�abcdefghijkl��12���ַ����������е����а��ֵ���������򣬸�������һ�����У�˵�����������������������ǵڼ�С�ġ�
 * 
 * ˼·�ǣ����磬�����ĵ�һλ��b������������ַ������str������ô������a��ͷ���ַ�����������strǰ�档
 * ��a��ͷ���ַ������������Ǻ���11λ�ַ����е�������ϣ�Ҳ����11�Ľ׳ˡ�
 * 
 * �����һλ��c����ô������a����b��ͷ�������ַ����ͻ�����str��ǰ�棬Ҳ���� 2*11���������ƣ�����֪����һλ�������ַ�ʱ����strǰ����ַ���������
 * 
 * ���ſ��ڶ�λ���ڶ�λ��˼·�͵�һλһ����ͬ������֪���ڶ�λ�������ַ�ʱ����strǰ����ַ������������Դ����ƣ�������ַ�������֮�󣬰�ȫ��������
 * 
 * ���ǣ����ʱ����һ�����⣬���������12���ַ��ǹ̶��ģ����Լ����һλ����a����b����ôa�ں�����ַ���һ������֣�ͬʱbҲ�����ٳ��֣�
 * �����ڽ�������ļ���ʱ������ֱ�����ֵ��������м��㣬�ڼ���ÿһλʱҪ������δ���ֹ����ַ���˳��������δ���ֵ��ַ���˳��
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
	 * �������
	 * 
	 * System.out.println(getSortNum("abcdefghijlk")); // 1
	 * System.out.println(getSortNum("hgebkflacdji")); // 302715242
	 * System.out.println(getSortNum("gfkedhjblcia")); // 260726926
	 */
	// �������������hgebkflacdji����һλȡ������h������hӦ���ڵ���λ��sort�еõ���ֵ�������Ե���λǰ��������ĸ�ڵ�һλ��˳��Ӧ�ñ�����ַ���˳��ǰ
	// �����������ڶ�λ���ַ�����ʱ�൱��h��˳���Ѿ��̶��������ڿ��ǣ����Խ����ŵ���һλ
	public static int getSortNum(String value) {
		// ��¼�Ѿ����ֹ����ַ���δ���ֵ��ַ�˳��
		String sort = "abcdefghijkl";

		int res = 1;

		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			// �鿴���ַ��������ַ��еĵ�ǰ˳��
			int head = sort.lastIndexOf(c);
			// ��������ǰ����ַ�������
			res += ((head - i) * factorial(11 - i));

			// �޸��ַ�˳�򣬽���ǰ���ֵ��ַ����������ַ���ǰ��,��Ϊ���ǲ������Ѿ����ֹ����ַ���˳������ֻҪ֪�����ֹ���Щ�ַ��Լ�δ���ֵ��ַ����ֵ���
			sort = change(sort, head);
		}

		return res;
	}

	// ���ո�˼·����ʵ���ǿ���ʹ��StrinfBufer���Ȱ��ֵ��򱣴���12���ַ���Ȼ�󽫵�ǰ���ֵ��ַ�ֱ��ɾ���ͺ��ˡ�
	// Ȼ�����¼��㣬�ټ�����һ���ַ��ı�����λ�ã��Ӷ�ȷ���м����ַ�������ǰ�档
	public static int getSortNum2(String value) {
		// ��¼�Ѿ����ֹ����ַ���δ���ֵ��ַ�˳��
		StringBuffer sort = new StringBuffer("abcdefghijkl");

		int res = 1;

		for (int i = 0; i < value.length(); i++) {
			String c = value.charAt(i) + "";
			// �鿴���ַ��������ַ��еĵ�ǰ˳��
			int head = sort.lastIndexOf(c);
			// ��������ǰ����ַ������� (sort.length()-1)��ʾȫ���У�����һλ��b����ô������a��ͷ���ַ�������������ǰ�����˼
			res += ((head) * factorial(sort.length() - 1));

			// �����ֹ����ַ�ɾ��
			sort.deleteCharAt(head);
		}

		return res;
	}

	/**
	 * ��׳�
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
	 * ���ַ�����indexλ������ǰ��
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
