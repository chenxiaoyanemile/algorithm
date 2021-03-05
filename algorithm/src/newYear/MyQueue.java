package newYear;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. ��ջʵ�ֶ���
 * �����ʹ������ջʵ���Ƚ��ȳ����С�����Ӧ��֧��һ����е�֧�ֵ����в�����push��pop��peek��empty��
 * 
 * ʵ�� MyQueue �ࣺ
 * void push(int x) ��Ԫ�� x �Ƶ����е�ĩβ
 * int pop()  �Ӷ��еĿ�ͷ�Ƴ�������Ԫ��
 * int peek()  ���ض��п�ͷ��Ԫ��
 * boolean  empty() �������Ϊ�գ����� true�� ���򣬷��� false.
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
