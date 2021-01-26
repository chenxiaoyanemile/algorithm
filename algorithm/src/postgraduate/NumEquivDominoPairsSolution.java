package postgraduate;
/**
 * 1128. �ȼ۶���ŵ���ƶԵ�����
 * ����һ����һЩ����ŵ������ɵ��б� dominoes
 * �������ĳһ�Ŷ���ŵ���ƿ���ͨ����ת 0 �Ȼ� 180 �ȵõ���һ�Ŷ���ŵ����
 * ���Ǿ���Ϊ���������ǵȼ۵ġ�
 * ��ʽ�ϣ� dominoes[a] = [a,b] �� dominoes[j] = [c,d] �ȼ۵�ǰ���� a == c, b == d��
 * ����  a==d,b==c;
 * �� 0 <= i < j <dominoes.length ��ǰ���£��ҳ����� dominoes[i] �� dominoes[j] �ȼ۵Ĺ��ƶ�(i,j)��������
 * @author dell
 *
 */

public class NumEquivDominoPairsSolution {
	
	/**
	 * input: domINOS = [[1,2],[2,1],[3,4],[5,6]]
	 * output: 1
	 * @param dominoes
	 * @return
	 */
	public int numEquivDominoPairs(int[][] dominoes) {
		int[] num = new int[100];
		int ret = 0;
		for(int[] domino:dominoes) {
			int val = domino[0]<domino[1]?domino[0]*10 + domino[1]:domino[1]*10+domino[0];
			ret += num[val];
			num[val]++;
		}
		return ret;
		
	}

}
