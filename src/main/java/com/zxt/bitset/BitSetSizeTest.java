package com.zxt.bitset;

import java.util.BitSet;

public class BitSetSizeTest {

	// BitSet默认的构造函数声明一个64位的BitSet，值都是false。如果你要用的位超过了默认size,它会再申请64位，而不是报错。
	// 你申请的位都是以64为倍数的，就是说你申请不超过一个64的就按64算，超过一个不超过2个的就按128算。......
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