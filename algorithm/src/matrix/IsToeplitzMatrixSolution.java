package matrix;

/**
 * 766. �������ľ���
 * ����һ�� m x n �ľ��� matrix , �������������������ľ��󣬷��� true , ���򣬷��� false.
 * �������ľ��� �����ϵ�ÿһ�������ϵ����µĶԽ����ϵ�Ԫ�ض���ͬ��
 * ʵ����
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

		int row = matrix[0].length; // 4��
		int colum = matrix.length; // 3��
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
