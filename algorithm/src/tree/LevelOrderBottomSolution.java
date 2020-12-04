package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107.二叉树的层次遍历
 * 给定一个二叉树，返回其节点值自底向上的层次遍历
 * 即按从叶子结点所在的层到根节点所在的层，逐层从左向右遍历
 * @author dell
 *
 */

public class LevelOrderBottomSolution {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		LinkedList<List<Integer>> result = new LinkedList<>();
		if(root == null) 
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> oneLevel = new ArrayList<>();
			//每次都取出一层的所有数据
			int count = queue.size();
			for(int i = 0; i < count; i++) {
				TreeNode node = queue.poll();
				oneLevel.add(node.val);
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
				
			}
			// 每次都往对头塞
			result.addFirst(oneLevel);
			
		}
		
		return result;	
	}

}
