package array;

import java.util.Arrays;

/**
 * 215. �����е� �� k �����Ԫ��
 * ��δ������������ҵ��� k ������Ԫ�ء�
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
