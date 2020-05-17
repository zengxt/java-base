package com.zxt.jdkannotation;

/**
 * 
 * @Description: @Deprecated注解的使用
 *
 * @author： zxt
 *
 * @time: 2019年1月24日 下午7:54:40
 *
 */
class AppleService {

	public void displayName() {
		System.out.println("水果的名称是：苹果！");
	}

	/**
	 * @Description：@Deprecated标记方法已经过时，不推荐使用
	 */
	@Deprecated
	public void showTaste() {
		System.out.println("水果的苹果的口感是：脆甜");
	}

	public void showTaste(int typeId) {
		if (typeId == 1) {
			System.out.println("水果的苹果的口感是：酸涩");
		} else if (typeId == 2) {
			System.out.println("水果的苹果的口感是：脆甜");
		} else {
			System.out.println("水果的苹果的口感是：超甜");
		}
	}
}

public class FruitRun {

	public static void main(String[] args) {
		Apple apple = new Apple();
		apple.displayName();

		AppleService appleService = new AppleService();
		appleService.showTaste();
		appleService.showTaste(1);
		appleService.showTaste(2);
	}
}
