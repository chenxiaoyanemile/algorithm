package divide;

/**
 * 剑指 Offer 39. 数组中出现超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author dell
 *
 */
public class MajorityElementSolution {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,1,2,3,6,2,2,8,2,2,2,2};
		System.out.println(majorityElement(nums));
	}
	
	public static int majorityElement(int[] nums) {
		int x =0, votes = 0;
		for(int num : nums) {
			if(votes == 0) x = num;
			votes += num == x ? 1:-1;
			
		}
		return x;
	}

}
