package minStack;

import java.util.Stack;

// 1. ����һ�� ����վ ��ʵ�� push�� pop�� top
// 2. ����һ�� ����ջ �� ջ��һֱ����Ϊ��ǰ����Сֵ��ʵ�� getMin 
public class OtherMinStack {
	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;
	
	public OtherMinStack() {
		dataStack = new Stack<>();
		minStack = new Stack<>();
	}
	public void push(int x) {
		// �Ƚ� x ѹ������ջ
		dataStack.push(x);
		// ��� x �ǵ�ǰ����Сֵ����Ҳ��Ҫ�� x ѹ�� ����ջ
		if(minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}
	public void pop() {
		// ɾ������ջջ��Ԫ��
		int x = dataStack.pop();
		// x ����ǵ�ǰ����Сֵ��Ҳ��Ҫɾ������ջ��ջ��Ԫ��
		if(x == minStack.peek()) {
			minStack.pop(); // pop() ����������ջ��Ԫ�أ�ջ�в�������
		}
	}
	public int top() {
		// ����ջ��Ԫ��
		return dataStack.peek(); //peek()����������ջ��Ԫ�أ� ջ�в��Ƴ���
	}
	
	public int getMin() {
		// ������СԪ��
		return minStack.peek();
	}
}
