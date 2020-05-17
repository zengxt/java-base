package com.zxt.finalize;

/**
 * 
 * @Description: finalize()�����п��ܸ���һЩ��ʱ���ɴ����Ķ���
 *
 * @author�� zxt
 *
 * @time: 2018��3��23�� ����4:06:28
 *
 */
public class FinalizeTest {

	private static FinalizeTest finalizeTest;
	
	public static void main(String[] args) throws InterruptedException {
		finalizeTest = new FinalizeTest();
		// �ɸ���
		finalizeTest = null;
		
		// ��������(���ñ����finalize()���¸ö��󸴻�)
		System.gc();
		Thread.sleep(1000);
		if(finalizeTest == null) {
			System.out.println("finalizeTest Ϊ null��");
		} else {
			System.out.println("finalizeTest ���ã�");
		}
		
		
		// ���ɸ���
		finalizeTest = null;
		System.out.println("�ڶ���gc");
		System.gc();
		Thread.sleep(1000);
		if(finalizeTest == null) {
			System.out.println("finalizeTest Ϊ null��");
		} else {
			System.out.println("finalizeTest ���ã�");
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
