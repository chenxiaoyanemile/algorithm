package tree;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树，把它转换成累加树，使得每个节点的值是原来节点值加上所有大于它的节点值之和
 * @author dell
 *
 */

public class ConvertBSTSolution {
	
	int sum = 0;
	
	// 反序中序遍历
	public TreeNode convertBST(TreeNode root) {
		if(root != null) {
			convertBST(root.right);
			sum += root.val;
			convertBST(root.left);
		}
		return root;
		
	}

}
