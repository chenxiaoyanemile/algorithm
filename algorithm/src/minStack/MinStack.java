package minStack;
/**
 * ���һ��֧�� push��pop��top �����������ڳ���ʱ���ڼ�������С��Ԫ�ص�ջ
 * push(x) ��Ԫ�� x ����ջ��
 * pop() ɾ��ջ��Ԫ��
 * top() ��ȡջ��Ԫ��
 * getMin()  ����ջ����СԪ��
 * @author dell
 *
 */
public class MinStack {
	
	private Node head;
	
	public MinStack() {}
	
	public void push(int x) {
		// �½��ڵ��������ͷ������Ϊ �µ�ͷ��㣬�洢��ǰ��Ԫ��ֵ����Сֵ������ָ��֮ǰ��ͷ���
		if(head == null) {
			head = new Node(x,x);
		}
		else {
			head = new Node(x, Math.min(x, head.min),head);
		}
	}
	
	public void pop() {
		//ɾ��ջ��Ԫ��
		head = head.next;
	}
	
	public int top() {
		// ����ͷ����д洢��Ԫ��ֵ
		return head.val;
	}
	
	public int getMin() {
		// ����ͷ����д洢����Сֵ
		return head.min;
	}

}
