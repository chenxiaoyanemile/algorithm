package nums;
/**
 * 判断一个整数是否是回文数
 * 回文数：正序读和倒序读一样的整数
 * @author dell
 *
 */
public class IsPalidromeSolution {
	public static void mian(String[] args) {
		int x = 132231;
		System.out.println("输出："+ isPalidrome(x));
		
	}
	
	public static boolean isPalidrome(int x) {
		String reversedStr = (new StringBuilder(x + "")).reverse().toString();
		return (x+"").equals(reversedStr);
	}
}
