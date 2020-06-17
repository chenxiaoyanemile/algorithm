package nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����֮��
 * ����һ������ n ������������ nums ���ж�nums ���Ƿ��������Ԫ�أ� a,b,c ��ʹ�� a+b+c =0 ?
 * �����ҳ��������������Ҳ��ظ�����Ԫ��
 * @author dell
 *
 */

public class TreeSumSolution {
	
	public static void main() {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> list =new ArrayList<>();
		list = threeSum(nums);
	}
	
	public static List<List<Integer>> threeSum(int[] nums){
		  List<List<Integer>> ans = new ArrayList();
	        int len = nums.length;
	        if(nums == null || len < 3) return ans;
	        Arrays.sort(nums); // ����
	        for (int i = 0; i < len ; i++) {
	            if(nums[i] > 0) break; // �����ǰ���ִ���0��������֮��һ������0�����Խ���ѭ��
	            if(i > 0 && nums[i] == nums[i-1]) continue; // ȥ��
	            int L = i+1;
	            int R = len-1;
	            while(L < R){
	                int sum = nums[i] + nums[L] + nums[R];
	                if(sum == 0){
	                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
	                    while (L<R && nums[L] == nums[L+1]) L++; // ȥ��
	                    while (L<R && nums[R] == nums[R-1]) R--; // ȥ��
	                    L++;
	                    R--;
	                }
	                else if (sum < 0) L++;
	                else if (sum > 0) R--;
	            }
	        }        
	        return ans;

	}

}