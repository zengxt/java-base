package com.zxt.compara;

/**
 * 
 * @Description: �Զ�����ʵ��ʵ�ֱȽϴ�С��ʹ��Comparator�ӿڿ��Բ��޸�Դ����
 *
 * @author�� zxt
 *
 * @time: 2018��5��15�� ����9:18:42
 *
 */
public class Cat{
	private String name;
	private int age;

	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "[ name��" + name + ", age��" + age + " ]";
	}
}
