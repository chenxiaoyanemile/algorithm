package array;

import java.util.HashMap;
import java.util.Map;

/**
 * �Ϳɱ� k ������������
 * ����һ���������� A����������Ԫ��֮�Ϳɱ� K ���������������Ŀ
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
