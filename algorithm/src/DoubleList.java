// 创建双链表

public class DoubleList {
	
	private LinkNode head, tail; // 头尾节点
	private int size; // 链表元素数目
	
	public DoubleList() {
		head = new LinkNode(0,0);
		tail = new LinkNode(0,0);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	// 在链表头部添加节点 x
	public void addFirst(LinkNode x) {
		x.next = head.next;
		x.prev = head;
		head.next.prev = x;
		
	}
	
	// 删除链表中的 x 节点（X 一定存在）
	public void remove(LinkNode x) {
		x.prev.next = x.next;
		x.next.prev = x.prev;
		size--;		
	}
	
	//删除链表中的最后一个节点，并返回该节点
	public LinkNode removeLast() {
		if(tail.prev == head) {
			return null;
		}
		LinkNode last = tail.prev;
		remove(last);
		return last;
	}
	
	public int size() {
		return size;
	}
	

}
