package tree;

/**
 * 538. �Ѷ���������ת��Ϊ�ۼ���
 * ����һ������������������ת�����ۼ�����ʹ��ÿ���ڵ��ֵ��ԭ���ڵ�ֵ�������д������Ľڵ�ֵ֮��
 * @author dell
 *
 */

public class ConvertBSTSolution {
	
	int sum = 0;
	
	// �����������
	public TreeNode convertBST(TreeNode root) {
		if(root != null) {
			convertBST(root.right);
			sum += root.val;
			convertBST(root.left);
		}
		return root;
		
	}

}
