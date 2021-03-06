package postgraduate;

import java.util.Arrays;

import newYear.UnionFindCustomer;

/**
 * 1579. 保证图可完全遍历
 * Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3 种类型的边：
 * 类型1：只能由 Alice 遍历
 * 类型2：只能由 Bob 遍历
 * 类型3：Alice 和 Bob 都可以遍历
 * 给你一个数组 edges, 其中 edges[i] = [typei,ui,vi] 表示节点 ui 和 vi 之间存在类型为 typei的双向边。
 * 请你在保证图仍能被 Alice 和 Bob 完全遍历的前提下，找出可以删除的最大边数。
 * 如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
 * 返回可以删除的最大边数，如果 Alice  和 Bob 无法完全遍历图，则返回 -1.
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
		//节点编号改为 从 0 开始
		for(int[] edge : edges) {
			--edge[1];
			--edge[2];
			
		}
		//公共边
		for(int[] edge :edges) {
			if(edge[0]==3) {
				if(!ufa.unite(edge[1], edge[2])) {
					++ans;
				}else {
					ufb.unite(edge[1], edge[2]);
				}
			}
		}
		// 独占边
		for(int[] edge : edges) {
			if(edge[0] == 1) {
				//Alice 独占边
				if(!ufa.unite(edge[1], edge[2])) {
					++ans;
				}
			}else if(edge[0] == 2) {
				//Bob 独占边
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
	
	// 并查集模板
	class UnionFindCustomer{
		int[] parent;
		int[] size;
		int n;
		// 当前连通分量数目
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
