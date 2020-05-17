package com.zxt.map;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapIteration {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String args[]) {
		Map<String, Integer> testMap = new ConcurrentHashMap<String, Integer>();
		testMap.put("Tom", 12);
		testMap.put("Kat", 16);
		testMap.put("Jey", 19);

		// 循环Map的几种方法
		// 方法一：在for-each循环中使用entries来遍历
		// 这是最常见的并且在大多数情况下也是最可取的遍历方法
		// 如果遍历的是一个空map对象啊，for-each循环将抛出NullPointerException
		for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}

		// 方法二：在for-each循环中遍历keys或values。
		// 该方法比entrySet遍历在性能上稍好（快了10%），而且代码更加干净。
		// 如果只需要map中的键或者值，可以通过keySet或values来实现遍历，而不是用entrySet
		// 遍历map中的键
		for (String key : testMap.keySet()) {
			System.out.println("key = " + key);
		}
		// 遍历map中的值
		for (Integer value : testMap.values()) {
			System.out.println("value = " + value);
		}

		// 方法三：使用Iterator遍历（使用泛型）
		Iterator<Map.Entry<String, Integer>> entries = testMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, Integer> entry = entries.next();
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
		// 不使用泛型
		Iterator entriess = testMap.entrySet().iterator();
		while (entriess.hasNext()) {
			Map.Entry entry = (Map.Entry) entriess.next();
			String key = (String) entry.getKey();
			Integer value = (Integer) entry.getValue();
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}

		// 方法四：通过键找值遍历（效率低）
		for (String key : testMap.keySet()) {
			Integer value = testMap.get(key);
			System.out.println("key = " + key + ", value = " + value);
		}
	}
}
