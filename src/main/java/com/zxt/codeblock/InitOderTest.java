package com.zxt.codeblock;

/**
 * 
 * @Description: ��ͬ������ִ��˳�����
 *
 * @author�� zxt
 *
 * @time: 2018��4��3�� ����9:55:22
 *
 */
public class InitOderTest {
	public static String STATIC_FIELD = "��̬����";
	
	public static void main(String[] args) {
		new InitOderTest();
	}

	// ��̬�飨����ִ�У�ִֻ��һ�Σ�
	static {
		System.out.println(STATIC_FIELD);
		System.out.println("��̬�����");
	}

	public String field = "�Ǿ�̬����";

	// �Ǿ�̬�飨�������飬ÿ��new����ִ�й��췽��֮ǰִ�У�
	{
		System.out.println(field);
		System.out.println("�Ǿ�̬�����");
	}

	public InitOderTest() {
		System.out.println("�޲ι��캯��");
	}
}
