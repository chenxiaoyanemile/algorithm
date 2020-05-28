package nums;
/**
 * 287. 寻找重复数
 * 给定一个包含 n+1 个整数的数组 nums , 其数字都在 1 到 n 之间（包括 1 和 n）
 * 可知至少存在一个重复的整数，假设只有一个重复的整数，找出这个重复的数。
 * @author dell
 *
 */
public class FindDuplicateSolution {
	
	/**
	 * 快慢指针思想， fast 和 slow 是指针， nums[slow] 表示取指针对应的元素
	 * 注意 nums 数组中的数字都是在 1- n 之间的（在数组中进行游走不会越界）
	 * 因为有重复数字的出现，所以这个游走必然是成环的，环的入口就是重复的元素
	 * 即按照寻找链表入口的思路来做
	 * @param nums
	 * @return
	 */
	
	public int findDuplicate(int[] nums) {
		int fast = 0, slow = 0;
		while(true) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			if(slow == fast) {
				fast = 0;
				while(nums[slow] != nums[fast]) {
					fast = nums[fast];
					slow = nums[fast];
				}
				return nums[slow];
			}
		}
		
	}
	
	/**
	 * 二分法
	 */
	public int binaryFindDuplicate(int[] nums) {
		int len = nums.length;
		int left = 1;
		int right = len-1;
		while(left < right) {
			int mid = (left + right)>>>1;
			int cnt = 0;
			for(int num : nums) {
				if(num <= mid) {
					cnt += 1;
				}
			}
			
			if(cnt > mid) {
				right = mid;
			}else {
				left = mid +1;
			}
		}
		return left;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
