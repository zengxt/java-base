package com.zxt.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @Description: Collections工具类的使用（关于排序）
 *
 * @author： zxt
 *
 * @time: 2018年5月13日 下午10:00:08
 *
 */
public class CollectionsSortTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(-15);
		list.add(7);
		list.add(4);
		list.add(35);
		list.add(9);
		
		System.out.println("源列表：" + list);
		
		// 逆序
		Collections.reverse(list);
		System.out.println("逆序：" + list);
		
		// 排序（自然顺序）
		Collections.sort(list);
		System.out.println("自然序：" + list);
		
		// 随机排序
		Collections.shuffle(list);
		System.out.println("随机序：" + list);
		
		// 定制排序的用法，将int类型转成string进行比较
		Collections.sort(list, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				String str1 = String.valueOf(o1);
				String str2 = String.valueOf(o2);
				
				return str1.compareTo(str2);
			}
		});
		System.out.println("定制序：" + list);
		
		// 旋转
		Collections.rotate(list, 3);
		System.out.println("旋转3：" + list);
		
		Collections.rotate(list, -3);
		System.out.println("旋转-3：" + list);
	}
}
