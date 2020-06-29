package array;

import java.util.Arrays;

/**
 * 215. 数组中的 第 k 个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。
 * @author dell
 *
 */

public class FindKthLargestSolution {
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.println("output:" + findKthlargest(nums,k));
		
	}
	
	public static int findKthlargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums.length - k;
	} 
	
	

}
