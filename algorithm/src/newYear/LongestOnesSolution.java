package newYear;
/**
 * 1004. ������� 1 �ĸ���
 * ����һ�������� 0 �� 1 ��ɵ����� A�����������Խ� K ��ֵ�� 0 ��� 1
 * ���ؽ����� 1 �������������ĳ���
 * 
 * ���룺 A = {1,1,1,0,0,0,1,1,1,1,0}��k = 2
 * ����� 6
 * 
 * ���룺 A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1,1}��k = 3
 * �����10
 * @author dell
 *
 */
public class LongestOnesSolution {
		
	public static void main(String[] args) {
		int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1,1};
		int k = 3;	
		System.out.print(longestOnes(A,k));
		
	}
	
	/**
	 * ����ת�� -> �ҳ�һ����������飬������������������� k �� 0
	 * 
	 * ˼·��
	 * ʹ�� left �� right ����ָ�룬�ֱ�ָ�򻬶����ڵ����ұ߽磬
	 * right �������ƣ�right ÿ���ƶ�һ�����ж� A[right] �Ƿ�Ϊ0��Ϊ0˵��������������һ��0��
	 * left �������ƣ��жϴ�ʱ������  0 �ĸ�������������� K , �� left ָ�뱻�����ƣ�ֱ�������ڵ� 0 �ĸ���С������ K Ϊֹ��
	 * �������ڳ��ȵ����ֵ��������
	 * @param A
	 * @param k
	 * @return
	 */
	public static int longestOnes(int[] A, int k) 
	{
		int result = 0;
		int right = 0 , left = 0;
		int zeros = 0;
		int n = A.length;
		while(right < n) {
			if(A[right] == 0) 
			{
				zeros++;
			}
			while(zeros > k) {
				if(A[left++] == 0) {
					zeros--;
				}
			}
			result = Math.max(result, right - left +1);
			right++;
		}
		return result;		
		
	}

}
