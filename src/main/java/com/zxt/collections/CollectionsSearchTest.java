package com.zxt.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @Description: Collections�������ʹ�ã����ڲ��ң�
 *
 * @author�� zxt
 *
 * @time: 2018��5��13�� ����10:00:08
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
		
		System.out.println("Դ�б�" + list);
		
		// ���ֵ
		System.out.println("���ֵ��" + Collections.max(list));
		
		// ��Сֵ
		System.out.println("��Сֵ��" + Collections.min(list));
		
		// �滻
		Collections.replaceAll(list, -15, 12);
		System.out.println("-15�滻12��" + list);

		// ���ִ���
		System.out.println("12���ִ�����" + Collections.frequency(list, 12));
		
		// ����
		Collections.sort(list);
		System.out.println("�����" + list);
		// ���ֲ���
		System.out.println("-15�±꣺" + Collections.binarySearch(list, -15));
		System.out.println("7�±꣺" + Collections.binarySearch(list, 7));
		System.out.println("35�±꣺" + Collections.binarySearch(list, 35));
	}
}
