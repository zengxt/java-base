package com.zxt.system;

public class SystemTest {

	public static void main(String[] args) {

		// arraycopy方法的作用是数组拷贝，也就是将一个数组中的内容复制到另外一个数组中的指定位置
		// 该方法是native方法，所以性能上比使用循环高效。
		int[] a = { 1, 2, 3, 4 };
		int[] b = new int[5];
		System.arraycopy(a, 1, b, 3, 2);
		System.out.print("数组a：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
		System.out.print("数组b：");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + "  ");
		}

		// currentTimeMillis()返回以毫秒为单位的当前时间。
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {

		}
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("\n");
		System.out.println("亿次循环运行时间：" + time + "毫秒！");

		// getProperty方法的作用是获得系统中属性名为key的属性对应的值。
		System.out.println("\n");
		System.out.println("Java 运行时环境版本：" + System.getProperty("java.version"));
		System.out.println("Java 安装目录：" + System.getProperty("java.home"));
		System.out.println("当前操作系统的名称：" + System.getProperty("os.name"));
		System.out.println("当前操作系统的版本：" + System.getProperty("os.version"));
		System.out.println("当前用户的账户名称：" + System.getProperty("user.name"));
		System.out.println("当前用户的主目录：" + System.getProperty("user.home"));
		System.out.println("当前用户的当前工作目录：" + System.getProperty("user.dir"));
	}

}
