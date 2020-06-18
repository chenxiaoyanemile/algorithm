package array;
/**
 * 最佳观光组合  2020-6-17
 * 给定正整数数组 A， A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j-i.
 * 一对景点（i < j） 组成的观光组合的得分为 (A[j] + A[j] + i - j):
 * 景点的评分之和减去它们两者之间的距离
 * 返回一对观光景点能取得的最高分
 * @author Emily CH
 *
 */
public class MaxScoreSightseeingPairSolution {
	
	public static void main(String[] args) {
		int[] testArray = {8,1,5,2,6};
		System.out.println("输出："+optMaxScoreSightseeingPair(testArray));
		
	}
	
	//一般思路, O(n^2)
	public static int maxScoreSightseeingPair(int[] A) {
		int result = 0;
		for(int i = 0; i < A.length; i++) {
			for(int j = i+1; j < A.length; j++) {
				result = Math.max(result, A[i]+A[j]+i-j);
			}
		}
		return result;
	}
	
	// 优化后的思路 - 动态规划 DP 动态规划方程： dp[n] = MAX(dp[n-1],dp[n-2]+num), O(n)
	public static int optMaxScoreSightseeingPair(int[] A) {
		int result = 0;
		for(int i = 1; i < A.length; i++) {
			result = Math.max(A[i-1] + A[i] - i, result);
			A[i] = Math.max(A[i-1], A[i]+i);
		}
		return result;
	}

}
