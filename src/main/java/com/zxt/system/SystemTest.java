package com.zxt.system;

public class SystemTest {

	public static void main(String[] args) {

		// arraycopy���������������鿽����Ҳ���ǽ�һ�������е����ݸ��Ƶ�����һ�������е�ָ��λ��
		// �÷�����native���������������ϱ�ʹ��ѭ����Ч��
		int[] a = { 1, 2, 3, 4 };
		int[] b = new int[5];
		System.arraycopy(a, 1, b, 3, 2);
		System.out.print("����a��");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
		System.out.print("����b��");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + "  ");
		}

		// currentTimeMillis()�����Ժ���Ϊ��λ�ĵ�ǰʱ�䡣
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {

		}
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("\n");
		System.out.println("�ڴ�ѭ������ʱ�䣺" + time + "���룡");

		// getProperty�����������ǻ��ϵͳ��������Ϊkey�����Զ�Ӧ��ֵ��
		System.out.println("\n");
		System.out.println("Java ����ʱ�����汾��" + System.getProperty("java.version"));
		System.out.println("Java ��װĿ¼��" + System.getProperty("java.home"));
		System.out.println("��ǰ����ϵͳ�����ƣ�" + System.getProperty("os.name"));
		System.out.println("��ǰ����ϵͳ�İ汾��" + System.getProperty("os.version"));
		System.out.println("��ǰ�û����˻����ƣ�" + System.getProperty("user.name"));
		System.out.println("��ǰ�û�����Ŀ¼��" + System.getProperty("user.home"));
		System.out.println("��ǰ�û��ĵ�ǰ����Ŀ¼��" + System.getProperty("user.dir"));
	}

}
