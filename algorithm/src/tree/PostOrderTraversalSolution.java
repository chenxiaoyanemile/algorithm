package tree;

import java.util.ArrayList;
import java.util.List;
/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的后序遍历。
 * 后序：左右根
 * 
 * @author dell
 *
 */

public class PostOrderTraversalSolution {
	
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		postorder(root,res);
		return res;
		
	}
	
	public void postorder(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
			
		}
		postorder(root.left,res);
		postorder(root.right,res);
		res.add(root.val);
		
	}

}
