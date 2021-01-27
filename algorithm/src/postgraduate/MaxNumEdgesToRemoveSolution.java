package postgraduate;

import newYear.UnionFindCustomer;

/**
 * 1579. ��֤ͼ����ȫ����
 * Alice �� Bob ����һ������ͼ�����а��� n ���ڵ�� 3 �����͵ıߣ�
 * ����1��ֻ���� Alice ����
 * ����2��ֻ���� Bob ����
 * ����3��Alice �� Bob �����Ա���
 * ����һ������ edges, ���� edges[i] = [typei,ui,vi] ��ʾ�ڵ� ui �� vi ֮���������Ϊ typei��˫��ߡ�
 * �����ڱ�֤ͼ���ܱ� Alice �� Bob ��ȫ������ǰ���£��ҳ�����ɾ������������
 * ������κνڵ㿪ʼ��Alice �� Bob �����Ե������������ڵ㣬����Ϊͼ�ǿ�����ȫ�����ġ�
 * ���ؿ���ɾ��������������� Alice  �� Bob �޷���ȫ����ͼ���򷵻� -1.
 * @author dell
 *
 */
public class MaxNumEdgesToRemoveSolution {
	
	public int maxNumEdgesToRemove(int n, int[][] edges) {
		UnionFindCustomer ufa = new UnionFindCustomer(n);
		UnionFindCustomer ufb = new UnionFindCustomer(n);
		
		int ans = 0;
		for(int[] edge : edges) {
			--edge[1];
			--edge[2];
			
		}
	}

}
