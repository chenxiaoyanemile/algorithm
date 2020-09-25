package tree;

/**
 * 968.监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄像头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量
 * 
 * @author dell
 *
 */

public class MinCameraCoverSolution {
	
	//NO_CAMERA- 子节点没有相机，当前节点也没有放相机
	private final int NO_CAMERA = 0;
	//HAS_CAMERA- 表示当前节点有一个相机
	private final int HAS_CAMERA = 1;
	//NO_NEEDED- 表示当前节点没有相机，但他的子节点有一个相机，
	//把它给覆盖了，所以它不需要相机。或者她是一个空的节点也不需要相机
	private final int NO_NEEDED = 2;
	//全局的，统计有多少相机
	public int res = 0;
	
	
	/**
	 * 有三个状态:
	 * 0=>这个结点待覆盖
	 * 1=>这个结点已经覆盖
	 * 2=>这个结点上安装了相机
	 * @param root
	 * @return
	 */
	public int minCameraCover(TreeNode root) {
		// 边界判断
		if(root == null) 
			return 0;
		// 如果最后返回的是 NO_CAMERA,表示 root 节点的子节点也没有相机
		// 所以 root 节点需要添加一个相机
		if(dfs(root) == NO_CAMERA) 
			res++;
		return res;
		
	}
	
	public int dfs(TreeNode root) {
		// 如果是空的，就不需要相机了
		if(root == null) {
			return NO_NEEDED;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		// 如果左右子节点有一个是 NO_CAMERA ，表示的是子节点既没有相机，也没有相机覆盖它，
		// 所以当前节点需要一个相机
		if(left == NO_CAMERA || right == NO_CAMERA) {
			// 在当前节点放一个相机，统计相机的个数
			res++;
			return HAS_CAMERA;
		}
		// 如果左右子节点只要有一个有相机，那么当前节点就不需要相机了，否则返回一个没有相机的标记
		return left == HAS_CAMERA || right == HAS_CAMERA ? NO_NEEDED : NO_CAMERA;
	}

}
