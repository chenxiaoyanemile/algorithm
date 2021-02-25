package newYear;

/**
 * 867.ת�þ���
 * ����һ����ά�������� matrix, ���� matrix ��ת�þ���
 * �����ת����ָ����������Խ��߷�ת�������������������������
 * 
 * ʵ����
 * ���룺 matrix ={{1,2,3},{4,5,6},{7,8,9}}
 * �����{{1,4,7},{2,5,8},{3,6,9}}
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
