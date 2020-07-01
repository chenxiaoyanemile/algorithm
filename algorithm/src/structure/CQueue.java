package structure;

import java.util.LinkedList;

/**
 * 剑指offer 09. 用两个栈实现队列
 * 思路： 
 * 栈 A 实现入队功能，栈 B 实现出队功能；
 * 栈 的底部对应队列的头部，栈的顶部对应队列的尾部。
 * 
 * @author dell
 *
 */

public class CQueue {
	
	LinkedList<Integer> A, B;
	
	public CQueue() {
		A = new LinkedList<Integer>();
		B = new LinkedList<Integer>();
	}
	
	public void appendTail(int value) {
		A.addLast(value);
	}
	
	public int deleteHead() {
		if(!B.isEmpty()) return B.removeLast();
		if(!A.isEmpty()) return -1;
		while(!A.isEmpty())
			B.addLast(A.removeLast());
		return B.removeLast();
	}

}
