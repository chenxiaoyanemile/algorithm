import java.util.HashMap;

/**
 * LRU 缓存机制（ Least Recently Used）
 * 最近最少使用缓存机制，操作：获取数据 get 和 写入数据 pu
 * 获取数据 get(key): 如果秘钥 key 存在于缓存中，则获取秘钥的值，否则返回 -1；
 * 写入数据 put(key,value): 如果秘钥已经存在，则变更其数据值，如果秘钥不存在，则插入[秘钥、数据值]，当缓存容量达到上限时，应该在写入新数据之前删除最久未使用的数据值，从而为新数据留出空间
 * 
 * @author dell
 *
 */
public class LRUCache {
	
	private HashMap<Integer,LinkNode> map;
	private DoubleList cache;
	
	private int cap;  // 最大容量
	
	public LRUCache(int capacity) {
		this.cap = capacity;
		map = new HashMap<>();
		cache = new DoubleList();
	}
	
	public int get(int key) {
		if(!map.containsKey(key))
			return -1;
		int val = map.get(key).val;
		// 利用 put 方法把数据提前
		put(key,val);
		return val;
	}
	
	public void put(int key, int val) {
		// 先把新节点 x 做出来
		LinkNode x = new LinkNode(key,val);
		
		if(map.containsKey(key)) {
			//删除旧的节点，新的插入头部
			cache.remove(map.get(key));
			cache.addFirst(x);
			// 更新 map 中对应的数据
			map.put(key, x);
		}
		else {
			if(cap == cache.size()) {
				// 删除链表最后一个数据
				LinkNode last = cache.removeLast();
				map.remove(last.key);
			}
			// 直接添加到头部
			cache.addFirst(x);
			map.put(key, x);
		}	
	}
	
}


























