package newYear;

/**
 * 867.转置矩阵
 * 给你一个二维整数数组 matrix, 返回 matrix 的转置矩阵
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引和列索引
 * 
 * 实例：
 * 输入： matrix ={{1,2,3},{4,5,6},{7,8,9}}
 * 输出：{{1,4,7},{2,5,8},{3,6,9}}
 * @author dell
 *
 */

public class TransposeSolution {
	
	public static void main(String[] args) 
	{
		int[][] matrix ={{1,2,3},{4,5,6},{7,8,9}};
	}
	
	public int[][] transpose(int[][] matrix)
	{
		int M = matrix.length;
		int N = matrix[0].length;
		int[][] result = new int[N][M];
		for(int i = 0; i < M; i++) 
		{
			for(int j = 0; j < N;j++)
			{
				result[j][i] = matrix[i][j];
			}
		}
		return result;
		
	}

}
