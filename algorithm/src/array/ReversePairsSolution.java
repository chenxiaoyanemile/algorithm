package array;

/**
 *  �����ⷨ
 *  ʹ������ for ѭ��ö�����е����ԣ���һ�ж��Ƿ񹹳������ϵ
 * @author dell
 *
 */

public class ReversePairsSolution {
	
	public static void mian(String[] args) {
		
		int[] nums = {7,5,6,4};
		int n = reversePairs(nums);
		System.out.println("�����е���������ǣ�"+ n);
		
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
