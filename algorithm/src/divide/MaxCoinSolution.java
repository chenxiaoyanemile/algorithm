package divide;
/**
 * 312. ������
 * �� n �����򣬱��Ϊ 0 �� n-1, ÿ�������϶�����һ�����֣���Щ���ִ������� nums �С�
 * ����Ҫ����������е����������������� i ���Ϳ��Ի�� nums[left]*nums[i]*nums[right] ��Ӳ�ҡ�
 * left �� right ����� i ���ڵ������������š�
 * �����ܻ��Ӳ�ҵ��������
 * @author dell
 *
 */
public class MaxCoinSolution {
	
	public static void main(String[] args) {
		int[] nums = {3,1,5,8};
		System.out.println("��������" + maxCoinDP(nums));
		
		
	}
	
	/**
	 * ���ݷ�
	 * nums = {3,1,5,8} --> {3,5,8}-->{3,8}-->{8}-->{}
	 * coins = 3*1*5  +  3*5*8 + 1*3*8 +1*8*1  = 167
	 * @param nums {3,1,5,8}
	 * @return 167
	 */
	public static void  maxCoins(int[] nums,int y,int length,int beforeCoins) {
		int maxCoin = 0;
		//�ع�����
		if(y == length) {
			if(beforeCoins > maxCoin) {
				maxCoin = beforeCoins;
			}
			return;
		}
		
		for(int i = 0; i < length; i++) {
			//�Թ��Ѿ����Ƶ�����
			if(nums[i] == -1) {
				continue;
			}
			// ����Ѿ����Ƶ�����
			int temp = nums[i];
			nums[i] = -1;
			// ��ȡ��һ�����������
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
			// ��ȡ��һ�����������
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
			//������Ƶ�ǰ����� coin 
			int tempCoin = temp*nextNum * beforeNum;
			//�ݹ������һ��
			maxCoins(nums,y+1,length,beforeCoins + tempCoin);
			//���ݳ�����������
			nums[i] = temp;
		}
		
	}
	
	/**
	 * ��̬�滮
	 * @param nums
	 * @return
	 */
	public static int maxCoinDP(int[] nums){
		// �����ָ���쳣
		if(nums == null) {
			return 0;
		}
		// ��������߽�
		int length = nums.length;
		int[] nums2 = new int[length+2];
		System.arraycopy(nums, 0, nums2, 1, length);
		nums2[0] = 1;
		nums2[length+1] = 1;
		length = nums2.length;
		
		//���� dp ��
		length = nums2.length;
		int[][] dp = new int[length][length];
		
		// ��ʼ dp : i Ϊ begin, j Ϊ end �� k Ϊ i��j ���仮��������ı߽�
		
		for(int i = length-2; i > -1; i--) {
			for(int j = i+2; j < length; j++) {
				//ά��һ�����ֵ����� i��j ���ڣ�ֵΪ0
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
