package newYear;

/**
 * 338. ����λ����
 * ����һ���Ǹ����� num. ���� 0<=i<=num ��Χ�е�ÿ������ i , ��������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
 * ���룺2
 * �����{0,1,1}
 * @author dell
 *
 */

public class CountBitsSolution {
	
	public static void main(String[] args) {
		int num = 5;
		int[] result = countBits(num);
	}
	
	public static int[] countBits(int num) 
	{
		int[] result = new int[num+1];
		for(int i =1; i <= num; i++) {
			result[i] = result[i >> 1] + (i & 1);
		}
		return result;
	}

}
