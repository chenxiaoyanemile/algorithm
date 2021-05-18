package newYear;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式（w,h） 出现。当另一个信封的宽度和高度都比这个信封大的时候，
 * 这个信封就可以放进另外一个信封里，如同俄罗斯套娃一样。
 * 
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里）
 * @author dell
 *
 */
public class MaxEnvelopsSolution {
	
	public static void main(String[] args) {
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		
		
	}
	
	/**
	 * 动态规划
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		if(n == 0) return n;
		// 因为我们在找第 i 件物品的前一件物品时，会对前面的 i-1 件物品都遍历一遍，因此第二维（高度）排序与否都不影响
		Arrays.parallelSort(envelopes,(a,b)->a[0]-b[0]);
		int[] f = new int[n];
		int ans = 1;
		for(int i = 0; i < n; i++) {
			f[i] = 1;
			for(int j = i -1; j >= 0; j--) {
				if(check(envelopes,j,i)) {
					f[i] = Math.max(f[i], f[j]+1);
				}
			}
			ans = Math.max(ans, f[i]);
		}
		
	  return ans;	
		
	}
	
	// 判断是否可以作为第 i 件物品的上一件物品
	public boolean check(int[][] es, int mid, int i) {
		return es[mid][0]<es[i][0] && es[mid][1]<es[i][1];
	}

}
