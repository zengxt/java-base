package com.zxt.base;

public class StaticVarTest {
	static int i = 1;
	static {
		// �þ�̬�����ֻ��ִ��һ��
		i++;
		System.out.println("ִ��һ��");
	}

	// ����StaticVarTest()���캯��
	public StaticVarTest() {
		System.out.println("ִ�ж���");
		i++;
	}

	public static void main(String[] args) {
		// ����t1����ʵ��������StaticVarTest����
		new StaticVarTest(); 
		System.out.println(StaticVarTest.i);

		new StaticVarTest();
		System.out.println(StaticVarTest.i);
	}
}