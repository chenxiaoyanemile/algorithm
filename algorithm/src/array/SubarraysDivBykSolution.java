package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 和可被 k 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的子数组的数目
 * @author dell
 *
 */

public class SubarraysDivBykSolution {
	
	public static void mian(String[] args) {
		int[] array = {4,5,0,-2,-3,1};
		int k = 5;
		subarrayDivByK(array, k);
	}
	
	public static int subarrayDivByK(int[] A, int K) {
		Map<Integer, Integer> record = new HashMap<>();
		record.put(0,1);
		int sum =0, ans = 0;
		for(int elem : A) {
			sum += elem;
			int modulus = (sum % K + K)%K;
			int same = record.getOrDefault(modulus, 0);
			ans += same;
			record.put(modulus, same+1);
		}
		return ans;
	}

}
