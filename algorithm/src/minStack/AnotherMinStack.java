package minStack;

import java.util.Stack;

// ��ջ�б��浱ǰԪ��ֵ�����Ᵽ�浱ǰ����Сֵ
public class AnotherMinStack {
	
	public Stack<Node> stack;	
	public AnotherMinStack() {
		 stack = new Stack<>();
	}
	public void push(int x) {
		//�� x ��ջ
		if(stack.isEmpty()) {
			// ��� stack �ǿյģ���ô��ջ�� min Ҳ�� x
			stack.push(new Node(x,x));
		}
		else {
			stack.push(new Node(x, Math.min(x, stack.peek().min)));
			
		}
		
	}	
	public void pop() {
		// ��ջ
		stack.pop();
	}
	public int top() {
		// ����ջ��Ԫ��ֵ
		return stack.peek().val;
	}
	
	public int getMin() {
		// ����ջ����Сֵ
		return stack.peek().min;
	}
	
	private static class Node{
		int val;
		int min;
		
		public Node(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}

}
