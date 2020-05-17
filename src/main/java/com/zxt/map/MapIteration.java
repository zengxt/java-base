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

		// ѭ��Map�ļ��ַ���
		// ����һ����for-eachѭ����ʹ��entries������
		// ��������Ĳ����ڴ���������Ҳ�����ȡ�ı�������
		// �����������һ����map���󰡣�for-eachѭ�����׳�NullPointerException
		for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}

		// ����������for-eachѭ���б���keys��values��
		// �÷�����entrySet�������������Ժã�����10%�������Ҵ�����Ӹɾ���
		// ���ֻ��Ҫmap�еļ�����ֵ������ͨ��keySet��values��ʵ�ֱ�������������entrySet
		// ����map�еļ�
		for (String key : testMap.keySet()) {
			System.out.println("key = " + key);
		}
		// ����map�е�ֵ
		for (Integer value : testMap.values()) {
			System.out.println("value = " + value);
		}

		// ��������ʹ��Iterator������ʹ�÷��ͣ�
		Iterator<Map.Entry<String, Integer>> entries = testMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, Integer> entry = entries.next();
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
		// ��ʹ�÷���
		Iterator entriess = testMap.entrySet().iterator();
		while (entriess.hasNext()) {
			Map.Entry entry = (Map.Entry) entriess.next();
			String key = (String) entry.getKey();
			Integer value = (Integer) entry.getValue();
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}

		// �����ģ�ͨ������ֵ������Ч�ʵͣ�
		for (String key : testMap.keySet()) {
			Integer value = testMap.get(key);
			System.out.println("key = " + key + ", value = " + value);
		}
	}
}
