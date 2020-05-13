package minStack;

import java.util.Stack;

// 在栈中保存当前元素值，额外保存当前的最小值

public class AnotherMinStack {
	
	public Stack<Node> stack;
	
	public AnotherMinStack() {
		 stack = new Stack<>();
	}
	
	public void push(int x) {
		//将 x 入栈
		if(stack.isEmpty()) {
			// 如果 stack 是空的，那么入栈， min 也是 x
			stack.push(new Node(x,x));
		}
		else {
			stack.push(new Node(x, Math.min(x, stack.peek().min)));
			
		}
		
	}
	
	public void pop() {
		// 出栈
		stack.pop();
	}
	
	public int top() {
		// 返回栈顶元素值
		return stack.peek().val;
	}
	
	public int getMin() {
		// 返回栈中最小值
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
