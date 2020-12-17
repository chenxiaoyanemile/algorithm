package postgraduate;
/**
 * 922. 按奇偶排序数组
 * 给定一个非负整数数组 A ,A 中一半整数是奇数，一半整数是偶数
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数，当A[i] 是偶数时，i 也是偶数
 * 返回任何满足上述条件的数组作为答案
 * @author dell
 *
 */
public class SortArrayByParotySolution {
	
	public int[] sortArrayByParity(int[] A) 
	{
		int n = A.length;
		int[] ans = new int[n];
		int i = 0;
		for(int x : A) {
			if(x % 2 == 0) {
				ans[i] = x;
				i+=2;
			}	
		}
		i = 1;
		for(int x : A) {
			if(x % 2 == 1) {
				ans[i] = x;
				i+=2;				
			}
			
		}
		return ans;
	}

}
