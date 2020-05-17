package com.zxt.treeset;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Parent> set = new TreeSet<Parent>();
		// 加入的是什么对象，就用什么对象的compareTo方法
		set.add(new Parent(3));
		set.add(new Child());
		set.add(new Parent(4));
		set.add(new Child());
		set.add(new Parent(4));
		// 要比较多少次就要看新插入的元素在有序二叉树中的位置了
		set.add(new Child());
		System.out.println(set.size());
	}
}

class Parent implements Comparable<Object> {
	private int age = 0;

	public Parent(int age) {
		this.age = age;
	}

	public int compareTo(Object o) {
		System.out.println("method of parent");
		Parent o1 = (Parent) o;
		return age > o1.age ? 1 : age < o1.age ? -1 : 0;
	}

}

class Child extends Parent {

	public Child() {
		super(3);
	}

	public int compareTo(Object o) {
		System.out.println("method of child");
		// Child o1 = (Child)o;
		return 1;
	}
}
