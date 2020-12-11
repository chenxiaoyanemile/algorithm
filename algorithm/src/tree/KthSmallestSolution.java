package tree;

import java.util.ArrayList;

/**
 * 230. �����������е� K С��Ԫ��
 * ����һ����������������дһ���������������е� k ����С��Ԫ�ء�
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
