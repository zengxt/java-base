package com.zxt.integer;

public class IntegerTest {

	public static void main(String[] args) {
		// highestOneBit�����ؾ������൥�� 1 λ�� int ֵ����ָ���� int ֵ�����λ������ߣ��� 1 λ��λ�á�
		// ��˼���Ǳ������������λ��1������������Ϊ0�������һ����������ı���С��2��N�η���������Ϊ����������-2147483648��
		// 0001 0001 ---> 0001 0000
		System.out.println(Integer.highestOneBit(17));
		// 1111 ---> 1000
		System.out.println(Integer.highestOneBit(15));
		System.out.println(Integer.highestOneBit(32));
		System.out.println(Integer.highestOneBit(63));
		System.out.println(Integer.highestOneBit(0));
		System.out.println(Integer.highestOneBit(-1));
		
		
		// lowestOneBit(int i)�����ؾ������൥�� 1 λ�� int ֵ����ָ���� int ֵ�����λ�����ұߣ��� 1 λ��λ�á�
		// �����һλ1����������λ��Ϊ0.
		// 0001 0001 ---> 0000 0001
		System.out.println(Integer.lowestOneBit(17));
		// 1100 ---> 0100
		System.out.println(Integer.lowestOneBit(12));
		
		
		// rotateLeft(int i, int distance)�����ظ���ָ����λ��ѭ������ָ���� int ֵ�Ķ����Ʋ����ʾ��ʽ���õ���ֵ��
		// ����������һλ�൱�ڳ���2������distance�൱�ڳ���2^distance
		System.out.println(Integer.rotateLeft(12, 3));
		System.out.println(Integer.rotateLeft(3, 2));
		// rotateRight(int i, int distance)�����ظ���ָ����λ��ѭ������ָ���� int ֵ�Ķ����Ʋ����ʾ��ʽ���õ���ֵ��
		// ����������һλ�൱�ڳ���2������distance�൱�ڳ���2^distance
		System.out.println(Integer.rotateRight(12, 2));
		
		
		// ��ͬ����֮�以��ת�� 
		// �ַ���ʮ����ת�ɶ�����
		System.out.println(Integer.toBinaryString(14));
		System.out.println(Integer.toString(14, 2));
		// �ַ���ʮ����ת�ɰ˽���
		System.out.println(Integer.toOctalString(14));
		System.out.println(Integer.toString(14, 8));
		// �ַ���ʮ����ת��ʮ������
		System.out.println(Integer.toHexString(14));
		System.out.println(Integer.toString(14, 16));
		// toString���Է���ý�Integerת��Ϊ�������
		System.out.println(Integer.toString(14, 7));
		
		// valueOf�Լ�parseInt�ɽ�������Ʊ�ʾ���ַ���ת��ΪInteger
		// �ṩ�Ľ��Ʋ�����ʾ�øý��ƻ����������ַ�����ת��Ϊ10���Ƶ�intֵ
		System.out.println(Integer.valueOf("0110", 2));
		System.out.println(Integer.valueOf("A6", 16));
		System.out.println(Integer.parseInt("0110", 2));
		System.out.println(Integer.parseInt("A6", 16));
	}
}
