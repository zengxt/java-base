package com.zxt.string.test;

/**
 * @Description: �ַ������ú�������
 * @author�� zxt
 * @time: 2018��5��1�� ����8:23:33
 */
public class StringTest {

    public static void main(String[] args) {
        boolean b = true;
        System.out.println(String.valueOf(b));  // true

        char[] data = {'a', 'b', 'c'};
        System.out.println(String.valueOf(data)); // abc

        String str = "fdsufhsudhf";
        System.out.println(str.substring(2));  // sufhsudhf
        // substring��������ʵ��������������������
        System.out.println(str.substring(2, 4));  // su


        // �ַ��������صĲ���
        String s1 = "abc";
        String s2 = "abc";
        System.out.println("s1 == s2 " + (s1 == s2)); // true������s1��s2��ָ���ַ����������е�"abc"
        System.out.println("s1.equals(s2) " + (s1.equals(s2))); // true

        // ��������������һ��������ַ������У�һ������������У�
        String s3 = new String("abc");
        String s4 = new String("abc");
        // s3��s4ջ���ĵ�ַ��ͬ��ָ������Ĳ�ͬ��ַ
        System.out.println("s3 == s4 " + (s3 == s4)); // false
        System.out.println("s3.equals(s4) " + (s3.equals(s4))); // true��ָ��Ķ�����������ͬ

        String s5 = "abcd";
        // ���ڳ�����ֵ�ڱ����ʱ��ͱ�ȷ��(�Ż�)�ˡ� �����"ab"��"cd"���ǳ�������˱���str3��ֵ�ڱ���ʱ�Ϳ���ȷ����
        String s6 = "ab" + "cd"; // ���д��������Ч����ͬ�ڣ� String str3 = "abcd";
        System.out.println("s5 == s6 " + (s5 == s6)); // true
        System.out.println("s5.equals(s6) " + (s5.equals(s6))); // true

        String s7 = "abcd";
        String s9 = "cd";
        String s8 = "ab" + s9; // ����s9�Ǳ����������ڱ����ʱ���޷�ȷ��s8��ֵ
        System.out.println("s7 == s8 " + (s7 == s8)); // false
        System.out.println("s7.equals(s8) " + (s7.equals(s8))); // true
    }

    /**
     * @Description:String�е�final�÷������ finalֻ�����õ�"ֵ"(���ڴ��ַ)��Ч������ʹ����ֻ��ָ���ʼָ����Ǹ����󣬸ı�����ָ��ᵼ�±����ڴ���
     * ��������ָ��Ķ���ı仯��final�ǲ�����ġ�
     */
    public void testFinal() {
        final StringBuffer a = new StringBuffer("111");
        @SuppressWarnings("unused") final StringBuffer b = new StringBuffer("222");

        // �˾���벻ͨ��
        // a = b;

        a.append("222");// ����ͨ��
    }
}
