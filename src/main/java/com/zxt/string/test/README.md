# Java.lang.String简介

```java
	public final class String extends Object implements Serializable, Comparable<String>, CharSequence
```

String 类代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。

字符串是常量；它们的值在创建之后不能更改。字符串缓冲区支持可变的字符串。因为 String 对象是不可变的，所以可以共享。例如：

```java
String str = "abc";

等效于：

char data[] = {'a', 'b', 'c'};
String str = new String(data);
```

下面给出了一些如何使用字符串的更多示例：

```java
System.out.println("abc");
String cde = "cde";
System.out.println("abc" + cde);
String c = "abc".substring(2,3);
String d = cde.substring(1,2);
```

String 类包括的方法可用于检查序列的单个字符、比较字符串、搜索字符串、提取子字符串、创建字符串副本并将所有字符全部转换为大写或小写。大小写映射基于Character类指定的 Unicode 标准版。

Java 语言提供对字符串串联符号（"+"）以及将其他对象转换为字符串的特殊支持。字符串串联是通过 StringBuilder（或 StringBuffer）类及其 append 方法实现的。字符串转换是通过 toString 方法实现的，该方法由 Object 类定义，并可被 Java 中的所有类继承。

除非另行说明，否则将 null 参数传递给此类中的构造方法或方法将抛出 NullPointerException。

String 表示一个 UTF-16 格式的字符串，其中的增补字符由代理项对表示。索引值是指 char 代码单元，因此增补字符在 String 中占用两个位置。

String 类提供处理 Unicode 代码点（即字符）和 Unicode 代码单元（即 char 值）的方法。

 

## 字段摘要

static Comparator<String> CASE_INSENSITIVE_ORDER：一个对 String 对象进行排序的 Comparator，作用与 compareToIgnoreCase 相同。

 

## 构造方法摘要

String()：初始化一个新创建的 String 对象，使其表示一个空字符序列。

String(byte[] bytes)：通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。

String(byte[] bytes, Charset charset)：通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。

String(byte[] bytes, int offset, int length)：通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String。

String(byte[] bytes, int offset, int length, Charset charset)：通过使用指定的 charset 解码指定的 byte 子数组，构造一个新的 String。

String(byte[] bytes, int offset, int length, String charsetName)：通过使用指定的字符集解码指定的 byte 子数组，构造一个新的 String。

String(byte[] bytes, String charsetName)：通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。

String(char[] value)：分配一个新的 String，使其表示字符数组参数中当前包含的字符序列。

String(char[] value, int offset, int count)：分配一个新的 String，它包含取自字符数组参数一个子数组的字符。

String(int[] codePoints, int offset, int count)：分配一个新的 String，它包含 Unicode 代码点数组参数一个子数组的字符。

String(String original)：初始化一个新创建的 String 对象，使其表示一个与参数相同的字符序列；换句话说，新创建的字符串是该参数字符串的副本。

String(StringBuffer buffer)：分配一个新的字符串，它包含字符串缓冲区参数中当前包含的字符序列。

String(StringBuilder builder)：分配一个新的字符串，它包含字符串生成器参数中当前包含的字符序列。

 

## 常用方法摘要

### 字符串查找

**1****、****char charAt(int index)****：返回指定索引处的** **char** **值。**

**2****、****int indexOf(int ch)****：返回指定字符在此字符串中第一次出现处的索引。**

**3****、****int indexOf(String str)****：返回指定子字符串在此字符串中第一次出现处的索引。**

4、int indexOf(int ch, int fromIndex)：返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。

5、int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。

6、int lastIndexOf(int ch)：返回指定字符在此字符串中最后一次出现处的索引。

7、int lastIndexOf(int ch, int fromIndex)：返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。

8、int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引。

9、int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。

**10****、****boolean startsWith(String prefix)****：测试此字符串是否以指定的前缀开始。**

11、boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始。

**12****、****boolean endsWith(String suffix)****：测试此字符串是否以指定的后缀结束。**

 

### 长度相关

**1****、****int length()****：返回此字符串的长度。**

2、boolean isEmpty()：当且仅当 length() 为 0 时返回 true。

