package com.zxt.bitset;

import java.util.BitSet;

public class BitSetUse {

	public static void main(String[] args) {
		int[] shu = { 2, 42, 5, 6, 6, 18, 33, 15, 25, 31, 28, 37 };
		int maxvalue = BitSetUse.getMaxValue(shu);
		BitSet bm = new BitSet(maxvalue);
		System.out.println("maxvalue--" + maxvalue);
		System.out.println("bm.size()--" + bm.size());

		// 放值
		for (int i = 0; i < shu.length; i++) {
			bm.set(shu[i], true);
		}
		printBitSet(bm);
	}

	// 打印
	public static void printBitSet(BitSet bs) {
		StringBuffer buf = new StringBuffer();
		buf.append("[\n");
		for (int i = 0; i < bs.size(); i++) {
			if (i < bs.size() - 1) {
				buf.append(BitSetUse.getBitTo10(bs.get(i)) + ",");
			} else {
				buf.append(BitSetUse.getBitTo10(bs.get(i)));
			}
			if ((i + 1) % 8 == 0 && i != 0) {
				buf.append("\n");
			}
		}
		buf.append("]");
		System.out.println(buf.toString());
	}

	// 找出数据集合最大值
	public static int getMaxValue(int[] zu) {
		int max = zu[0];

		for (int i = 0; i < zu.length; i++) {
			if (max < zu[i]) {
				max = zu[i];
			}
		}
		
		return max;
	}

	// true, false换成1, 0为了好看
	public static String getBitTo10(boolean flag) {

		return flag ? "1":"0";
	}
}