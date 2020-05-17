package com.zxt.jdkannotation;

/**
 * 
 * @Description: @Override注解的使用
 *
 * @author： zxt
 *
 * @time: 2019年1月24日 下午6:53:12
 *
 */
public class Fruit {

	public void displayName() {
		System.out.println("水果的名称是：***！");
	}
}

class Orange extends Fruit {
	@Override
	public void displayName() {
		System.out.println("水果的名称是：桔子！");
	}
}

/**
 * 
 * @Description: 当没有重载父类方法（或者写错方法名）时使用了@Override将报编译时错误
 *
 * @author： zxt
 *
 * @time: 2019年1月24日 下午7:03:05
 *
 */
class Apple extends Fruit {
	// @Override
	public void displayname() {
		System.out.println("水果的名称是：苹果！");
	}
	
	@Override
	public void displayName() {
		System.out.println("水果的名称是：苹果！");
	}
}