3、int hashCode()：返回此字符串的哈希码。

 

### 字符串比较函数

**1****、****int compareTo(String anotherString)****：按字典顺序比较两个字符串。**

2、int compareToIgnoreCase(String str)：按字典顺序比较两个字符串，不考虑大小写。

3、boolean contentEquals(CharSequence cs)：将此字符串与指定的 CharSequence 比较。

4、boolean contentEquals(StringBuffer sb)：将此字符串与指定的 StringBuffer 比较。

5、boolean equals(Object anObject)：将此字符串与指定的对象比较。

6、boolean equalsIgnoreCase(String anotherString)：将此 String 与另一个 String 比较，不考虑大小写。

7、boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)：测试两个字符串区域是否相等。

8、boolean regionMatches(int toffset, String other, int ooffset, int len)：测试两个字符串区域是否相等。

 

## 子字符串

1、String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。

2、String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串。

3、CharSequence subSequence(int beginIndex, int endIndex)：返回一个新的字符序列，它是此序列的一个子序列。

**4****、****String substring(int beginIndex)****：返回一个新的字符串，它是此字符串的一个子字符串。**

**5****、****String substring(int beginIndex, int endIndex)****：返回一个新字符串，它是此字符串的一个子字符串。**

 

## 字符串转换

**1****、****char[] toCharArray()****：将此字符串转换为一个新的字符数组。**

2、String toLowerCase()：使用默认语言环境的规则将此 String 中的所有字符都转换为小写。

3、String toLowerCase(Locale locale)：使用给定 Locale 的规则将此 String 中的所有字符都转换为小写。

4、String toString()：返回此对象本身（它已经是一个字符串！）。

5、String toUpperCase()：使用默认语言环境的规则将此 String 中的所有字符都转换为大写。

6、String toUpperCase(Locale locale)：使用给定 Locale 的规则将此 String 中的所有字符都转换为大写。

**7****、****String trim()****：返回字符串的副本，忽略前导空白和尾部空白。**

8、String intern()：返回字符串对象的规范化表示形式。

 

## getBytes：返回byte数组

1、byte[] getBytes()：使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。

2、byte[] getBytes(Charset charset)：使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。

3、byte[] getBytes(String charsetName)：使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。

 

## Replace：字符串替换

1、String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。

2、String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。

3、String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。

4、String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。

 

## valueOf：返回参数的字符串表示

1、static String valueOf(boolean b)：返回 boolean 参数的字符串表示形式。

2、static String valueOf(char c)：返回 char 参数的字符串表示形式。

3、static String valueOf(char[] data)：返回 char 数组参数的字符串表示形式。

4、static String valueOf(char[] data, int offset, int count)：返回 char 数组参数的特定子数组的字符串表示形式。

5、static String valueOf(double d)：返回 double 参数的字符串表示形式。

6、static String valueOf(float f)：返回 float 参数的字符串表示形式。

7、static String valueOf(int i)：返回 int 参数的字符串表示形式。

8、static String valueOf(long l)：返回 long 参数的字符串表示形式。

9、static String valueOf(Object obj)：返回 Object 参数的字符串表示形式。

## 其他

1、int codePointAt(int index)：返回指定索引处的字符（Unicode 代码点）。

2、int codePointBefore(int index)：返回指定索引之前的字符（Unicode 代码点）。

3、int codePointCount(int beginIndex, int endIndex)：返回此 String 的指定文本范围中的 Unicode 代码点数。

4、String concat(String str)：将指定字符串连接到此字符串的结尾。

5、boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true。

**6****、****static String copyValueOf(char[] data)****：返回指定数组中表示该字符序列的** **String****。**

7、static String copyValueOf(char[] data, int offset, int count)：返回指定数组中表示该字符序列的 String。

8、static String format(Locale l, String format, Object... args)：使用指定的语言环境、格式字符串和参数返回一个格式化字符串。

**9****、****static String format(String format, Object... args)****：使用指定的格式字符串和参数返回一个格式化字符串。**

10、void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)：将字符从此字符串复制到目标字符数组。

**11****、****boolean matches(String regex)****：告知此字符串是否匹配给定的正则表达式。**

