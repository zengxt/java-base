package com.zxt.codeblock;

public class ChildTest extends ParentTest {
	public static String STATIC_FIELD = "����-��̬����";

	// ��̬��
	static {
		System.out.println(STATIC_FIELD);
		System.out.println("����-��̬�����");
	}

	public String field = "����-�Ǿ�̬����";

	// �Ǿ�̬��
	{
		System.out.println(field);
		System.out.println("����-�Ǿ�̬�����");
	}

	public ChildTest() {
		System.out.println("����-�޲ι��캯��");
	}

	public static void main(String[] args) {
		new ChildTest();
	}
}
