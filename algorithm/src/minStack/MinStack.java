package minStack;
/**
 * 设计一个支持 push、pop、top 操作，并能在常熟时间内检索到最小的元素的栈
 * push(x) 将元素 x 推入栈中
 * pop() 删除栈顶元素
 * top() 获取栈顶元素
 * getMin()  检索栈中最小元素
 * @author dell
 *
 */
public class MinStack {
	
	private Node head;
	
	public MinStack() {}
	
	private static void main(String[] args) {
		//测试样例
		String[] array = {"MinStack","push","push","push","getMin","pop","top","getMin"};
		//输出：[null,null,null,null,-3,null,0,-2]
		
	}
	
	public void push(int x) {
		// 新建节点插入链表头部，作为 新的头结点，存储当前的元素值和最小值，并且指向之前的头结点
		if(head == null) {
			head = new Node(x,x);
		}
		else {
			head = new Node(x, Math.min(x, head.min),head);
		}
	}
	
	public void pop() {
		//删除栈顶元素
		head = head.next;
	}
	
	public int top() {
		// 返回头结点中存储的元素值
		return head.val;
	}
	
	public int getMin() {
		// 返回头结点中存储的最小值
		return head.min;
	}

}
