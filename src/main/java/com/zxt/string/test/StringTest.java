package com.zxt.string.test;

/**
 * @Description: 字符串常用函数测试
 * @author： zxt
 * @time: 2018年5月1日 下午8:23:33
 */
public class StringTest {

    public static void main(String[] args) {
        boolean b = true;
        System.out.println(String.valueOf(b));  // true

        char[] data = {'a', 'b', 'c'};
        System.out.println(String.valueOf(data)); // abc

        String str = "fdsufhsudhf";
        System.out.println(str.substring(2));  // sufhsudhf
        // substring：包括其实索引，不包括结束索引
        System.out.println(str.substring(2, 4));  // su


        // 字符串常量池的测试
        String s1 = "abc";
        String s2 = "abc";
        System.out.println("s1 == s2 " + (s1 == s2)); // true：由于s1和s2都指向字符串常量池中的"abc"
        System.out.println("s1.equals(s2) " + (s1.equals(s2))); // true

        // 创建了两个对象，一个存放在字符串池中，一个存在与堆区中；
        String s3 = new String("abc");
        String s4 = new String("abc");
        // s3和s4栈区的地址不同，指向堆区的不同地址
        System.out.println("s3 == s4 " + (s3 == s4)); // false
        System.out.println("s3.equals(s4) " + (s3.equals(s4))); // true：指向的堆区的内容相同

        String s5 = "abcd";
        // 由于常量的值在编译的时候就被确定(优化)了。 在这里，"ab"和"cd"都是常量，因此变量str3的值在编译时就可以确定。
        String s6 = "ab" + "cd"; // 这行代码编译后的效果等同于： String str3 = "abcd";
        System.out.println("s5 == s6 " + (s5 == s6)); // true
        System.out.println("s5.equals(s6) " + (s5.equals(s6))); // true

        String s7 = "abcd";
        String s9 = "cd";
        String s8 = "ab" + s9; // 由于s9是变量，所以在编译的时候，无法确定s8的值
        System.out.println("s7 == s8 " + (s7 == s8)); // false
        System.out.println("s7.equals(s8) " + (s7.equals(s8))); // true
    }

    /**
     * @Description:String中的final用法和理解 final只对引用的"值"(即内存地址)有效，它迫使引用只能指向初始指向的那个对象，改变它的指向会导致编译期错误。
     * 至于它所指向的对象的变化，final是不负责的。
     */
    public void testFinal() {
        final StringBuffer a = new StringBuffer("111");
        @SuppressWarnings("unused") final StringBuffer b = new StringBuffer("222");

        // 此句编译不通过
        // a = b;

        a.append("222");// 编译通过
    }
}
