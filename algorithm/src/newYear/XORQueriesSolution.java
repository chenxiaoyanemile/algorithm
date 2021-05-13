package newYear;

/**
 * 1310. 子数组异或查询
 * 有一个正整数数组 arr ，现给你一个对应的查询数组 queries， 其中 queries[i] = [Li,Ri]。
 * 对于每个查询 i, 请你计算从 Li 到 Ri 的 XOR 值作为本次查询的结果。
 * 并返回一个包含给定查询 queries 所有结果的数组。
 * @author dell
 *
 */

public class XORQueriesSolution {
	
	
	
	/**
	 * 前缀和
	 * @param arr  {1,3,4,8}
	 * @param queries  {{0,1}，{1,2}，{0,3}，{3,3}}
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
