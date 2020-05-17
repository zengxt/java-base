package com.zxt.bitset;

import java.util.BitSet;

public class WhichChars {
	private BitSet used = new BitSet();
	
	// 判断一个字符串中的那些字符出现过
	public static void main(String args[]) {
		WhichChars w = new WhichChars("How do you do");
		System.out.println(w);
	}

	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			// set bit for char
			used.set(str.charAt(i));
		}
	}

	public String toString() {
		String desc = "[";
		int size = used.size();
		for (int i = 0; i < size; i++) {
			if (used.get(i)) {
				desc += (char) i;
			}
		}
		return desc + " ]";
	}	
}