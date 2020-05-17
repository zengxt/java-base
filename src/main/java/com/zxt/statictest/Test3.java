package com.zxt.statictest;

// 静态的final变量在编译期就能确定
public class Test3 {
	// 由于类只加载一次，所以看效果时只能执行一句
	public static void main(String[] args) {
		/**
		 * 只输出classB
		 * 但是当str没有final修饰时，会输出
		 * A
		 * B
		 * classB
		 */
		// System.out.println(B.str);
		
		/**
		 * 输出
		 * A
		 * C
		 * classC
		 */
		// System.out.println(C.str);
		
		/**
		 * 均输出
		 * A
		 * D
		 * 100
		 */
		// System.out.println(D.bb);
		System.out.println(D.aa);
		
		/**
		 * 只输出200
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