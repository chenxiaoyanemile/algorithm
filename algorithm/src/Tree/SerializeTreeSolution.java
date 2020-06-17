package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件
 * 或者内存中，同事也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列/反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串，
 * 并且将这个字符串反序列化为原始的树结构。
 * 
 * =》
 * 
 * 二叉树 -》 字符串 （序列化）
 * 字符串 -》 树的结构（反序列化）
 * 
 * 思路：
 * 按照层次遍历把 tree 转成  string 
 * 从 string - > tree ：
 * 1. 用 isLeft 来表示 cur 节点是当前 parent 节点的左孩子还是右孩子
 * 2. 用 queue 来存储还未找到 child node 的 node 
 * 3. 当 isLeft 从 right 变成 left 时，表示当前 parent 节点的孩子已经找完，可以去下一个 parent 了。
 * @author dell
 *
 */
public class SerializeTreeSolution {
	
	public static void mian(String[] args) {
		
	}
	
	// 序列化： 树-> 字符串
	public String serialize(TreeNode root) {
		StringBuilder res = new StringBuilder("[");
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			if(cur == null) {
				res.append("null,");
			}
			else {
				res.append(cur.val + ",");
				queue.add(cur.left);
				queue.add(cur.right);
			}
		}
		res.setLength(res.length() - 1);
		res.append("]");
		return res.toString();
	}
	// 反序列化：字符串 -> 树
	public TreeNode deserialize(String data) {
		String[] nodes = data.substring(1,data.length()-1).split(",");
		TreeNode root = getNode(nodes[0]);
		Queue<TreeNode> parents = new LinkedList();
		TreeNode parent = root;
		boolean isLeft = true;
		for(int i = 1; i < nodes.length; i++) {
			TreeNode cur = getNode(nodes[i]);
			if(isLeft) {
				parent.left = cur;
			}
			else {
				parent.right = cur;
			}
			if(cur != null) {
				parents.add(cur);
			}
			isLeft = !isLeft;
			if(isLeft) {
				parent = parents.peek();
				parents.poll();
			}
		}
		
		return root;
		
	}
	
	private TreeNode getNode(String val) {
		if(val.equals("null")) {
			return null;
		}
		return new TreeNode(Integer.valueOf(val));
	}
	
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}

}
