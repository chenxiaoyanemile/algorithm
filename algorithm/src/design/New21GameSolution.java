package design;
/**
 * 新21点
 * 游戏规则：
 * 以0 分开始，在得分少于 k 分时抽取数字。抽取时，从[1,w] 的范围中随机获得一个整数作为分数进行累计，其中 w 是整数。
 * 每次抽取都是独立的，其结果具有相同的概率
 * 当获得不少于 k 分时，就停止抽取数字。
 * 求分数不超过 n 的概率是多少？
 * 示例：
 * 输入： n =10, k = 1, w = 10
 * 输出： 1.00000
 * 说明：得到一张卡，然后停止
 * @author dell
 *
 */
public class New21GameSolution {
	
	public static void main(String[] args) {
		int N = 6;
		int K = 1;
		int W = 10;
		double result = new21Game(N,K,W);
		System.out.println("输出结果："+result);
		
		
	}
	
	public static double new21Game(int N, int K, int W) {
		if(K == 0) {
			return 1.0;
		}
		double[] dp = new double[K+W+1];
		for(int i =K; i <= N && i < K+W; i++) {
			dp[i] = 1.0;
		}
		dp[K-1] = 1.0*Math.min(N-K+1, W)/W;
		for(int i = K-2; i>=0; i--) {
			dp[i] = dp[i+1] - (dp[i+W+1]-dp[i+1])/W;
		}
		return dp[0];
		
	}

}
