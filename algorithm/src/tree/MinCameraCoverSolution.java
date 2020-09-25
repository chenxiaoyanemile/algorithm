package tree;

/**
 * 968.��ض�����
 * ����һ�������������������Ľڵ��ϰ�װ����ͷ��
 * �ڵ��ϵ�ÿ������ͷ�����Լ����丸����������ֱ���Ӷ���
 * �������������нڵ��������С����ͷ����
 * 
 * @author dell
 *
 */

public class MinCameraCoverSolution {
	
	//NO_CAMERA- �ӽڵ�û���������ǰ�ڵ�Ҳû�з����
	private final int NO_CAMERA = 0;
	//HAS_CAMERA- ��ʾ��ǰ�ڵ���һ�����
	private final int HAS_CAMERA = 1;
	//NO_NEEDED- ��ʾ��ǰ�ڵ�û��������������ӽڵ���һ�������
	//�����������ˣ�����������Ҫ�������������һ���յĽڵ�Ҳ����Ҫ���
	private final int NO_NEEDED = 2;
	//ȫ�ֵģ�ͳ���ж������
	public int res = 0;
	
	
	/**
	 * ������״̬:
	 * 0=>�����������
	 * 1=>�������Ѿ�����
	 * 2=>�������ϰ�װ�����
	 * @param root
	 * @return
	 */
	public int minCameraCover(TreeNode root) {
		// �߽��ж�
		if(root == null) 
			return 0;
		// �����󷵻ص��� NO_CAMERA,��ʾ root �ڵ���ӽڵ�Ҳû�����
		// ���� root �ڵ���Ҫ���һ�����
		if(dfs(root) == NO_CAMERA) 
			res++;
		return res;
		
	}
	
	public int dfs(TreeNode root) {
		// ����ǿյģ��Ͳ���Ҫ�����
		if(root == null) {
			return NO_NEEDED;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		// ��������ӽڵ���һ���� NO_CAMERA ����ʾ�����ӽڵ��û�������Ҳû�������������
		// ���Ե�ǰ�ڵ���Ҫһ�����
		if(left == NO_CAMERA || right == NO_CAMERA) {
			// �ڵ�ǰ�ڵ��һ�������ͳ������ĸ���
			res++;
			return HAS_CAMERA;
		}
		// ��������ӽڵ�ֻҪ��һ�����������ô��ǰ�ڵ�Ͳ���Ҫ����ˣ����򷵻�һ��û������ı��
		return left == HAS_CAMERA || right == HAS_CAMERA ? NO_NEEDED : NO_CAMERA;
	}

}
