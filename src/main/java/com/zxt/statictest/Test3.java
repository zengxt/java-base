package com.zxt.statictest;

// ��̬��final�����ڱ����ھ���ȷ��
public class Test3 {
	// ������ֻ����һ�Σ����Կ�Ч��ʱֻ��ִ��һ��
	public static void main(String[] args) {
		/**
		 * ֻ���classB
		 * ���ǵ�strû��final����ʱ�������
		 * A
		 * B
		 * classB
		 */
		// System.out.println(B.str);
		
		/**
		 * ���
		 * A
		 * C
		 * classC
		 */
		// System.out.println(C.str);
		
		/**
		 * �����
		 * A
		 * D
		 * 100
		 */
		// System.out.println(D.bb);
		System.out.println(D.aa);
		
		/**
		 * ֻ���200
		 */
		// System.out.println(D.cc);
	}
}

class A {
	static {
		System.out.println("A");
	}
}

class B extends A {
	static {
		System.out.println("B");
	}
	
	public static final String str = "calssB";
}

class C extends A {
	static {
		System.out.println("C");
	}
	
	public static final String str = new String("classC");
}

class D extends A {
	static {
		System.out.println("D");
	}
	
	public static final int cc = 200;
	public static final Integer aa = 100;
	public static final Integer bb = new Integer(100);
}