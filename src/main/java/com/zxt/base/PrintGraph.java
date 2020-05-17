package com.zxt.base;

public class PrintGraph {

	public static void main(String[] args) {
		// 表示有多少层
		int lay = 4;
		
		for (int i = 1; i <= lay; i++) {
			// 打印*
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 金字塔
		lay = 10;
		for (int i = 1; i <= lay; i++) {
			// 1->3 2->2 3->1 4->0找出空格
			for (int k = 1; k <= lay - i; k++) {
				System.out.print(" ");
			}
			// 打印*
			// 1->1 2->3 3->5 4->7找出星的规律
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 镂空金字塔
		lay = 10;
		for (int i = 1; i <= lay; i++) {
			for (int k = 1; k <= lay - i; k++) {
				System.out.print(" ");
			}
			// 打印*
			// 1->1 2->3 3->5 4->7找出星的规律
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
				// 判断该层是否是顶层或者是底层
				if (i == 1 || i == lay) {
					System.out.print("*");
				} else {
					// 如果是第一个*
					if (j == 1 || j == (i - 1) * 2 + 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}

		// 空心菱形
		// 菱形上半部行数
		lay = 4;
		// 判断循环上半部分
		for (int i = 1; i <= lay - 1; i++) {
			// 判断循环上半部分
			for (int k = 1; k <= lay - i; k++) {
				System.out.print(" ");
			}
			// 找行内输出星的位置
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
				// 判断行最小长度和最大长度，并在最小长度和最大长度上输出*号，行内输入出空格。
				if (j == 1 || j == (i - 1) * 2 + 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		// 判断循环菱形下半部分
		for (int i = 1; i <= lay; i++) { 
			// 判断循环找*号前要输出空格处
			for (int k = 1; k <= i - 1; k++) {
				System.out.print(" ");
			}
			// 判断循环行长度
			for (int j = 1; j <= (lay - i) * 2 + 1; j++) {
				// 判断行最小长度和最大长度，并在最小长度和最大长度上输出*号，行内输入出空格。
				if (j == 1 || j == (lay - i) * 2 + 1) { 
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}