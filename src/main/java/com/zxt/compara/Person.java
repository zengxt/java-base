package com.zxt.compara;

/**
 * 
 * @Description: �Զ�����ʵ��Comparable�ӿ�ʵ�ֱȽϴ�С
 *
 * @author�� zxt
 *
 * @time: 2018��5��15�� ����9:18:42
 *
 */
public class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * ʵ��Comparable�ӿڣ�������ڲ�ʵ�ֱȽ��߼���ͨ������compareTo���������һ�����Զ������������ԱȽϴ�С
	 * ���Զ��������ڼ������У�����ʹ��Collections��sort����Ȼ���򣬲����ṩ�Ƚ�������Ȼ�����ʵ�ּ�compareTo����
	 */
	@Override
	public int compareTo(Person anotherPerson) {
		// �ȱȽ�name�Ĵ�С����һ���ٱȽ�age�Ĵ�С
		
		// ʹ���ַ����ıȽ�
		int flag = name.compareTo(anotherPerson.getName());
		if(flag == 0) {
			// ������ȣ���Ƚ�����
			return age - anotherPerson.getAge();
			
		} else {
			// ���ֲ�һ�����������ֱȽϽ��
			return flag;
		}
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
