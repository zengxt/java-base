package com.zxt.compara;

import java.util.Comparator;

/**
 * 
 * @Description: ʵ��Comparator�ӿڣ�ʵ��һ���Ƚ���
 *
 * @author�� zxt
 *
 * @time: 2018��5��15�� ����9:49:45
 *
 */
public class CatComparator implements Comparator<Cat> {

	/**
	 * ʵ��Comparator�ӿڣ�������ⲿʵ�ֱȽ��߼���ͨ������compare������
	 * ���Զ��������ڼ������У�ʹ��Collections��sort������ʱ����Ҫ�ṩ�����౾���Լ��ñȽ�����
	 */
	@Override
	public int compare(Cat cat1, Cat cat2) {
		// �ȱȽ�name�Ĵ�С����һ���ٱȽ�age�Ĵ�С
		
		// ʹ���ַ����ıȽ�
		int flag = cat1.getName().compareTo(cat2.getName());
		if(flag == 0) {
			// ������ȣ���Ƚ�����
			return cat1.getAge() - cat2.getAge();
			
		} else {
			// ���ֲ�һ�����������ֱȽϽ��
			return flag;
		}
	}

}
