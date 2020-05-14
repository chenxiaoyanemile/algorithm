package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树的层次遍历

public class BinaryTreeLevelOrder {
		public static void mian() {
			
		}
		
		public void levelIterator(TreeNode root) {
			if(root == null) {
				return;
			}
			
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			TreeNode current = null;
			queue.offer(root); // 将根节点入队
			while(!queue.isEmpty()) {
				current = queue.poll(); // 出队队头元素并访问
				if(current.left != null) {
					// 如果当前节点的左节点不为 null , 那么入队
					queue.offer(current.left);
				}
				if(current.right != null) {
					// 如果当前节点的右节点不为  null , 那么入队
					queue.offer(current.right);
				}
			}
			
		}
		
		
		public List<List<Integer>> levelOrder(TreeNode root){
			if(root == null) {
				return new ArrayList<>();
			}
			List<List<Integer>> res = new ArrayList<>();
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			
			queue.add(root); //根节点入队
			while(!queue.isEmpty()) {
				int count = queue.size();
				List<Integer> list = new ArrayList<Integer>();
				while(count > 0) {
					TreeNode binaryTree = queue.poll(); // 出队对头元素并访问
					list.add(binaryTree.val); // 保存出队元素的值
					if(binaryTree.left != null) {
						queue.add(binaryTree.left);
					}
					if(binaryTree.right != null) {
						queue.add(binaryTree.right);
					}
					count--; 
				}
				res.add(list);
				
			}
			
			return res;
		}
}