12、int offsetByCodePoints(int index, int codePointOffset)：返回此 String 中从给定的 index 处偏移 codePointOffset 个代码点的索引。

 

# 程序实例

**package** com.zxt.string;

 

**import** org.junit.Test;

 

/**

 \* 

 \* **@Description**: 字符串常用函数测试

 *

 \* **@author**： zxt

 *

 \* **@time**: 2018年5月1日 下午8:23:33

 *

 */

**public** **class** StringTest {

 

  **public** **static** **void** main(String[] args) {

​    **boolean** b = **true**;

​    System.***out\***.println(String.*valueOf*(b)); // true

​    

​    **char**[] data = {'a', 'b', 'c'};

​    System.***out\***.println(String.*valueOf*(data)); // abc

​    

​    String str = "fdsufhsudhf";

​    System.***out\***.println(str.substring(2)); // sufhsudhf

​    // substring：包括其实索引，不包括结束索引

​    System.***out\***.println(str.substring(2, 4)); // su

​    

​    

​    // 字符串常量池的测试

​    String s1 = "abc";

​    String s2 = "abc";

​    System.***out\***.println("s1 == s2 " + (s1 == s2)); // true：由于s1和s2都指向字符串常量池中的"abc"

​    System.***out\***.println("s1.equals(s2) " + (s1.equals(s2))); // true

​    

​    // 创建了两个对象，一个存放在字符串池中，一个存在与堆区中； 

​    String s3 = **new** String("abc");

​    String s4 = **new** String("abc");

​    // s3和s4栈区的地址不同，指向堆区的不同地址

​    System.***out\***.println("s3 == s4 " + (s3 == s4)); // false

​    System.***out\***.println("s3.equals(s4) " + (s3.equals(s4))); // true：指向的堆区的内容相同

​    

​    String s5 = "abcd";

​    // 由于常量的值在编译的时候就被确定(优化)了。 在这里，"ab"和"cd"都是常量，因此变量str3的值在编译时就可以确定。 

​    String s6 = "ab" + "cd"; // 这行代码编译后的效果等同于： String str3 = "abcd";

​    System.***out\***.println("s5 == s6 " + (s5 == s6)); // true

​    System.***out\***.println("s5.equals(s6) " + (s5.equals(s6))); // true

​    

​    String s7 = "abcd";

​    String s9 = "cd";

​    String s8 = "ab" + s9; // 由于s9是变量，所以在编译的时候，无法确定s8的值

​    System.***out\***.println("s7 == s8 " + (s7 == s8)); // false

​    System.***out\***.println("s7.equals(s8) " + (s7.equals(s8))); // true

  }

  

  /**

   \* 

   \* **@Description**:String中的final用法和理解

   \* 

   \* final只对引用的"值"(即内存地址)有效，它迫使引用只能指向初始指向的那个对象，改变它的指向会导致编译期错误。

   \* 至于它所指向的对象的变化，final是不负责的。 

   *

   */

  @Test

  **public** **void** testFinal() {

​    **final** StringBuffer a = **new** StringBuffer("111");

​    **final** StringBuffer b = **new** StringBuffer("222");

​    

​    // 此句编译不通过

​    // a = b;

​    

​    a.append("222");// 编译通过 

  }

}

 

# 总结

## String对象的不变性

**1****、****String****类是****final****类，也即意味着****String****类不能被继承，并且它的成员方法都默认为****final****方法。**在Java中，被final修饰的类是不允许被继承的，并且该类中的成员方法都默认为final方法。

**2****、****String****类其实是通过****char****数组来保存字符串的。**

String使用private final char value[]来实现字符串的存储，也就是说String对象创建之后，就不能再修改此对象中存储的字符串内容，就是因为如此，才说String类型是不可变的(immutable)。

**3****、对于改变字符串的操作，**无论是sub操、concat还是replace操作都不是在原有的字符串上进行的，**而是重新生成了一个新的字符串对象。也就是说进行这些操作后，最原始的字符串并没有被改变。**

在这里要永远记住一点：**“****String****对象一旦被创建就是固定不变的了，对****String****对象的任何改变都不影响到原对象，相关的任何****change****操作都会生成新的对象”。**

 

