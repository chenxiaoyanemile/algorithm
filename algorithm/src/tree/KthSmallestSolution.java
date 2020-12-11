package tree;

import java.util.ArrayList;

/**
 * 230. 二叉搜索树中第 K 小的元素
 * 给定一个二叉搜索树，编写一个函数来查找其中第 k 个最小的元素。
 * @author dell
 *
 */

public class KthSmallestSolution {
	
	public int kthSmallest(TreeNode root,int k) {
		ArrayList<Integer> nums = inorder(root,new ArrayList<>());
		return nums.get(k-1);
		
	}
	
	public ArrayList<Integer> inorder(TreeNode root,ArrayList<Integer> arr){
		if(root == null) return arr;
		inorder(root.left,arr);
		arr.add(root.val);
		inorder(root.right,arr);
		return arr;
		
	}

}
