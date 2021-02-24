package postgraduate;

import java.util.Arrays;

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
	
	public static void main(String[] args) {
		int n = 4;
		int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
		//System.out.println(maxNumEdgesToRemove(n,edges));
	}
	
	public int maxNumEdgesToRemove(int n, int[][] edges) {
		UnionFindCustomer ufa = new UnionFindCustomer(n);
		UnionFindCustomer ufb = new UnionFindCustomer(n);
		
		int ans = 0;
		//�ڵ��Ÿ�Ϊ �� 0 ��ʼ
		for(int[] edge : edges) {
			--edge[1];
			--edge[2];
			
		}
		//������
		for(int[] edge :edges) {
			if(edge[0]==3) {
				if(!ufa.unite(edge[1], edge[2])) {
					++ans;
				}else {
					ufb.unite(edge[1], edge[2]);
				}
			}
		}
		// ��ռ��
		for(int[] edge : edges) {
			if(edge[0] == 1) {
				//Alice ��ռ��
				if(!ufa.unite(edge[1], edge[2])) {
					++ans;
				}
			}else if(edge[0] == 2) {
				//Bob ��ռ��
				if(!ufb.unite(edge[1], edge[2])) {
					++ans;
				}
			}
		}
		
		if(ufa.setCount != 1 || ufb.setCount != 1) {
			return -1;
		}
		
		return ans;
		
	}
	
	// ���鼯ģ��
	class UnionFindCustomer{
		int[] parent;
		int[] size;
		int n;
		// ��ǰ��ͨ������Ŀ
		int setCount;
		
		public UnionFindCustomer(int n) {
			this.n = n;
			this.setCount = n;
			this.parent = new int[n];
			this.size = new int[n];
			Arrays.fill(size, 1);
			for(int i =0; i < n; ++i) {
				parent[i] = i;
			}			
		}
		
		public int findset(int x) {
			return parent[x] == x ? x:(parent[x] = findset(parent[x]));
		}
		
		public boolean unite(int x, int y) {
			x = findset(x);
			y = findset(y);
			if(x == y) {
				return false;
			}
			if(size[x] < size[y]) {
				int temp = x;
				x = y;
				y = temp;
			}
			
			parent[y] = x;
			size[x] += size[y];
			--setCount;
			return true;
		}
		
		public boolean connected(int x, int y) {
			x = findset(x);
			y = findset(y);
			return x == y;
		}
		
	}

}
