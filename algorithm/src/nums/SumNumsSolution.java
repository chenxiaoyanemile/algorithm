package nums;
/**
 * 求 1+2+...+n
 * 要求不能使用乘除法， for ,while, if, else, switch,case 等关键字及条件判断（for 循环用递归实现，等差数列求和公式）
 * 示例：
 * 输入：n=3
 * 输出：6
 * @author dell
 *
 */
public class SumNumsSolution {
	
	public static void mian(String[] args) {
		int n = 3;
		int result = sumNums(n);
		System.out.println("结果输出："+result);
		
	}
	
	/**
	 * 循环的方式
	 * @param n 总数
	 * @return
	 */
	public static int sumNums(int n) {
		int result = 1;
		for(int i = 1; i < n; i++) {
			result = result +i;
		}

		return result;
	}
	
	/**
	 * 递归的方式
	 */
	
	public static int sumNums1(int n) {
		int sum = n;
		boolean flag = n>0 && (sum += sumNums1(n-1)) > 0;
		return sum;
	}
	
	/**
	 * 等差数列求和公式
	 */
	public static int sumNums2(int n) {
		return (int)(Math.pow(n, 2)+n)>>1;
	}

}
