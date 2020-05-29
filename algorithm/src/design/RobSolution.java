package design;

/**
 * ��ҽ���
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ��
 * ����������ڵķ�����ͬһ�����ϱ�С͵���룬ϵͳ���Զ�������
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬�ƻ��㲻��������װ�õ�����£�һҹ֮���ܹ�͵�Ե���߽�
 * @author dell
 *
 */

public class RobSolution {
	
	public static void mian(String[] args) {
		int[] array = {1,2,3,4}; // 6 
		int[] arr = {2,7,9,3,1}; // 12
		int[] by = {6,9};
		int res = rob(array);
		System.out.println("��������" + res);
		
		
	}
	
	/**
	 * ��̬�滮
	 * ��̬�滮���̣� dp[n] = MAX(dp[n-1],dp[n-2]+num)
	 * ���ڲ�����������ķ��ݴ��룬���Ե�ǰλ�� n ���ݿɵ��Ե����ֵ��
	 * Ҫô���� n-1 ���ݿɵ��Ե����ֵ��Ҫô���� n-2 ���ݿɵ��Ե����ֵ���ϵ�ǰ���ݵ�ֵ
	 * ����֮��ȡ���ֵ
	 * �ٸ����ӣ�
	 * int[] array = {3,4,2} ��Ӧ1,2,3�ŷ���
	 * dp[3] = Max(dp[2],dp[1]+num) = Max(4,5) = 5;
	 * ��ô3�ŷ���������ֵΪ5
	 * ʱ�临�Ӷȣ� O(n)
	 * @param array
	 */
	public static int rob(int[] nums) {
		int len = nums.length;
		if(len == 0) {
			return 0;
		}
		int[] dp = new int[len+1];
		dp[0] = 0;
		dp[1] = nums[0];
		for(int i = 2 ; i <= len; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
			
		}
		return dp[len];
		
	}
	
	public int rob1(int[] nums) {
		int[] dp = new int[nums.length +2];
		for(int i =0; i < nums.length; i++) {
			dp[i+2] = Math.max(dp[i]+nums[i], dp[i+1]);
		}
		return dp[nums.length + 1];
	}

}
























