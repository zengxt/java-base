package com.zxt.compara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {
		List<Cat> list = new ArrayList<Cat>();
		list.add(new Cat("xiaohong", 12));
		list.add(new Cat("xiaohua", 32));
		list.add(new Cat("dahua", 33));
		list.add(new Cat("dahuang", 45));
		list.add(new Cat("dahua", 7));
		list.add(new Cat("xiaohong", 45));
		list.add(new Cat("xiaohei", 22));
		
		
		System.out.println("初始列表：");
		for(Cat cat : list) {
			System.out.print(cat + "\t");
		}
		System.out.println();
		
		System.out.println("排序后：");
		Collections.sort(list, new CatComparator());
		for(Cat cat : list) {
			System.out.print(cat + "\t");
		}
	}
}
