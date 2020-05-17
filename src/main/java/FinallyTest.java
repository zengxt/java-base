
/**
 * 
 * @Description: finally块有关的问题
 *
 * @author： zxt
 *
 * @time: 2018年9月10日 下午4:07:11
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
			// 只是改变了a的值，但是返回的还是1
			System.out.println("改变a的值！！");
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
			// 返回2
			return a;
		}
	}
	
}
