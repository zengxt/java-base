
public class Parameter {
	
	public static void main(String[] args) {
		int real = 5;
		Obj obj = new Obj("5", 5);
		String str = "5";
		StringBuffer bf = new StringBuffer("5");
		
		System.out.println("调用方法前：");
		System.out.println("real = " + real);
		System.out.println("obj = " + obj);
		System.out.println("str = " + str);
		System.out.println("bf = " + bf);
		
		method(real);
		method(obj);
		method(str);
		method(bf);
		System.out.println("调用方法后：");
		System.out.println("real = " + real);
		System.out.println("obj = " + obj);
		System.out.println("str = " + str);
		System.out.println("bf = " + bf);
	}
	
	public static void method(int para) {
		// 基本数据类型，形参的改变不影响实参
		para = 10;
	}
	
	public static void method(Obj para) {
		// 引用数据类型，可以通过相同的引用修改对象内容
		para.age = 10;
	}
	
	public static void method(String para) {
		// 引用数据类型，形参指向新的对象，不影响实参（String类不可变，+操作会产生新对象）
		para = para + 10;
	}
	
	public static void method(StringBuffer para) {
		// 引用数据类型，可以通过相同的引用修改对象内容
		para.append(10);
	}
}

class Obj {
	String name;
	int age;
	
	public Obj(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "name：" + name + "，age：" + age;
	}
}