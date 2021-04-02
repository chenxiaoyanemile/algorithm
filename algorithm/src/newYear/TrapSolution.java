package newYear;

/**
 * 17.21 ֱ��ͼ��ˮ��
 * ����һ��ֱ��ͼ���������˴�����ԴԴ���ϵص�ˮ�����ֱ��ͼ�ܴ����ˮ����ֱ��ͼ�Ŀ��Ϊ1.
 * 
 * ������������{0,1,0,2,1,0,1,3,2,1,2,1}
 * �����6
 * @author dell
 *
 */
public class TrapSolution {
	
	public int trap(int[] height){
		
		int n = height.length;
		
		int sum = 0, max = 0;
		for(int i =0; i < n; i++) {
			int cur = height[i];
			sum += cur;
			max = Math.max(max, cur);
		}
		
		int full = max * n;
		
		int lSum = 0, lMax = 0;
		for(int i = 0; i < n; i++) {
			lMax = Math.max(lMax, height[i]);
			lSum += lMax;
		}
		
		int rSum = 0, rMax = 0;
		for(int i = n-1; i >= 0; i--) {
			rMax = Math.max(rMax, height[i]);
			rSum += rMax;
			
		}
		
		return lSum + rSum -full - sum;
		
	}
	

}
