package newYear;

import java.util.Arrays;

/**
 * 354. ����˹�����ŷ�����
 * ����һЩ����˿�Ⱥ͸߶ȵ��ŷ⣬��Ⱥ͸߶�����������ʽ��w,h�� ���֡�����һ���ŷ�Ŀ�Ⱥ͸߶ȶ�������ŷ���ʱ��
 * ����ŷ�Ϳ��ԷŽ�����һ���ŷ����ͬ����˹����һ����
 * 
 * �����������ж��ٸ��ŷ������һ�顰����˹���ޡ��ŷ⣨�����԰�һ���ŷ�ŵ���һ���ŷ��
 * @author dell
 *
 */
public class MaxEnvelopsSolution {
	
	public static void main(String[] args) {
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		
		
	}
	
	/**
	 * ��̬�滮
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		if(n == 0) return n;
		// ��Ϊ�������ҵ� i ����Ʒ��ǰһ����Ʒʱ�����ǰ��� i-1 ����Ʒ������һ�飬��˵ڶ�ά���߶ȣ�������񶼲�Ӱ��
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
	
	// �ж��Ƿ������Ϊ�� i ����Ʒ����һ����Ʒ
	public boolean check(int[][] es, int mid, int i) {
		return es[mid][0]<es[i][0] && es[mid][1]<es[i][1];
	}

}
