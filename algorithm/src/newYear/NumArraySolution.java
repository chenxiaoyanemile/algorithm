package newYear;

/**
 * 303.����ͼ��� - ���鲻�ɱ�
 * ����һ���������� nums, ������������ i �� j ��i <= j�� ��Χ��Ԫ�ص��ܺͣ����� i�� j ����
 * 
 * ʵ�� NumArray �ࣺ
 * NumArray(int[] nums) ʹ������ nums ��ʼ������
 * int sumRange(int i, int j) �������� nums ������ i �� j(i <= j) ��Χ��Ԫ�ص��ܺͣ����� i��j ����
 * (Ҳ���� sum(nums[i],nums[i+1],...,nums[j]))
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
