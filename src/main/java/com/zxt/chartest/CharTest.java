package com.zxt.chartest;

public class CharTest {

	/**
	 * 
	 * @Description:总结：1、字符参与运算会自动转换为ascii整形
	 * 					2、若字符中保存的为数字字符，并且要使用该数字：c - '0'，  char e = (char) (c + 5); 也可实现字符所代表的数字运算
	 * 					3、将一个整型数字转换为char类型，代表的是ascii码所对应的字符
	 * 					4、标准ascii码为 0-127， 扩展ascii为128-256
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char c = '2';
		System.out.println(c); // 2
		System.out.println((int) c); // 50

		// 和整数运算时，char类型自动转换为int，而char-->int值，为字符所对应的ASCII码
		int a = c + 2;
		System.out.println(a); // 52

		// 常见的ASCII码值
		System.out.println((int) '0'); // 48
		System.out.println((int) '1');
		System.out.println((int) '9');
		System.out.println((int) 'a'); // 97
		System.out.println((int) 'A');
		System.out.println((int) 'z');
		System.out.println((int) 'Z');

		int b = c - '0' + 3;
		System.out.println(b); // 5
		int d = c + 3;
		System.out.println(d); // 53

		char e = (char) (c + 5);
		System.out.println(e); // 7
		System.out.println((char) ('2' + 5)); // 7
		char g = (char) 97;
		System.out.println(g); // a
		char v = (char) 300;
		System.out.println(v); // a

		char f = '1' + '2';
		System.out.println(f); // c ASCII码 49 + 50 = 99 即 字符c
	}

}
