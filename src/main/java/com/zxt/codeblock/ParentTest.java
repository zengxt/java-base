package com.zxt.codeblock;

public class ParentTest {
	public static String PARENT_STATIC_FIELD = "����-��̬����";

	// ����-��̬��
	static {
		System.out.println(PARENT_STATIC_FIELD);
		System.out.println("����-��̬�����");
	}

	public static String parentField = "����-�Ǿ�̬����";

	// ����-�Ǿ�̬��
	{
		System.out.println(parentField);
		System.out.println("����-�Ǿ�̬�����");
	}

	public ParentTest() {
		System.out.println("���ࡪ�޲ι��캯��");
	}
}
