package postgraduate;

/**
 * 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列可以由两个下标 l 和 r(l < r)确定，如果对于每个 l <= i < r，
 * 都有
 * @author dell
 *
 */

public class FindLengthOfLCISSolution {
	
	/**
	 * 遍历
	 * count 为当前元素峰值，ans 为最大峰值
	 * 初始化 count = 1
	 * 从 0 位置开始遍历，遍历时根据前后元素状态判断是否递增，递增则 count++,
	 * 递减则 count = 1,如果 count > ans ，则更新 ans
	 * 直到循环结束
	 * 
	 * @param nums
	 * @return
	 */
	public int findLengthOfLCIS(int[] nums) {
		if(nums.length <= 1)
			return nums.length;
		int ans = 1;
		int count = 1;
		for(int i = 0; i < nums.length-1; i++) {
			if(nums[i+1] > nums[i]) {
				count++;
			}else {
				count = 1;
			}
			ans = count > ans ? count:ans;
		}
		return ans;
		
	}

}
