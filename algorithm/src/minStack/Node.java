package minStack;

public class Node {
	//Ԫ��ֵ
	int val;
	
	//��Сֵ
	int min;
	
	//��̽ڵ�
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
