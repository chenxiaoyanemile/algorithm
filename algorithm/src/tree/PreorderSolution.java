package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N ������ǰ�����
 * ����һ�� N ������������ڵ�ֵ��ǰ�����
 * 
 * @author dell
 *
 */
public class PreorderSolution {
	
	//�����ķ���
	public List<Integer> preorder(Node root){
		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Integer> output = new LinkedList<>();
		if(root == null) {
			return output;		
		}
		stack.add(root);
		while(!stack.isEmpty()) {
			Node node = stack.pollLast();
			output.add(node.val);
			Collections.reverse(node.children);
			for(Node item : node.children) {
				stack.add(item);				
			}
		}
		
		return output;
		
	}

}