package matrix;

/**
 * ˳ʱ���ӡ����
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡÿһ������
 * ʾ����
 * ���룺{{1,2,3},{4,5,6},{7,8,9}}
 * �����{1,2,3,6,9,8,7,4,5}
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
			for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // �� - ��
			if(++t > b) break;
			for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // �� - ��
			if(l > --r) break;
			for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // �� - ��
			if(t > --b) break;
			for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // �� - ��
			if(++l > r) break;
		}
		
		return res;
		
		
	}


}
