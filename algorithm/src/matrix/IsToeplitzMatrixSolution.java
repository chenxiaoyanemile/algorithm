package matrix;

/**
 * 766. 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix , 如果这个矩阵是托普利茨矩阵，返回 true , 否则，返回 false.
 * 托普利茨矩阵： 矩阵上的每一条由左上到右下的对角线上的元素都相同。
 * 实例：
 * 1,2,3,4
 * 5,1,2,3
 * 9,4,1,2
 * @author dell
 *
 */

public class IsToeplitzMatrixSolution {
	
	public static void main(String[] args) 
	{
		int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		System.out.println(isToeplitzMatrix(matrix));
		
	}
	
	
	public static boolean isToeplitzMatrix(int[][] matrix) 
	{

		int row = matrix[0].length; // 4列
		int colum = matrix.length; // 3行
		for(int i = 1; i < colum;i++) 
		{
			for(int j = 1; j < row; j++ ) 
			{
				if(matrix[i][j] != matrix[i-1][j-1]) 
				{
					return false;					
				}
				
			}			
			
		}
		
		return true;
		
	}

}
