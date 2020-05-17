package com.zxt.modifier;

import java.lang.reflect.Modifier;

import java.lang.reflect.Field;

public class ModifierTest {

	public static void main(String[] args) {
		Class<?> clazz = Test.class;

		// 获取这个类所有的成员变量
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			// 输出字段的名称
			System.out.print("字段名：" + field.getName() + " --> ");
			// 输出字段的修饰符字符串
			System.out
					.println("修饰符：" + Modifier.toString(field.getModifiers()) + " (int值：" + field.getModifiers() + ")");
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