package com.zxt.bitset;

import java.util.BitSet;

public class BitSetSizeTest {

	// BitSetĬ�ϵĹ��캯������һ��64λ��BitSet��ֵ����false�������Ҫ�õ�λ������Ĭ��size,����������64λ�������Ǳ���
	// �������λ������64Ϊ�����ģ�����˵�����벻����һ��64�ľͰ�64�㣬����һ��������2���ľͰ�128�㡣......
	public static void main(String[] args) {
		BitSet bm = new BitSet();
		System.out.println(bm.isEmpty() + "--" + bm.size());
		bm.set(0);
		System.out.println(bm.isEmpty() + "--" + bm.size());

		System.out.println(bm.get(65));
		System.out.println(bm.isEmpty() + "--" + bm.size());
		bm.set(65);
		System.out.println(bm.isEmpty() + "--" + bm.size());

		BitSet bm1 = new BitSet(7);
		System.out.println(bm1.isEmpty() + "--" + bm1.size());

		BitSet bm2 = new BitSet(63);
		System.out.println(bm2.isEmpty() + "--" + bm2.size());

		BitSet bm3 = new BitSet(65);
		System.out.println(bm3.isEmpty() + "--" + bm3.size());

		BitSet bm4 = new BitSet(111);
		System.out.println(bm4.isEmpty() + "--" + bm4.size());
	}
}