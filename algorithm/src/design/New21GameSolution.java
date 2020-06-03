package design;
/**
 * ��21��
 * ��Ϸ����
 * ��0 �ֿ�ʼ���ڵ÷����� k ��ʱ��ȡ���֡���ȡʱ����[1,w] �ķ�Χ��������һ��������Ϊ���������ۼƣ����� w ��������
 * ÿ�γ�ȡ���Ƕ����ģ�����������ͬ�ĸ���
 * ����ò����� k ��ʱ����ֹͣ��ȡ���֡�
 * ����������� n �ĸ����Ƕ��٣�
 * ʾ����
 * ���룺 n =10, k = 1, w = 10
 * ����� 1.00000
 * ˵�����õ�һ�ſ���Ȼ��ֹͣ
 * @author dell
 *
 */
public class New21GameSolution {
	
	public static void main(String[] args) {
		int N = 6;
		int K = 1;
		int W = 10;
		double result = new21Game(N,K,W);
		System.out.println("��������"+result);
		
		
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
