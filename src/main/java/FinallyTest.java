
/**
 * 
 * @Description: finally���йص�����
 *
 * @author�� zxt
 *
 * @time: 2018��9��10�� ����4:07:11
 *
 */
public class FinallyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("a = " + FinallyTest.returnTry());
		
		System.out.println("a = " + FinallyTest.returnFinally());
	}
	
	public static int returnTry() {
		@SuppressWarnings("unused")
		int a = 0;
		
		try {
			a = 1;
			return 1;
			
		} finally {
			// ֻ�Ǹı���a��ֵ�����Ƿ��صĻ���1
			System.out.println("�ı�a��ֵ����");
			a = 2;
		}
	}
	
	@SuppressWarnings("finally")
	public static int returnFinally() {
		int a = 0;
		
		try {
			a = 1;
			return 1;
			
		} finally {
			a = 2;
			// ����2
			return a;
		}
	}
	
}
