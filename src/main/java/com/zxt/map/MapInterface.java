package com.zxt.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

// 这是标准的Map接口
public interface MapInterface<K, V> {
	
	// 返回此映射中的键-值映射关系数。
	int size();

	// 如果此映射未包含键-值映射关系，则返回 true。
	boolean isEmpty();
	
	// 如果此映射包含指定键的映射关系，则返回 true。
	boolean containsKey(Object key);
	
	// 如果此映射将一个或多个键映射到指定值，则返回 true。
	boolean containsValue(Object value);

	// 返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
	V get(Object key);

	// 将指定的值与此映射中的指定键关联（可选操作）。
	V put(K key, V value);

	// 如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
	V remove(Object key);

	// 从指定映射中将所有映射关系复制到此映射中（可选操作）。
	void putAll(Map<? extends K, ? extends V> m);

	// 从此映射中移除所有映射关系（可选操作）。
	void clear();

	// 返回此映射中包含的键的 Set 视图。
	Set<K> keySet();

	// 返回此映射中包含的值的 Collection 视图。
	Collection<V> values();

	// 返回此映射中包含的映射关系的 Set 视图。
	Set<Map.Entry<K, V>> entrySet();

	// Map.Entry是Map的一个内部接口。 Entry也是键值对，只不过Entry只是Map中的一个键值对
	interface Entry<K, V> {

		K getKey();

		V getValue();

		V setValue(V value);

		boolean equals(Object o);

		int hashCode();
	}

	// 比较指定的对象与此映射是否相等。
	boolean equals(Object o);

	// 返回此映射的哈希码值。
	int hashCode();
}