package nums;

import java.util.Arrays;
/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * @author Emily CH
 */
public class ThreeSumClosestSolution {
	
	public static void main(String[] args) {
		int[] arrays = {-1,2,1,-4,5,6,4};
		System.out.println("output:" +threeSumClosest(arrays,1) );
	}	
	/**
	 * 三数之和最接近 target 解题思路：先排序，然后三个数相加，定一动二，大的时候动右边，小的时候动左边
	 * input: -1,2,1,-4,5,6,4 (target: 1)
	 * sort: -4,-1,1,2,4,5,6
	   * 双指针：↑  ↑         ↑
	 *        k  i         j
	 *  sum = k + i + j
	   *  若 sum > target ,j 左移
	 *  若 sum < target, i 右移         
	 */
	public static int threeSumClosest(int[] nums, int target) {
		int result = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		for(int k = 0; k < nums.length - 2 ; k++) {
			int i = k + 1;
			int j = nums.length - 1;
			while(j > i) {
				int temp = nums[k] + nums[i] + nums[j];
				if(Math.abs(result - target) > Math.abs(temp - target)) 
					result = temp;
				if(temp > target)
					j--;
				else if(temp < target)
					i++;
				else
					return target;
			}
		}
		return result;	
	}

}
