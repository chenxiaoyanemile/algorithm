package tree;
/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否高度平衡的二叉树。
 * 一棵高度平衡二叉树定义为：一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1
 * 
 * @author dell
 *
 */

public class IsBalancedTreeSolution {
	
	/**
	 * 思路：对二叉树做先序遍历，从底部至顶部返回子树最大高度，若判定某子树不是平衡树则“剪枝”，
	 * 直接向上返回。
	 * @param root
	 * @return 返回值： 若 recur(root) != 1 ，则说明此树平衡，返回 truetrue ； 否则返回 falsefalse 。
	 */
	public boolean isBalanced(TreeNode root) {		
		return recur(root) != -1;
		
	}
	
	/**
	 *   先序遍历，当节点左/右子树的高度差 < 2：返回节点 root 为根节点的子树的最大高度，左右子树中最大高度 +1；
	 *   当节点左 / 右子树的高度差>= 2 ：返回-1，不是平衡树。
	 * @param root 
	 * @return  返回值
	  * 当节点root 左 / 右子树的高度差 < 2<2 ：则返回以节点root为根节点的子树的最大高度，即节点 root 的左右子树中最大高度加 11 （ max(left, right) + 1 ）；
	  * 当节点root 左 / 右子树的高度差 \geq 2≥2 ：则返回 -1−1 ，代表 此子树不是平衡树 。
	 */
	public int recur(TreeNode root) {
		if(root == null) return 0;
		int left = recur(root.left);
		if(left == -1) return -1;
		int right = recur(root.right);
		if(right == -1) return -1;
		return Math.abs(left - right)<2? Math.max(left, right)+1:-1;
		
	}

}
