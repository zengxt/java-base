package com.zxt.modifier;

import java.lang.reflect.Modifier;

import java.lang.reflect.Field;

public class ModifierTest {

	public static void main(String[] args) {
		Class<?> clazz = Test.class;

		// ��ȡ��������еĳ�Ա����
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			// ����ֶε�����
			System.out.print("�ֶ�����" + field.getName() + " --> ");
			// ����ֶε����η��ַ���
			System.out
					.println("���η���" + Modifier.toString(field.getModifiers()) + " (intֵ��" + field.getModifiers() + ")");
		}
	}
}

class Test {
	public int a;
	public static int b;
	public static final int c = 0;
	private int d;

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
}