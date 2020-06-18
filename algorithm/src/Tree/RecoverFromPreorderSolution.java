package Tree;

import java.util.Stack;

/**
 * 1028. ���������ԭ������
 * �Ӷ������ĸ��ڵ� root ��ʼ���������������
 * �ڱ����е�ÿ���ڵ㴦��������� D �����ߣ�D Ϊ�ýڵ����ȣ�
 * Ȼ������ýڵ��ֵ�����ڵ�����Ϊ0����
 * ����ڵ�ֻ��һ���ӽڵ㣬��ô��֤���ӽڵ�Ϊ���ӽڵ�
 * ����������� S , ��ԭ������������ڵ� root.
 * 
 * @author Emily CH
 *
 */

public class RecoverFromPreorderSolution {

	public static void main(String[] args) {
		String testStr = "1-2--3--4-5--6--7";
		//result = {1,2,5,3,4,6,7}
		optRecoverFromPreorder(testStr);
		
	}
	
	//�ַ����ָ� �� 1��-��2��-��-��3��-��-��4��-��5��-��-��6��-��-��7
	// 1 �Ǹ��ڵ㣬ջʵ�֣����� - ��ջ���������֣�ȫ����ջ	
	public static TreeNode recoverFromPreorder(String s) {
		TreeNode root = null;
		Stack<String> stack = new Stack<String>() ;
		 char[] charArray = s.toCharArray();
		 root = new TreeNode(charArray[0]);
		 int result = 0;
		 for(int i = 1; i < charArray.length; i++) {
			 if(charArray[i] == '-') {
				 stack.push(String.valueOf(charArray[i])); // ��ջ
			 }
			 else {
				 if(result == 0) {
					 int flag = 0;
					 buildTree(root,(int)charArray[i],0); // ����������
					 while(stack.isEmpty()) {
						 stack.pop(); // ��ջ
						 ++flag;
					 }
					 if(result == flag -1) {
						 result = flag;
					 }
					 else {
						 result = 1;
					 }
				 }
				 else{
					 buildTree(root,(int)charArray[i],1); // ���������� 
				 }

			 }
			 
		 }
		 
		 return root;
	}
	
	//���� ������
	public static void buildTree(TreeNode node,int data,int flag) {
		if(node == null) {
			node = new TreeNode(data);
		}
		else {
			if(flag == 0) {
				if(node.left == null) {
					node.left = new TreeNode(data);
				}
				else {
					buildTree(node.left,data,0);
				}
			}
			else {
				if(node.right == null) {
					node.right = new TreeNode(data);
				}
				else {
					buildTree(node.right,data,1);
				}
			}
		}
	}
	
	// �Ż�
	   public static TreeNode optRecoverFromPreorder(String S) {
	        Stack<TreeNode> stack = new Stack<>();
	        for (int i = 0; i < S.length(); ) {
	            //�鿴�ڵڼ��㣬��0��ʼ�ģ����ڵ��ǵ�0��
	            int level = 0;
	            while (S.charAt(i) == '-') {
	                level++;
	                i++;
	            }

	            //�鿴��ǰ����
	            int val = 0;
	            while (i < S.length() && S.charAt(i) != '-') {
	                val = val * 10 + (S.charAt(i) - '0');
	                i++;
	            }

	            //�ҵ��½��ĸ��ڵ�
	            while (stack.size() > level) {
	                stack.pop();
	            }
	            //�������
	            TreeNode node = new TreeNode(val);
	            if (!stack.isEmpty()) {
	                //����ڵ�ֻ��һ���ӽڵ㣬��ô��֤���ӽڵ�Ϊ���ӽڵ㡣
	                if (stack.peek().left == null) {
	                    stack.peek().left = node;
	                } else {
	                    stack.peek().right = node;
	                }
	            }
	            //��ջ
	            stack.add(node);
	        }
	        //���˸��ڵ㣬�����ӽڵ�ȫ����ջ
	        while (stack.size() > 1) {
	            stack.pop();
	        }
	        //���ظ��ڵ�
	        return stack.pop();
	    }

	
	
}
