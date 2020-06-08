package matrix;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印每一个数字
 * 示例：
 * 输入：{{1,2,3},{4,5,6},{7,8,9}}
 * 输出：{1,2,3,6,9,8,7,4,5}
 * @author dell
 *
 */
public class SpiralOrderSolution {
	
	public static void main(String[] args) {
		
		int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
		int[] res = spiralOrder(array);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}

		
	}
	
	public static int[] spiralOrder(int[][] matrix) {
		if(matrix.length == 0) return new int[0];
		int l = 0, r = matrix[0].length -1, t = 0, b = matrix.length-1, x= 0;
		int[] res = new int[(r+1)*(b+1)];
		while(true) {
			for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // 左 - 右
			if(++t > b) break;
			for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // 上 - 下
			if(l > --r) break;
			for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // 右 - 左
			if(t > --b) break;
			for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // 下 - 上
			if(++l > r) break;
		}
		
		return res;
		
		
	}


}
