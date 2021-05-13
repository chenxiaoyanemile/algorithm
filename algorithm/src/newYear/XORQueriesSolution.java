package newYear;

/**
 * 1310. ����������ѯ
 * ��һ������������ arr ���ָ���һ����Ӧ�Ĳ�ѯ���� queries�� ���� queries[i] = [Li,Ri]��
 * ����ÿ����ѯ i, �������� Li �� Ri �� XOR ֵ��Ϊ���β�ѯ�Ľ����
 * ������һ������������ѯ queries ���н�������顣
 * @author dell
 *
 */

public class XORQueriesSolution {
	
	
	
	/**
	 * ǰ׺��
	 * @param arr  {1,3,4,8}
	 * @param queries  {{0,1}��{1,2}��{0,3}��{3,3}}
	 * @return  {8,0,4,4}
	 *  */
	public int[] xorQueries(int[] arr, int[][] queries) 
	{
		int n = arr.length, m = queries.length;
		int[] sum = new int[n+1];
		for(int i = 1; i <= n; i++) sum[i] = sum[i-1]^arr[i-1];
		int[] ans = new int[m];
		for(int i = 0; i < m; i++) {
			int l = queries[i][0] +1, r = queries[i][1]+1;
			ans[i] = sum[r] ^ sum[l-1];
			
		}
		return ans;
	}

}
