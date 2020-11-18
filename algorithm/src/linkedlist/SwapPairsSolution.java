package linkedlist;

/***
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例：
 * 给定 1-->2-->3-->4
 * 返回 2-->1-->4-->3
 * @author dell
 * 递归本质就是不断重复相同的事情
 * 返回值
 * 调用单元做了什么
 * 终止条件
 */

public class SwapPairsSolution {
	
	/**
	 * 递归解法
	 * 返回值：交换完成的子链表
	 * 调用单元：设需要交换的两个点为 head 和 next , head 连接后面交换完成的子链表，next 连接 head , 完成交换
	 *终止条件： head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
	 * @return 返回值：交换完成的子链表
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
	
	/**
	 * 
	 * @param head
	 * @return
	 */
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
