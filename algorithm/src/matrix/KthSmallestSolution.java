package matrix;

/**
 * 378. ��������е� k С��Ԫ��
 * ����һ�� n*n ��������ÿ�к�ÿ��Ԫ�ؾ������������ҵ������е� k С��Ԫ��
 * ��ע�⣬���������ĵ� k СԪ�أ������ǵ� k ����ͬ��Ԫ��
 * @author dell
 *
 */

public class KthSmallestSolution {
	
	public static void main(String[] args) {
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		
		
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix[0].length;
		int i = k % n;
		int j = k /n;
		return matrix[j-1][i-1];	
	}

}
