
public class Parameter {
	
	public static void main(String[] args) {
		int real = 5;
		Obj obj = new Obj("5", 5);
		String str = "5";
		StringBuffer bf = new StringBuffer("5");
		
		System.out.println("���÷���ǰ��");
		System.out.println("real = " + real);
		System.out.println("obj = " + obj);
		System.out.println("str = " + str);
		System.out.println("bf = " + bf);
		
		method(real);
		method(obj);
		method(str);
		method(bf);
		System.out.println("���÷�����");
		System.out.println("real = " + real);
		System.out.println("obj = " + obj);
		System.out.println("str = " + str);
		System.out.println("bf = " + bf);
	}
	
	public static void method(int para) {
		// �����������ͣ��βεĸı䲻Ӱ��ʵ��
		para = 10;
	}
	
	public static void method(Obj para) {
		// �����������ͣ�����ͨ����ͬ�������޸Ķ�������
		para.age = 10;
	}
	
	public static void method(String para) {
		// �����������ͣ��β�ָ���µĶ��󣬲�Ӱ��ʵ�Σ�String�಻�ɱ䣬+����������¶���
		para = para + 10;
	}
	
	public static void method(StringBuffer para) {
		// �����������ͣ�����ͨ����ͬ�������޸Ķ�������
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
		return "name��" + name + "��age��" + age;
	}
}