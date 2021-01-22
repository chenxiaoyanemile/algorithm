package newYear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1489. 找到最小生成树里的关建边和伪关建边
 * 给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1,
 * 同时还有一个数组 edges, 其中 edges[i]=[from i, to i, weight i] 表示 from i和 to i 节点之间有一条带权无向边。
 * 最小生成树（MST） 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 * 
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。
 * 如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。
 * 伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
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

        // 计算 value
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
            // 判断是否是关键边
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

            // 判断是否是伪关键边
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
