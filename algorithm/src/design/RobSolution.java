package design;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一个晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计划你不触动警报装置的情况下，一夜之内能够偷窃的最高金额。
 * @author dell
 *
 */

public class RobSolution {
	
	public static void mian(String[] args) {
		int[] array = {1,2,3,4}; // 6 
		int[] arr = {2,7,9,3,1}; // 12
		int[] by = {6,9};
		int res = rob(array);
		System.out.println("输出结果：" + res);
		
		
	}
	
	/**
	 * 动态规划
	 * 动态规划方程： dp[n] = MAX(dp[n-1],dp[n-2]+num)
	 * 由于不可以在响铃的房屋闯入，所以当前位置 n 房屋可盗窃的最大值，
	 * 要么就是 n-1 房屋可盗窃的最大值，要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值
	 * 二者之间取最大值
	 * 举个栗子：
	 * int[] array = {3,4,2} 对应1,2,3号房间
	 * dp[3] = Max(dp[2],dp[1]+num) = Max(4,5) = 5;
	 * 那么3号房间盗窃最大值为5
	 * 时间复杂度： O(n)
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
























