package structure;

import java.util.LinkedList;

/**
 * ��ָoffer 09. ������ջʵ�ֶ���
 * ˼·�� 
 * ջ A ʵ����ӹ��ܣ�ջ B ʵ�ֳ��ӹ��ܣ�
 * ջ �ĵײ���Ӧ���е�ͷ����ջ�Ķ�����Ӧ���е�β����
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
