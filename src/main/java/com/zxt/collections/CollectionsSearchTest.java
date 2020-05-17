package com.zxt.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @Description: Collections工具类的使用（关于查找）
 *
 * @author： zxt
 *
 * @time: 2018年5月13日 下午10:00:08
 *
 */
public class CollectionsSearchTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(-15);
		list.add(7);
		list.add(4);
		list.add(35);
		list.add(9);
		
		System.out.println("源列表：" + list);
		
		// 最大值
		System.out.println("最大值：" + Collections.max(list));
		
		// 最小值
		System.out.println("最小值：" + Collections.min(list));
		
		// 替换
		Collections.replaceAll(list, -15, 12);
		System.out.println("-15替换12：" + list);

		// 出现次数
		System.out.println("12出现次数：" + Collections.frequency(list, 12));
		
		// 排序
		Collections.sort(list);
		System.out.println("排序后：" + list);
		// 二分查找
		System.out.println("-15下标：" + Collections.binarySearch(list, -15));
		System.out.println("7下标：" + Collections.binarySearch(list, 7));
		System.out.println("35下标：" + Collections.binarySearch(list, 35));
	}
}
