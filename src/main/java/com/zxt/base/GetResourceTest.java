package com.zxt.base;

/**
 * Java中取资源时，经常用到Class.getResource和ClassLoader.getResource
 * 
 * 注意获取资源时，获取的是编译之后的class文件资源，而不会获取java源代码
 * 
 * @author zxt
 *
 */

public class GetResourceTest {

	public static void main(String[] args) {
		// Class.getResource(String path)
		// path不以'/'开头时，默认是从此类所在的包下取资源；
		// path 以'/'开头时，则是从ClassPath根下获取；(相当于bin目录(Eclipse环境下))
		// 当前类(class)所在的包目录 (指定资源名，可以获取该包下面的其他资源)
		System.out.println(GetResourceTest.class.getResource(""));
		// class path根目录 (指定资源名，可以获取根目录下面的资源)
		System.out.println(GetResourceTest.class.getResource("/"));
		
		// Class.getResource和Class.getResourceAsStream在使用时，路径选择上是一样的。
		// getResourceAsStream()方法，它相当于你用getResource()取得File文件后，再new InputStream(file)一样的结果 
		
		
		// Class.getClassLoader().getResource(String path)
		// path是从ClassPath根下获取
		System.out.println(GetResourceTest.class.getClassLoader().getResource(""));
		System.out.println(GetResourceTest.class.getClassLoader().getResource("").getPath());
		// GetResourceTest.class.getResource("/") == GetResourceTest.class.getClassLoader().getResource("")
		// path不能以'/'开头
		System.out.println(GetResourceTest.class.getClassLoader().getResource("/"));
	}

}
