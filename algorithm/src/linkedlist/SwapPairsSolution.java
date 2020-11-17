package linkedlist;

/***
 * 24. �������������еĽڵ�
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 * 
 * ʾ����
 * ���� 1-->2-->3-->4
 * ���� 2-->1-->4-->3
 * @author dell
 *
 */

public class SwapPairsSolution {
	
	/**
	 * �ݹ�ⷨ
	 * ���õ�Ԫ������Ҫ������������Ϊ head �� next , head ���Ӻ��潻����ɵ�������next ���� head , ��ɽ���
	 *��ֹ������ head Ϊ��ָ����� next Ϊ��ָ�룬Ҳ���ǵ�ǰ�޽ڵ����ֻ��һ���ڵ㣬�޷����н���
	 * @return ����ֵ��������ɵ�������
	 */
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {			
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
		
	}
	
	public ListNode swapPairsNonRecursive(ListNode head) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode temp = pre;
		while(temp.next != null && temp.next.next != null) {
			ListNode start = temp.next;
			ListNode end = temp.next.next;
			temp.next = end;
			start.next = end.next;
			end.next = start;
			temp = start;
			
		}
		
		return pre.next;

	}

}
