package tree;

import java.util.Stack;

/**
 * 1028. 先序遍历还原二叉树
 * 从二叉树的根节点 root 开始进行深度优先搜索
 * 在遍历中的每个节点处，我们输出 D 条断线（D 为该节点的深度）
 * 然后输出该节点的值（根节点的深度为0）。
 * 如果节点只有一个子节点，那么保证该子节点为左子节点
 * 给出遍历输出 S , 还原树并返回其根节点 root.
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
	
	//字符串分割 ： 1、-、2、-、-、3、-、-、4、-、5、-、-、6、-、-、7
	// 1 是根节点，栈实现，遇到 - 入栈，遇到数字，全部出栈	
	public static TreeNode recoverFromPreorder(String s) {
		TreeNode root = null;
		Stack<String> stack = new Stack<String>() ;
		 char[] charArray = s.toCharArray();
		 root = new TreeNode(charArray[0]);
		 int result = 0;
		 for(int i = 1; i < charArray.length; i++) {
			 if(charArray[i] == '-') {
				 stack.push(String.valueOf(charArray[i])); // 入栈
			 }
			 else {
				 if(result == 0) {
					 int flag = 0;
					 buildTree(root,(int)charArray[i],0); // 构建左子树
					 while(stack.isEmpty()) {
						 stack.pop(); // 出栈
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
					 buildTree(root,(int)charArray[i],1); // 构建右子树 
				 }

			 }
			 
		 }
		 
		 return root;
	}
	
	//构建 二叉树
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
	
	// 优化
	   public static TreeNode optRecoverFromPreorder(String S) {
	        Stack<TreeNode> stack = new Stack<>();
	        for (int i = 0; i < S.length(); ) {
	            //查看在第几层，从0开始的，根节点是第0层
	            int level = 0;
	            while (S.charAt(i) == '-') {
	                level++;
	                i++;
	            }

	            //查看当前数字
	            int val = 0;
	            while (i < S.length() && S.charAt(i) != '-') {
	                val = val * 10 + (S.charAt(i) - '0');
	                i++;
	            }

	            //找到新结点的父节点
	            while (stack.size() > level) {
	                stack.pop();
	            }
	            //创建结点
	            TreeNode node = new TreeNode(val);
	            if (!stack.isEmpty()) {
	                //如果节点只有一个子节点，那么保证该子节点为左子节点。
	                if (stack.peek().left == null) {
	                    stack.peek().left = node;
	                } else {
	                    stack.peek().right = node;
	                }
	            }
	            //入栈
	            stack.add(node);
	        }
	        //除了根节点，其他子节点全部出栈
	        while (stack.size() > 1) {
	            stack.pop();
	        }
	        //返回根节点
	        return stack.pop();
	    }

	
	
}
