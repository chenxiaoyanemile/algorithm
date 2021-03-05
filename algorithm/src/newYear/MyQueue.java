package newYear;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先进先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）
 * 
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop()  从队列的开头移除并返回元素
 * int peek()  返回队列开头的元素
 * boolean  empty() 如果队列为空，返回 true， 否则，返回 false.
 * @author dell
 *
 */

public class MyQueue {
	
	Deque<Integer> inStack;
	Deque<Integer> outStack;
	
	
	public MyQueue() {		
		inStack = new LinkedList<Integer>();
		outStack = new LinkedList<Integer>();
	}
	
	public void push(int x) {
		inStack.push(x);
	}
	
	public int pop() {
		if(outStack.isEmpty()) {
			in2out();
		}		
		return outStack.pop();
	}
	
	public int peek() {
		if(outStack.isEmpty()) {
			in2out();
		}
		return outStack.pop();
	}
	
	public boolean empty() {
		return inStack.isEmpty() && outStack.isEmpty();
		
	}
	
	private void in2out() {
		while(!inStack.isEmpty()) {
			outStack.push(inStack.pop());
			
		}
	}

}
