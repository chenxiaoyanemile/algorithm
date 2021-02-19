package newYear;
/**
 * 1004. 最大连续 1 的个数
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1
 * 返回仅包含 1 的最长连续子数组的长度
 * 
 * 输入： A = {1,1,1,0,0,0,1,1,1,1,0}，k = 2
 * 输出： 6
 * 
 * 输入： A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1,1}，k = 3
 * 输出：10
 * @author dell
 *
 */
public class LongestOnesSolution {
		
	public static void main(String[] args) {
		int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1,1};
		int k = 3;	
		System.out.print(longestOnes(A,k));
		
	}
	
	/**
	 * 题意转换 -> 找出一个最长的子数组，该子数组内最多允许有 k 个 0
	 * 
	 * 思路：
	 * 使用 left 和 right 两个指针，分别指向滑动窗口的左右边界，
	 * right 主动右移，right 每次移动一步，判断 A[right] 是否为0，为0说明窗口中增加了一个0；
	 * left 被动右移，判断此时窗口内  0 的个数，如果超过了 K , 则 left 指针被迫右移，直至窗口内的 0 的个数小数等于 K 为止。
	 * 滑动窗口长度的最大值就是所求。
	 * @param A
	 * @param k
	 * @return
	 */
	public static int longestOnes(int[] A, int k) 
	{
		int result = 0;
		int right = 0 , left = 0;
		int zeros = 0;
		int n = A.length;
		while(right < n) {
			if(A[right] == 0) 
			{
				zeros++;
			}
			while(zeros > k) {
				if(A[left++] == 0) {
					zeros--;
				}
			}
			result = Math.max(result, right - left +1);
			right++;
		}
		return result;		
		
	}

}
