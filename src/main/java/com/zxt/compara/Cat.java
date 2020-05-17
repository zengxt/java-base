package com.zxt.compara;

/**
 * 
 * @Description: 自定义类实现实现比较大小，使用Comparator接口可以不修改源代码
 *
 * @author： zxt
 *
 * @time: 2018年5月15日 上午9:18:42
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
		return "[ name：" + name + ", age：" + age + " ]";
	}
}
