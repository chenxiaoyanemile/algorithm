package tree;

import java.util.HashMap;

/**
 * 106. ��һ������������������������������
 * 
 * @author dell
 *
 */
public class BuildTreeSolution {
	
	HashMap<Integer,Integer> meno = new HashMap<>();
	int[] post;
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		for(int i = 0; i < inorder.length; i++) meno.put(inorder[i],i); //���ڵ�ֵ������ȫ����¼�ڹ�ϣ����
		post = postorder;
		TreeNode root = buildTree(0,inorder.length -1, 0 , post.length -1);
		return root;
		
	}
	
	private TreeNode buildTree(int is, int ie, int ps, int pe) {
		if(ie < is || pe < ps) return null;
		int root = post[pe]; //���ݺ�����������ȡ�ø��ڵ�
		int ri = meno.get(root); // ��ȡ��Ӧ������
		
		TreeNode node = new TreeNode(root); // �����ýڵ�
		node.left = buildTree(is,ri-1,ps,ps+ri-is-1);
		node.right = buildTree(ri+1,ie,ps+ri-is,pe-1);
		return node; // �����½� node 
		
	}



}
