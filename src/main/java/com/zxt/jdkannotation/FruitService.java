package com.zxt.jdkannotation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description: @SuppressWarnings注解的使用
 *
 * @author： zxt
 *
 * @time: 2019年1月24日 下午8:48:52
 *
 */
public class FruitService {

	/**
	 * @Description：可以放在方法的前面，也可以放在有编译警告的语句前面；可以使用value={}的形式，也可以省略value 
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		List<String> strList = new ArrayList<String>();
	}

	@SuppressWarnings(value = { "unchecked", "rawtypes" })
	public static List<Fruit> getFruitList() {
		List<Fruit> fruitList = new ArrayList();
		return fruitList;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Fruit> getFruit() {
		List<Fruit> fruitList = new ArrayList();
		return fruitList;
	}
}
