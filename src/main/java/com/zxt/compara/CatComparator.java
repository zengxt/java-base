package com.zxt.compara;

import java.util.Comparator;

/**
 * 
 * @Description: 实现Comparator接口，实现一个比较器
 *
 * @author： zxt
 *
 * @time: 2018年5月15日 上午9:49:45
 *
 */
public class CatComparator implements Comparator<Cat> {

	/**
	 * 实现Comparator接口，在类的外部实现比较逻辑，通过覆盖compare方法，
	 * 将自定义的类放在集合类中，使用Collections的sort来排序时，需要提供集合类本身，以及该比较器。
	 */
	@Override
	public int compare(Cat cat1, Cat cat2) {
		// 先比较name的大小，若一样再比较age的大小
		
		// 使用字符串的比较
		int flag = cat1.getName().compareTo(cat2.getName());
		if(flag == 0) {
			// 名字相等，则比较年龄
			return cat1.getAge() - cat2.getAge();
			
		} else {
			// 名字不一样，返回名字比较结果
			return flag;
		}
	}

}
