package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �����������л��뷴���л�
 * ���л��ǽ�һ�����ݽṹ���߶���ת��Ϊ�����ı���λ�Ĳ������������Խ�ת��������ݴ洢��һ���ļ�
 * �����ڴ��У�ͬ��Ҳ����ͨ�����紫�䵽��һ���������������ȡ�෴��ʽ�ع��õ�ԭ���ݡ�
 * �����һ���㷨��ʵ�ֶ����������л��뷴���л���
 * ���ﲻ�޶��������/�����л��㷨ִ���߼�����ֻ��Ҫ��֤һ�����������Ա����л�Ϊһ���ַ�����
 * ���ҽ�����ַ��������л�Ϊԭʼ�����ṹ��
 * 
 * =��
 * 
 * ������ -�� �ַ��� �����л���
 * �ַ��� -�� ���Ľṹ�������л���
 * 
 * ˼·��
 * ���ղ�α����� tree ת��  string 
 * �� string - > tree ��
 * 1. �� isLeft ����ʾ cur �ڵ��ǵ�ǰ parent �ڵ�����ӻ����Һ���
 * 2. �� queue ���洢��δ�ҵ� child node �� node 
 * 3. �� isLeft �� right ��� left ʱ����ʾ��ǰ parent �ڵ�ĺ����Ѿ����꣬����ȥ��һ�� parent �ˡ�
 * @author dell
 *
 */
public class SerializeTreeSolution {
	
	public static void mian(String[] args) {
		
	}
	
	// ���л��� ��-> �ַ���
	public String serialize(TreeNode root) {
		StringBuilder res = new StringBuilder("[");
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			if(cur == null) {
				res.append("null,");
			}
			else {
				res.append(cur.val + ",");
				queue.add(cur.left);
				queue.add(cur.right);
			}
		}
		res.setLength(res.length() - 1);
		res.append("]");
		return res.toString();
	}
	// �����л����ַ��� -> ��
	public TreeNode deserialize(String data) {
		String[] nodes = data.substring(1,data.length()-1).split(",");
		TreeNode root = getNode(nodes[0]);
		Queue<TreeNode> parents = new LinkedList();
		TreeNode parent = root;
		boolean isLeft = true;
		for(int i = 1; i < nodes.length; i++) {
			TreeNode cur = getNode(nodes[i]);
			if(isLeft) {
				parent.left = cur;
			}
			else {
				parent.right = cur;
			}
			if(cur != null) {
				parents.add(cur);
			}
			isLeft = !isLeft;
			if(isLeft) {
				parent = parents.peek();
				parents.poll();
			}
		}
		
		return root;
		
	}
	
	private TreeNode getNode(String val) {
		if(val.equals("null")) {
			return null;
		}
		return new TreeNode(Integer.valueOf(val));
	}
	
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}

}
