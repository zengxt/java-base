package com.zxt.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @Description: Collections�������ʹ�ã���������
 *
 * @author�� zxt
 *
 * @time: 2018��5��13�� ����10:00:08
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
		
		System.out.println("Դ�б�" + list);
		
		// ����
		Collections.reverse(list);
		System.out.println("����" + list);
		
		// ������Ȼ˳��
		Collections.sort(list);
		System.out.println("��Ȼ��" + list);
		
		// �������
		Collections.shuffle(list);
		System.out.println("�����" + list);
		
		// ����������÷�����int����ת��string���бȽ�
		Collections.sort(list, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				String str1 = String.valueOf(o1);
				String str2 = String.valueOf(o2);
				
				return str1.compareTo(str2);
			}
		});
		System.out.println("������" + list);
		
		// ��ת
		Collections.rotate(list, 3);
		System.out.println("��ת3��" + list);
		
		Collections.rotate(list, -3);
		System.out.println("��ת-3��" + list);
	}
}
