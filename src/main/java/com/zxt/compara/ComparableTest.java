package com.zxt.compara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("zhangsan", 45));
		list.add(new Person("lisi", 34));
		list.add(new Person("alilang", 11));
		list.add(new Person("woshishui", 45));
		list.add(new Person("zhangsan", 12));
		list.add(new Person("lisi", 50));
		list.add(new Person("wangwu", 23));
		
		System.out.println("初始列表：");
		for(Person person : list) {
			System.out.print(person + "\t");
		}
		System.out.println();
		
		System.out.println("排序后：");
		Collections.sort(list);
		for(Person person : list) {
			System.out.print(person + "\t");
		}
	}
}
