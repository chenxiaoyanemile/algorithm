package newYear;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 995. K ����λ����С��ת����
 * �ڽ����� 0 �� 1 ������ A �У�һ�� K λ��ת����ѡ��һ������Ϊ K �����������飬
 * ͬʱ���������е�ÿ�� 0 ����Ϊ 1�� ��ÿ�� 1 ����Ϊ 0.
 * ��������� K λ��ת����С�������Ա�����û��ֵΪ0��Ԫ�ء���������ܣ�����-1.
 * 
 * ���룺A = [0,1,0],k = 1
 * ����� 2
 * �ȷ�ת A[0],�ٷ�ת A[2]
 * 
 * ���룺A = [1,1,0],k = 2
 * �����-1
 * 
 * ���� A = [0,0,0,1,0,1,1,0],k=3
 * �����3
 * @author dell
 *
 */

public class MinKBitFlipsSolution {
	
	public static void main(String[] args) {
		int[] A = {0,0,0,1,0,1,1,0};
		int k = 3;
		int result = minKBitFlips(A, k);
		System.out.print(result);
		
	}
	
	public static int minKBitFlips(int[] A, int k) {
		int result = 0;
		Queue<Integer> que = new LinkedList<>();
		for(int i = 0; i < A.length; i++) 
		{
			if(que.size() > 0 && i > que.peek() + k -1) {
				que.remove();
			}
			if(que.size() % 2 == A[i]) {
				if(i + k > A.length) return -1;
				que.add(i);
				result += 1;
			}
		}
		
		return result;
	}

}
