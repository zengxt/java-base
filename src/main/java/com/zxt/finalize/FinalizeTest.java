package com.zxt.finalize;

/**
 * 
 * @Description: finalize()方法中可能复活一些暂时不可触及的对象
 *
 * @author： zxt
 *
 * @time: 2018年3月23日 下午4:06:28
 *
 */
public class FinalizeTest {

	private static FinalizeTest finalizeTest;
	
	public static void main(String[] args) throws InterruptedException {
		finalizeTest = new FinalizeTest();
		// 可复活
		finalizeTest = null;
		
		// 垃圾回收(调用本类的finalize()导致该对象复活)
		System.gc();
		Thread.sleep(1000);
		if(finalizeTest == null) {
			System.out.println("finalizeTest 为 null！");
		} else {
			System.out.println("finalizeTest 可用！");
		}
		
		
		// 不可复活
		finalizeTest = null;
		System.out.println("第二次gc");
		System.gc();
		Thread.sleep(1000);
		if(finalizeTest == null) {
			System.out.println("finalizeTest 为 null！");
		} else {
			System.out.println("finalizeTest 可用！");
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("FinalizeTest finalize() called!");
		finalizeTest = this;
	}
	
	@Override
	public String toString() {
		return "I'm a Can Relive Object!";
	}
}
