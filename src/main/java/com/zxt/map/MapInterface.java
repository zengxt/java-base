package com.zxt.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

// ���Ǳ�׼��Map�ӿ�
public interface MapInterface<K, V> {
	
	// ���ش�ӳ���еļ�-ֵӳ���ϵ����
	int size();

	// �����ӳ��δ������-ֵӳ���ϵ���򷵻� true��
	boolean isEmpty();
	
	// �����ӳ�����ָ������ӳ���ϵ���򷵻� true��
	boolean containsKey(Object key);
	
	// �����ӳ�佫һ��������ӳ�䵽ָ��ֵ���򷵻� true��
	boolean containsValue(Object value);

	// ����ָ������ӳ���ֵ�������ӳ�䲻�����ü���ӳ���ϵ���򷵻� null��
	V get(Object key);

	// ��ָ����ֵ���ӳ���е�ָ������������ѡ��������
	V put(K key, V value);

	// �������һ������ӳ���ϵ������Ӵ�ӳ�����Ƴ�����ѡ��������
	V remove(Object key);

	// ��ָ��ӳ���н�����ӳ���ϵ���Ƶ���ӳ���У���ѡ��������
	void putAll(Map<? extends K, ? extends V> m);

	// �Ӵ�ӳ�����Ƴ�����ӳ���ϵ����ѡ��������
	void clear();

	// ���ش�ӳ���а����ļ��� Set ��ͼ��
	Set<K> keySet();

	// ���ش�ӳ���а�����ֵ�� Collection ��ͼ��
	Collection<V> values();

	// ���ش�ӳ���а�����ӳ���ϵ�� Set ��ͼ��
	Set<Map.Entry<K, V>> entrySet();

	// Map.Entry��Map��һ���ڲ��ӿڡ� EntryҲ�Ǽ�ֵ�ԣ�ֻ����Entryֻ��Map�е�һ����ֵ��
	interface Entry<K, V> {

		K getKey();

		V getValue();

		V setValue(V value);

		boolean equals(Object o);

		int hashCode();
	}

	// �Ƚ�ָ���Ķ������ӳ���Ƿ���ȡ�
	boolean equals(Object o);

	// ���ش�ӳ��Ĺ�ϣ��ֵ��
	int hashCode();
}