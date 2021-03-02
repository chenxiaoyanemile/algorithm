package newYear;
/**
 * 304. ��ά����ͼ��� - ���󲻿ɱ�
 * ����һ����ά���󣬼������Ӿ���Χ��Ԫ�ص��ܺͣ����Ӿ�������Ͻ�Ϊ��row1,col1�������½�Ϊ��row2,col2��
 * 
 * ��ͼ�Ӿ������Ͻǣ�row1,col1�� = {2,1}
 * ���½ǣ�row2,col2��={4,3}
 * ���Ӿ�����Ԫ�ص��ܺ�Ϊ 8��
 * @author dell
 *
 */
public class NumMatrixSolution {

	public static void main(String[] args) {
		
	}
	
	class NumMatrix{
		
		int[][] preSum;
		
		public NumMatrix(int[][] matrix) {
			
			int m = matrix.length;
			if(m > 0) {
				int n = matrix[0].length;
				this.preSum = new int[m][n];
				preSum[0][0] = matrix[0][0];
				for(int i = 1; i < m; i++) {
					preSum[0][0] = preSum[i-1][0] + matrix[i][0];
				}
				for(int i =1; i <n;i++) {
					preSum[0][i] = preSum[0][i-1] + matrix[0][i];
				}
				for(int i = 1; i < m; i++) {
					for(int j=1; j < n; j++) {
						preSum[i][j] = matrix[i][j] + preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1];
					}
				}
			}
			
		}
		
		public int sumRegion(int row1,int col1, int row2,int col2) {
			if(row1 == 0 && col1 == 0) {
				return preSum[row2][col2];
			}else if(row1 == 0) {
				return preSum[row2][col2] - preSum[row2][col1-1];
			}else if(col1 == 0) {
				return preSum[row2][col2] - preSum[row1-1][col2];
			}
			return preSum[row2][col2] - preSum[row1-1][col2]-preSum[row2][col1-1]+preSum[row1-1][col1-1];
			
		}
		
	}
}
