package com.zxt.chartest;

public class CharTest {

	/**
	 * 
	 * @Description:�ܽ᣺1���ַ�����������Զ�ת��Ϊascii����
	 * 					2�����ַ��б����Ϊ�����ַ�������Ҫʹ�ø����֣�c - '0'��  char e = (char) (c + 5); Ҳ��ʵ���ַ����������������
	 * 					3����һ����������ת��Ϊchar���ͣ��������ascii������Ӧ���ַ�
	 * 					4����׼ascii��Ϊ 0-127�� ��չasciiΪ128-256
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char c = '2';
		System.out.println(c); // 2
		System.out.println((int) c); // 50

		// ����������ʱ��char�����Զ�ת��Ϊint����char-->intֵ��Ϊ�ַ�����Ӧ��ASCII��
		int a = c + 2;
		System.out.println(a); // 52

		// ������ASCII��ֵ
		System.out.println((int) '0'); // 48
		System.out.println((int) '1');
		System.out.println((int) '9');
		System.out.println((int) 'a'); // 97
		System.out.println((int) 'A');
		System.out.println((int) 'z');
		System.out.println((int) 'Z');

		int b = c - '0' + 3;
		System.out.println(b); // 5
		int d = c + 3;
		System.out.println(d); // 53

		char e = (char) (c + 5);
		System.out.println(e); // 7
		System.out.println((char) ('2' + 5)); // 7
		char g = (char) 97;
		System.out.println(g); // a
		char v = (char) 300;
		System.out.println(v); // a

		char f = '1' + '2';
		System.out.println(f); // c ASCII�� 49 + 50 = 99 �� �ַ�c
	}

}
