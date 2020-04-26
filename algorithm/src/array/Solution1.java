package array;

/**
 *  暴力解法
 *  使用两层 for 循环枚举所有的数对，逐一判断是否构成逆序关系
 * @author dell
 *
 */

public class Solution1 {
	
	public static void mian(String[] args) {
		
		int[] nums = {7,5,6,4};
		int n = reversePairs(nums);
		System.out.println("数组中的逆序对数是："+ n);
		
	}
	
	public static int reversePairs(int[] nums) {
		int count = 0;
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			for(int j = i+1; j < len; j++) {
				if(nums[i] > nums[j]) {
					count++;
				}
			}
			
		}
		return count;
	}


}
