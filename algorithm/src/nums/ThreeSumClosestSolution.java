package nums;

import java.util.Arrays;
/**
 * 16. ��ӽ�������֮��
 * ����һ������ n ������������ nums �� һ��Ŀ��ֵ target��
 * �ҳ� nums �е�����������ʹ�����ǵĺ��� target ��ӽ����������������ĺ͡�
 * �ٶ�ÿ������ֻ����Ψһ�𰸡�
 * @author Emily CH
 */
public class ThreeSumClosestSolution {
	
	public static void main(String[] args) {
		int[] arrays = {-1,2,1,-4,5,6,4};
		System.out.println("output:" +threeSumClosest(arrays,1) );
	}	
	/**
	 * ����֮����ӽ� target ����˼·��������Ȼ����������ӣ���һ���������ʱ���ұߣ�С��ʱ�����
	 * input: -1,2,1,-4,5,6,4 (target: 1)
	 * sort: -4,-1,1,2,4,5,6
	   * ˫ָ�룺��  ��         ��
	 *        k  i         j
	 *  sum = k + i + j
	   *  �� sum > target ,j ����
	 *  �� sum < target, i ����         
	 */
	public static int threeSumClosest(int[] nums, int target) {
		int result = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		for(int k = 0; k < nums.length - 2 ; k++) {
			int i = k + 1;
			int j = nums.length - 1;
			while(j > i) {
				int temp = nums[k] + nums[i] + nums[j];
				if(Math.abs(result - target) > Math.abs(temp - target)) 
					result = temp;
				if(temp > target)
					j--;
				else if(temp < target)
					i++;
				else
					return target;
			}
		}
		return result;	
	}

}
