package com.zxt.string.test;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder hello = new StringBuilder("Hello");
        hello.append(" world");

        // �Զ����� toString() ����
        System.out.println(hello);

        /**
         * StringBuilder �� toString����ʵ�������½���һ�� String
         * return new String(value, 0, count);
         */
        String str1 = hello.toString();
        String str2 = hello.toString();
        System.out.println(str1 == str2);
    }
}
