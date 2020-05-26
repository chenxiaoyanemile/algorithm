import java.util.HashMap;

/**
 * LRU ������ƣ� Least Recently Used��
 * �������ʹ�û�����ƣ���������ȡ���� get �� д������ pu
 * ��ȡ���� get(key): �����Կ key �����ڻ����У����ȡ��Կ��ֵ�����򷵻� -1��
 * д������ put(key,value): �����Կ�Ѿ����ڣ�����������ֵ�������Կ�����ڣ������[��Կ������ֵ]�������������ﵽ����ʱ��Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�����������ռ�
 * 
 * @author dell
 *
 */
public class LRUCache {
	
	private HashMap<Integer,LinkNode> map;
	private DoubleList cache;
	
	private int cap;  // �������
	
	public LRUCache(int capacity) {
		this.cap = capacity;
		map = new HashMap<>();
		cache = new DoubleList();
	}
	
	public int get(int key) {
		if(!map.containsKey(key))
			return -1;
		int val = map.get(key).val;
		// ���� put ������������ǰ
		put(key,val);
		return val;
	}
	
	public void put(int key, int val) {
		// �Ȱ��½ڵ� x ������
		LinkNode x = new LinkNode(key,val);
		
		if(map.containsKey(key)) {
			//ɾ���ɵĽڵ㣬�µĲ���ͷ��
			cache.remove(map.get(key));
			cache.addFirst(x);
			// ���� map �ж�Ӧ������
			map.put(key, x);
		}
		else {
			if(cap == cache.size()) {
				// ɾ���������һ������
				LinkNode last = cache.removeLast();
				map.remove(last.key);
			}
			// ֱ����ӵ�ͷ��
			cache.addFirst(x);
			map.put(key, x);
		}
		
	}

	
}


























