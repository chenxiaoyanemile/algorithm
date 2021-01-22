package newYear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1489. �ҵ���С��������Ĺؽ��ߺ�α�ؽ���
 * ����һ�� n ����Ĵ�Ȩ������ͨͼ���ڵ���Ϊ 0 �� n-1,
 * ͬʱ����һ������ edges, ���� edges[i]=[from i, to i, weight i] ��ʾ from i�� to i �ڵ�֮����һ����Ȩ����ߡ�
 * ��С��������MST�� �Ǹ���ͼ�бߵ�һ���Ӽ��������������нڵ���û�л���������Щ�ߵ�Ȩֵ����С��
 * 
 * �����ҵ�����ͼ����С�����������йؼ��ߺ�α�ؼ��ߡ�
 * �����ͼ��ɾȥĳ���ߣ��ᵼ����С��������Ȩֵ�����ӣ���ô���Ǿ�˵����һ���ؼ��ߡ�
 * α�ؼ������ǿ��ܻ������ĳЩ��С�������е����������������С�������еıߡ�
 * @author dell
 *
 */

public class FindCriticalAndPseudoCriticalEdgesSolution {
	
	public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges){
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < 3; ++j) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, new Comparator<int[]>() {
            public int compare(int[] u, int[] v) {
                return u[2] - v[2];
            }
        });

        // ���� value
        UnionFindCustomer ufStd = new UnionFindCustomer(n);
        int value = 0;
        for (int i = 0; i < m; ++i) {
            if (ufStd.unite(newEdges[i][0], newEdges[i][1])) {
                value += newEdges[i][2];
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; ++i) {
            ans.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < m; ++i) {
            // �ж��Ƿ��ǹؼ���
        	UnionFindCustomer uf = new UnionFindCustomer(n);
            int v = 0;
            for (int j = 0; j < m; ++j) {
                if (i != j && uf.unite(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (uf.setCount != 1 || (uf.setCount == 1 && v > value)) {
                ans.get(0).add(newEdges[i][3]);
                continue;
            }

            // �ж��Ƿ���α�ؼ���
            uf = new UnionFindCustomer(n);
            uf.unite(newEdges[i][0], newEdges[i][1]);
            v = newEdges[i][2];
            for (int j = 0; j < m; ++j) {
                if (i != j && uf.unite(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (v == value) {
                ans.get(1).add(newEdges[i][3]);
            }
        }
      
        return ans;

		
	}

}
