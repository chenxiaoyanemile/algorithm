

import java.util.HashMap;
import java.util.Map;


/**
 * �����ʹ�ã�LFU�������㷨
 * @author dell
 * Cache�У�firstLinkedList-->freq��������-->...-->freq��С������-->lastLinkedList ÿһ����������µ��ɵ����ݡ�
 * �����У�head-->���µ�����-->...-->��õ�����-->tail ��head.postָ��tail��ʱ�����Ƶ�ξ�û�����ݴ�ʱɾ������
 */
public class LFUCache {
	  Map<Integer, Node> cache;
	    DoublyLinkedList firstLinkedList;
	    DoublyLinkedList lastLinkedList;
	    int size;
	    int capacity;

	    public LFUCache(int capacity) {
	        cache = new HashMap<> (capacity);
	        firstLinkedList = new DoublyLinkedList();
	        lastLinkedList = new DoublyLinkedList();
	        firstLinkedList.post = lastLinkedList;
	        lastLinkedList.pre = firstLinkedList;
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        Node node = cache.get(key);
	        if (node == null) {
	            return -1;
	        }
	        freqInc(node);
	        return node.value;
	    }
	    
	    public void put(int key, int value) {
	        if (capacity == 0) {
	            return;
	        }
	        Node node = cache.get(key);
	        if (node != null) {
	            node.value = value;
	            freqInc(node);
	        } else {
	            if (size == capacity) {
	                // ����������ˣ�ɾ��lastLinkedList.pre�����е�tail.pre��Node������������е�Ԫ��ɾ���ˣ���ɾ��������
	                cache.remove(lastLinkedList.pre.tail.pre.key);
	                lastLinkedList.removeNode(lastLinkedList.pre.tail.pre);
	                size--;
	                if (lastLinkedList.pre.head.post == lastLinkedList.pre.tail) {
	                    removeDoublyLinkedList(lastLinkedList.pre);
	                } 
	            }
	            Node newNode = new Node(key, value); 
	            cache.put(key, newNode);
	            if (lastLinkedList.pre.freq != 1) {
	                DoublyLinkedList newDoublyLinedList = new DoublyLinkedList(1);
	                addDoublyLinkedList(newDoublyLinedList, lastLinkedList.pre);
	                newDoublyLinedList.addNode(newNode);
	            } else {
	                lastLinkedList.pre.addNode(newNode);
	            }
	            size++;
	        }
	    }

	    void freqInc(Node node) {
	        // ��node��ԭfreq��Ӧ���������Ƴ�, ������������ɾ������,
	        DoublyLinkedList linkedList = node.doublyLinkedList;
	        DoublyLinkedList preLinkedList = linkedList.pre;
	        linkedList.removeNode(node);
	        if (linkedList.head.post == linkedList.tail) { 
	            removeDoublyLinkedList(linkedList);
	        }

	        // ��node������freq��Ӧ�����������������ڣ����ȴ���������
	        node.freq++;
	        if (preLinkedList.freq != node.freq) {
	            DoublyLinkedList newDoublyLinedList = new DoublyLinkedList(node.freq);
	            addDoublyLinkedList(newDoublyLinedList, preLinkedList);
	            newDoublyLinedList.addNode(node);
	        } else {
	            preLinkedList.addNode(node);
	        }
	    }

	    void addDoublyLinkedList(DoublyLinkedList newDoublyLinedList, DoublyLinkedList preLinkedList) {
	        newDoublyLinedList.post = preLinkedList.post;
	        newDoublyLinedList.post.pre = newDoublyLinedList;
	        newDoublyLinedList.pre = preLinkedList;
	        preLinkedList.post = newDoublyLinedList; 
	    }

	    void removeDoublyLinkedList(DoublyLinkedList doublyLinkedList) {
	        doublyLinkedList.pre.post = doublyLinkedList.post;
	        doublyLinkedList.post.pre = doublyLinkedList.pre;
	    }
	}

	class Node {
	    int key;
	    int value;
	    int freq = 1;
	    Node pre;
	    Node post;
	    DoublyLinkedList doublyLinkedList;    

	    public Node() {}
	    
	    public Node(int key, int value) {
	        this.key = key;
	        this.value = value;
	    }
	}

	class DoublyLinkedList {
	    int freq;
	    DoublyLinkedList pre;
	    DoublyLinkedList post;
	    Node head;
	    Node tail;

	    public DoublyLinkedList() {
	        head = new Node();
	        tail = new Node();
	        head.post = tail;
	        tail.pre = head;
	    }

	    public DoublyLinkedList(int freq) {
	        head = new Node();
	        tail = new Node();
	        head.post = tail;
	        tail.pre = head;
	        this.freq = freq;
	    }

	    void removeNode(Node node) {
	        node.pre.post = node.post;
	        node.post.pre = node.pre;
	    }

	    void addNode(Node node) {
	        node.post = head.post;
	        head.post.pre = node;
	        head.post = node;
	        node.pre = head;
	        node.doublyLinkedList = this;
	    }
}
