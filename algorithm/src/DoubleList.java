// ����˫����

public class DoubleList {
	
	private LinkNode head, tail; // ͷβ�ڵ�
	private int size; // ����Ԫ����Ŀ
	
	public DoubleList() {
		head = new LinkNode(0,0);
		tail = new LinkNode(0,0);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	// ������ͷ����ӽڵ� x
	public void addFirst(LinkNode x) {
		x.next = head.next;
		x.prev = head;
		head.next.prev = x;
		
	}
	
	// ɾ�������е� x �ڵ㣨X һ�����ڣ�
	public void remove(LinkNode x) {
		x.prev.next = x.next;
		x.next.prev = x.prev;
		size--;		
	}
	
	//ɾ�������е����һ���ڵ㣬�����ظýڵ�
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
