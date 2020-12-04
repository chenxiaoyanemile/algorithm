package tree;

import java.util.List;

public class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	public List<TreeNode> children;
	
	public TreeNode(int x) {
		val = x;
	}
	
	public TreeNode(int x, List<TreeNode> _children) {
		val = x;
		children = _children;
		
	}

}
