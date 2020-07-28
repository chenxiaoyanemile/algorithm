package matrix;

/**
 * 378. 有序矩阵中第 k 小的元素
 * 给定一个 n*n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素
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
