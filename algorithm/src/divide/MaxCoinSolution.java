package divide;
/**
 * 312. 戳气球
 * 有 n 个气球，编号为 0 到 n-1, 每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球，如果你戳破气球 i ，就可以获得 nums[left]*nums[i]*nums[right] 个硬币。
 * left 和 right 代表和 i 相邻的两个气球的序号。
 * 求所能获得硬币的最大数量
 * @author dell
 *
 */
public class MaxCoinSolution {
	
	public static void main(String[] args) {
		int[] nums = {3,1,5,8};
		System.out.println("结果输出：" + maxCoinDP(nums));
		
		
	}
	
	/**
	 * 回溯法
	 * nums = {3,1,5,8} --> {3,5,8}-->{3,8}-->{8}-->{}
	 * coins = 3*1*5  +  3*5*8 + 1*3*8 +1*8*1  = 167
	 * @param nums {3,1,5,8}
	 * @return 167
	 */
	public static void  maxCoins(int[] nums,int y,int length,int beforeCoins) {
		int maxCoin = 0;
		//回归条件
		if(y == length) {
			if(beforeCoins > maxCoin) {
				maxCoin = beforeCoins;
			}
			return;
		}
		
		for(int i = 0; i < length; i++) {
			//略过已经戳破的气球
			if(nums[i] == -1) {
				continue;
			}
			// 标记已经戳破的气球
			int temp = nums[i];
			nums[i] = -1;
			// 获取上一个气球的数字
			int before = i-1;
			int beforeNum = 0;
			while(before > -1  && nums[before] == -1) {
				before --;
			}
			if(before < 0) {
				beforeNum = 1;
			}else {
				beforeNum = nums[before];
			}
			// 获取下一个气球的数字
			int next = i+1;
			int nextNum = 0;
			while(next < length && nums[next] == -1) {
				next++;
			}
			if(next > length -1) {
				nextNum = 1;
			}else {
				nextNum = nums[next];
			}
			//计算戳破当前气球的 coin 
			int tempCoin = temp*nextNum * beforeNum;
			//递归进行下一戳
			maxCoins(nums,y+1,length,beforeCoins + tempCoin);
			//回溯尝试其他戳法
			nums[i] = temp;
		}
		
	}
	
	/**
	 * 动态规划
	 * @param nums
	 * @return
	 */
	public static int maxCoinDP(int[] nums){
		// 避免空指针异常
		if(nums == null) {
			return 0;
		}
		// 创建虚拟边界
		int length = nums.length;
		int[] nums2 = new int[length+2];
		System.arraycopy(nums, 0, nums2, 1, length);
		nums2[0] = 1;
		nums2[length+1] = 1;
		length = nums2.length;
		
		//创建 dp 表
		length = nums2.length;
		int[][] dp = new int[length][length];
		
		// 开始 dp : i 为 begin, j 为 end ， k 为 i、j 区间划分子问题的边界
		
		for(int i = length-2; i > -1; i--) {
			for(int j = i+2; j < length; j++) {
				//维护一个最大值；如果 i、j 相邻，值为0
				int max = 0;
				for(int k = i+1;k < j; k++) {
					int temp = dp[i][k] + dp[k][j]+nums2[i]*nums2[k]*nums2[j];
					if(temp > max) {
						max = temp;
					}
				}
				dp[i][j] = max;
			}
		}
		return dp[0][length-1];	
	}
	
	
	

}
