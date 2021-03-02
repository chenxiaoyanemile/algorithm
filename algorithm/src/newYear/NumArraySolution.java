package newYear;

/**
 * 303.区域和检索 - 数组不可变
 * 给定一个整数数组 nums, 求出数组从索引 i 到 j （i <= j） 范围内元素的总和，包含 i、 j 两点
 * 
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j(i <= j) 范围内元素的总和，包含 i、j 两点
 * (也就是 sum(nums[i],nums[i+1],...,nums[j]))
 * @author dell
 *
 */

public class NumArraySolution {
	
	public static void main(String[] args) {
		String[] strArray = {"NumArray", "sumRange", "sumRange", "sumRange"};
		int[][] nums = {{-2,0,3,-5,2,-1},{0,2},{2,5},{0,5}};
		
	}
	
	class NumArray{
		
		private int[] preSum;
		
		public NumArray(int[] nums) {
			preSum = new int[nums.length+1];
			for(int i = 0; i < nums.length; i++) {
				preSum[i+1] = preSum[i] + nums[i];
			}
		}
		
		public int sumRange(int i, int j) {
			return preSum[j + 1] - preSum[i];
		}
	}

}
