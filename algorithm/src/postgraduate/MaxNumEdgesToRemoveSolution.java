package postgraduate;

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
	
	public int maxNumEdgesToRemove(int n, int[][] edges) {
		UnionFindCustomer ufa = new UnionFindCustomer(n);
		UnionFindCustomer ufb = new UnionFindCustomer(n);
		
		int ans = 0;
		//节点编号改为 从 0 开始
		for(int[] edge : edges) {
			--edge[1];
			--edge[2];
			
		}
	}

}
