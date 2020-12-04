package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107.�������Ĳ�α���
 * ����һ����������������ڵ�ֵ�Ե����ϵĲ�α���
 * ������Ҷ�ӽ�����ڵĲ㵽���ڵ����ڵĲ㣬���������ұ���
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
			//ÿ�ζ�ȡ��һ�����������
			int count = queue.size();
			for(int i = 0; i < count; i++) {
				TreeNode node = queue.poll();
				oneLevel.add(node.val);
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
				
			}
			// ÿ�ζ�����ͷ��
			result.addFirst(oneLevel);
			
		}
		
		return result;	
	}

}
