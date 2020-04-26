

public class SortSolution {

	public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null; //ǰָ��ڵ�
        ListNode curr = head; //��ǰָ��ڵ�
        //ÿ��ѭ����������ǰ�ڵ�ָ����ǰ��Ľڵ㣬Ȼ��ǰ�ڵ��ǰ�ڵ����
        while (curr != null) {
            ListNode nextTemp = curr.next; //��ʱ�ڵ㣬�ݴ浱ǰ�ڵ����һ�ڵ㣬���ں���
            curr.next = prev; //����ǰ�ڵ�ָ����ǰ��Ľڵ�
            prev = curr; //ǰָ�����
            curr = nextTemp; //��ǰָ�����
        }
        return prev;
    }
    
    class ListNode{
    	ListNode next;
    	int tail;
    }

}
