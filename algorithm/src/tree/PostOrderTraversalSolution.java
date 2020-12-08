package tree;

import java.util.ArrayList;
import java.util.List;
/**
 * 145. �������ĺ������
 * ����һ�����������������ĺ��������
 * �������Ҹ�
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
