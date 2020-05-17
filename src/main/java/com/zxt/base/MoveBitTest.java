package com.zxt.base;

/*
 * java��λ���������
 * ���ȣ���λ����������֣����������ֻ֧�֣�byte / short / char / int��long���֡�
 * <<	���������������ʾ����ߵĲ������Ķ��������������ƶ�nλ���ƶ����ȱλ��0��䣬����λ����������ͬ�ڳ�2��n�η���
 * >>	����������������������������ƶ�nλ������ͬ�ڳ�2��n�η���  >>�Ǵ��������ƣ�������λ��1��������0
 * >>>	���޷�������������������ƶ�ǰ���λ��0����1�����ƺ��������Ŀ�λ���ֶ���0����䡣
 */
public class MoveBitTest {

	public static void main(String[] args) {
		int a = 13;
		System.out.println("�ƶ�ǰ a = " + a + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(a));

		int b = a << 2; // a������λ���൱��a * 2��2�η�
		System.out.println("���ƺ� a = " + b + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(b));

		int c = a >> 2; // a������λ���൱��a / 2��2�η�
		System.out.println("���ƺ� a = " + c + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(c));

		int d = -12;
		System.out.println("�ƶ�ǰ d = " + d + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(d));
		System.out.println(bitInfo(d));

		// ����������
		int e = d >> 2;
		System.out.println("���������ƺ� d = " + e + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(e));
		// �޷�������
		int f = d >>> 2;
		System.out.println("�޷������ƺ� d = " + f + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(f));
	}
	
	private static String bitInfo(int num) {
		StringBuffer str = new StringBuffer();
		
		String binaryStr = Integer.toBinaryString(num);
		int i = 0;
		while(i < binaryStr.length()) {
			str.append(binaryStr.substring(i, i+4));
			str.append(" ");
			i += 4;
		}
		
		return str.toString();
	}
}