package array;

import java.util.Arrays;

import sort.QuickSort;

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
		System.out.println("output:" + optFindKthLargest(nums,k));
		
	}
	
	/**
	 * 思路：升序排序，返回第 k 大元素
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthlargest(int[] nums, int k) {
		Arrays.sort(nums);
		int result = nums.length - k;
		return nums[result];
	} 
	
	/**
	 * 优化：排序分治
	 * O(nlgn)
	 */
   	public static int optFindKthLargest(int[] nums, int k) {
		int temp;
		QuickSort.sort(nums, 0, k-1);		
		for(int i=k;i<nums.length;i++){
			temp = nums[i];
			for(int j=k-1;j>=0;j--){
				if(nums[j]>=temp){
					break;
				}else{
					nums[j+1] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		return nums[k-1];
   	}

}
