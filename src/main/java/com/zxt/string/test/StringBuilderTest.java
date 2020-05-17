package com.zxt.string.test;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder hello = new StringBuilder("Hello");
        hello.append(" world");

        // 自动调用 toString() 方法
        System.out.println(hello);

        /**
         * StringBuilder 的 toString方法实际上是新建了一个 String
         * return new String(value, 0, count);
         */
        String str1 = hello.toString();
        String str2 = hello.toString();
        System.out.println(str1 == str2);
    }
}
