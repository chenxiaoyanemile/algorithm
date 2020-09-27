package tree;

import java.util.HashMap;

/**
 * 106. 从一棵树的中序遍历与后序遍历构造二叉树
 * 
 * @author dell
 *
 */
public class BuildTreeSolution {
	
	HashMap<Integer,Integer> meno = new HashMap<>();
	int[] post;
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		for(int i = 0; i < inorder.length; i++) meno.put(inorder[i],i); //将节点值及索引全部记录在哈希表中
		post = postorder;
		TreeNode root = buildTree(0,inorder.length -1, 0 , post.length -1);
		return root;
		
	}
	
	private TreeNode buildTree(int is, int ie, int ps, int pe) {
		if(ie < is || pe < ps) return null;
		int root = post[pe]; //根据后序遍历结果，取得根节点
		int ri = meno.get(root); // 获取对应的索引
		
		TreeNode node = new TreeNode(root); // 创建该节点
		node.left = buildTree(is,ri-1,ps,ps+ri-is-1);
		node.right = buildTree(ri+1,ie,ps+ri-is,pe-1);
		return node; // 返回新建 node 
		
	}



}
