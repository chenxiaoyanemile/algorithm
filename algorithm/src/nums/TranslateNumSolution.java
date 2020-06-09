package nums;
/**
 * 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译成字符串：
 * 0 -> a
 * 1 -> b
 * ...
 * 25 -> z
 * 一个数字可能有多个翻译
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * @author dell
 *
 */
public class TranslateNumSolution {
	
	public static void main(String[] args) {
		int input = 12258;
		int result = translateNum(input);
		System.out.println("输出："+result);
	}
	
	public static int translateNum(int num) {
		int a = 1, b = 1, x,y=num % 10;
		while(num != 0) {
			num /= 10;
			x = num % 10;
			int tmp = 10 *x +y;
			int c = (tmp >= 10 && tmp <= 25)? a+b :a;
			b = a;
			a = c;
			y = x;
		}
		return a;

	}

}
