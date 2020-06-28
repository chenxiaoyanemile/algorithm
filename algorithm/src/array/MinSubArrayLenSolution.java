package array;
/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ， 找出该数组中满足其和 > s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回0.
 */
public class MinSubArrayLenSolution {
	
	public static void main(String[] args) {
		int s = 7;
		int[] nums = {2,3,1,2,4,3};
		System.out.println("output:" + optMinSubArrayLen(s,nums));
		
		
	}	
	/**
	 * 思路1： 循环一遍数组，如果有某一个数刚好＞= s ，那么返回1；否则累加。
	 * 使用双循环，一个固定某一个位置 i ，另一个j 从 i+1 即 i 的下一个元素开始累加；
	 * 当和＞= s 终止循环，此时长度为 j-i+1.
	 * O(n^2) 超时解法
	 */
	public static int minSubArrayLen(int s, int[] nums) {
		int result = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum = nums[i];
			if(sum >= s) {
				return 1;
			}
			for(int j = i + 1; j < nums.length; j++) {
				sum += nums[j];
				if(sum >= s) {
					result = Math.min(result, j-i+1);
					break;
				}
			}
			
		}
		return result == Integer.MAX_VALUE?0:result;		
	}
	
	/**
	 * 双指针解法 - 参考 leetcode 官方解法
	 */
    public static int optMinSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0, result = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
            	result = Math.min(result, right - left);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


}