## 字符串常量池

我们知道字符串的分配和其他对象分配一样，是需要消耗高昂的时间和空间的，而且字符串我们使用的非常多。JVM为了提高性能和减少内存的开销，在实例化字符串的时候进行了一些优化：使用字符串常量池。**每当我们创建字符串常量时，****JVM****会首先检查字符串常量池，如果该字符串已经存在常量池中，那么就直接返回常量池中的实例引用。如果字符串不存在常量池中，就会实例化该字符串并且将其放到常量池中。**由于String字符串的不可变性我们可以十分肯定常量池中一定不存在两个相同的字符串。

Java中的常量池，实际上分为两种形态：静态常量池和运行时常量池。

所谓**静态常量池，即*****.class****文件中的常量池，**class文件中的常量池不仅仅包含字符串(数字)字面量，还包含类、方法的信息，占用class文件绝大部分空间。

而**运行时常量池，则是****jvm****虚拟机在完成类装载操作后，将****class****文件中的常量池载入到内存中，并保存在方法区中**，我们常说的常量池，就是指方法区中的运行时常量池。

 

## 其他

1、引用变量与对象：A aa;

这个语句声明一个类A的引用变量aa[我们常常称之为句柄]，而对象一般通过new创建。所以aa仅仅是一个引用变量，它不是对象。

2、创建字符串的方式

创建字符串的方式归纳起来有两类：

(1)、使用""引号创建字符串; (2)、使用new关键字创建字符串。结合上面例子，总结如下：

A、单独使用""引号创建的字符串都是常量，编译期就已经确定存储到String Pool中；

B、使用new String("")创建的对象会存储到heap中，是运行期新创建的；

new创建字符串时首先查看池中是否有相同值的字符串，如果有，则拷贝一份到堆中，然后返回堆中的地址；如果池中没有，则在堆中创建一份，然后返回堆中的地址（注意，此时不需要从堆中复制到池中，否则，将使得堆中的字符串永远是池中的子集，导致浪费池的空间）！

C、使用只包含常量的字符串连接符如"aa" + "aa"创建的也是常量，编译期就能确定，已经确定存储到String Pool中；

D、使用包含变量的字符串连接符如"aa" + s1创建的对象是运行期才创建的，存储在heap中；

3、使用String不一定创建对象，使用new String，一定创建对象。

在执行到双引号包含字符串的语句时，如String a = "123"，JVM会先到常量池里查找，如果有的话返回常量池里的这个实例的引用，否则的话创建一个新实例并置入常量池里。所以，当我们在使用诸如String str = "abc"；的格式定义对象时，总是想当然地认为，创建了String类的对象str。担心陷阱！对象可能并没有被创建！而可能只是指向一个先前已经创建的对象。只有通过new()方法才能保证每次都创建一个新的对象。

 

## 关于equals和==

**1****、对于****==****，如果作用于基本数据类型的变量** (byte, short, char, int, long, float, double, boolean)，**则直接比较其存储的****"****值****"****是否相等；如果作用于引用类型的变量**(String)，**则比较的是所指向的对象的地址**（即是否指向同一个对象）。

2、equals方法是基类Object中的方法，因此对于所有的继承于Object的类都会有该方法。在Object类中，equals方法是用来比较两个对象的引用是否相等，即是否指向同一个对象。

3、对于equals方法，注意：**equals****方法不能作用于基本数据类型的变量。**如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；而**String****类对****equals****方法进行了重写，用来比较指向的字符串对象所存储的字符串是否相等。**其他的一些类诸如Double，Date，Integer等，都对equals方法进行了重写用来比较指向的对象所存储的内容是否相等。

 

## 关于final

String中的final用法和理解

final StringBuffer a = new StringBuffer("111");

　　final StringBuffer b = new StringBuffer("222");

a = b; // 此句编译不通过

final StringBuffer a = new StringBuffer("111");

　　a.append("222"); // 编译通过

可见，final只对引用的"值"(即内存地址)有效，它迫使引用只能指向初始指向的那个对象，改变它的指向会导致编译期错误。至于它所指向的对象的变化，final是不负责的。

 

 