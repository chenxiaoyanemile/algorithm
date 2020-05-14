package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// �������Ĳ�α���

public class BinaryTreeLevelOrder {
		public static void mian() {
			
		}
		
		public void levelIterator(TreeNode root) {
			if(root == null) {
				return;
			}
			
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			TreeNode current = null;
			queue.offer(root); // �����ڵ����
			while(!queue.isEmpty()) {
				current = queue.poll(); // ���Ӷ�ͷԪ�ز�����
				if(current.left != null) {
					// �����ǰ�ڵ����ڵ㲻Ϊ null , ��ô���
					queue.offer(current.left);
				}
				if(current.right != null) {
					// �����ǰ�ڵ���ҽڵ㲻Ϊ  null , ��ô���
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
			
			queue.add(root); //���ڵ����
			while(!queue.isEmpty()) {
				int count = queue.size();
				List<Integer> list = new ArrayList<Integer>();
				while(count > 0) {
					TreeNode binaryTree = queue.poll(); // ���Ӷ�ͷԪ�ز�����
					list.add(binaryTree.val); // �������Ԫ�ص�ֵ
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
