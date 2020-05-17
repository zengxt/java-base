package com.zxt.compara;

/**
 * 
 * @Description: 自定义类实现Comparable接口实现比较大小
 *
 * @author： zxt
 *
 * @time: 2018年5月15日 上午9:18:42
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
	 * 实现Comparable接口，在类的内部实现比较逻辑，通过覆盖compareTo方法，如此一来，自定义的两个类可以比较大小
	 * 将自定义的类放在集合类中，可以使用Collections的sort来自然排序，不用提供比较器。自然排序的实现即compareTo方法
	 */
	@Override
	public int compareTo(Person anotherPerson) {
		// 先比较name的大小，若一样再比较age的大小
		
		// 使用字符串的比较
		int flag = name.compareTo(anotherPerson.getName());
		if(flag == 0) {
			// 名字相等，则比较年龄
			return age - anotherPerson.getAge();
			
		} else {
			// 名字不一样，返回名字比较结果
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
		return "[ name：" + name + ", age：" + age + " ]";
	}
}
