package minStack;

import java.util.Stack;

// 1. 定义一个 数据站 来实现 push、 pop、 top
// 2. 定义一个 辅助栈 ， 栈顶一直保持为当前的最小值，实现 getMin 
public class OtherMinStack {
	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;
	
	public OtherMinStack() {
		dataStack = new Stack<>();
		minStack = new Stack<>();
	}
	
	public void push(int x) {
		// 先将 x 压入数据栈
		dataStack.push(x);
		// 如果 x 是当前的最小值，则也需要将 x 压入 辅助栈
		if(minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}
	
	public void pop() {
		// 删除数据栈栈顶元素
		int x = dataStack.pop();
		// x 如果是当前的最小值，也需要删除辅助栈的栈顶元素
		if(x == minStack.peek()) {
			minStack.pop(); // pop() 方法，弹出栈顶元素，栈中不再有它
		}
	}
	
	public int top() {
		// 返回栈顶元素
		return dataStack.peek(); //peek()方法，返回栈顶元素， 栈中不移除它
	}
	
	public int getMin() {
		// 返回最小元素
		return minStack.peek();
	}
}
