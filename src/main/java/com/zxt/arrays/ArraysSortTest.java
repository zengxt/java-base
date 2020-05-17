package com.zxt.arrays;
import java.util.Arrays;

public class ArraysSortTest {

	public static void main(String[] args) {
		String[] ary = { "test", "abc", "apple", "PEar" };
		System.out.println("Before sorted, the array is: " + Arrays.toString(ary));
		Arrays.sort(ary);
		System.out.println("After sorted, the new array is: " + Arrays.toString(ary));

		String str = "usadhfydsgs";
		char[] cha = str.toCharArray();
		System.out.println(Arrays.toString(cha));
		Arrays.sort(cha);
		System.out.println(Arrays.toString(cha));
	}
}