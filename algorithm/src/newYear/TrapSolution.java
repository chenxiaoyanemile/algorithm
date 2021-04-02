package newYear;

/**
 * 17.21 直方图的水量
 * 给定一个直方图，假设有人从上面源源不断地倒水，最后直方图能存多少水量？直方图的宽度为1.
 * 
 * 上面是由数组{0,1,0,2,1,0,1,3,2,1,2,1}
 * 输出：6
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
