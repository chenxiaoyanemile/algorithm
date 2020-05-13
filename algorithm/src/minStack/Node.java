package minStack;

public class Node {
	//元素值
	int val;
	
	//最小值
	int min;
	
	//后继节点
	Node next;
	
	public Node(int val, int min) {
		this(val, min, null);		
	}
	
	public Node(int val, int min, Node next) {
		this.val = val;
		this.min = min;
		this.next = next;
	}

}
