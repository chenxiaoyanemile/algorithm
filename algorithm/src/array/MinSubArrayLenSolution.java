package array;
/**
 * 209. ������С��������
 * ����һ������ n ���������������һ�������� s �� �ҳ���������������� > s �ĳ�����С�����������飬�������䳤�ȡ�
 * ��������ڷ������������������飬����0.
 */
public class MinSubArrayLenSolution {
	
	public static void main(String[] args) {
		int s = 7;
		int[] nums = {2,3,1,2,4,3};
		System.out.println("output:" + optMinSubArrayLen(s,nums));
		
		
	}	
	/**
	 * ˼·1�� ѭ��һ�����飬�����ĳһ�����պã�= s ����ô����1�������ۼӡ�
	 * ʹ��˫ѭ����һ���̶�ĳһ��λ�� i ����һ��j �� i+1 �� i ����һ��Ԫ�ؿ�ʼ�ۼӣ�
	 * ���ͣ�= s ��ֹѭ������ʱ����Ϊ j-i+1.
	 * O(n^2) ��ʱ�ⷨ
	 */
	public static int minSubArrayLen(int s, int[] nums) {
		int result = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum = nums[i];
			if(sum >= s) {
				return 1;
			}
			for(int j = i + 1; j < nums.length; j++) {
				sum += nums[j];
				if(sum >= s) {
					result = Math.min(result, j-i+1);
					break;
				}
			}
			
		}
		return result == Integer.MAX_VALUE?0:result;		
	}
	
	/**
	 * ˫ָ��ⷨ - �ο� leetcode �ٷ��ⷨ
	 */
    public static int optMinSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0, result = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
            	result = Math.min(result, right - left);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


}
