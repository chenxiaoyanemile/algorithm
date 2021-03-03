package newYear;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num. 对于 0<=i<=num 范围中的每个数字 i , 计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 输入：2
 * 输出：{0,1,1}
 * @author dell
 *
 */

public class CountBitsSolution {
	
	public static void main(String[] args) {
		int num = 5;
		int[] result = countBits(num);
	}
	
	public static int[] countBits(int num) 
	{
		int[] result = new int[num+1];
		for(int i =1; i <= num; i++) {
			result[i] = result[i >> 1] + (i & 1);
		}
		return result;
	}

}
