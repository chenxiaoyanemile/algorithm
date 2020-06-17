package array;
/**
 * ��ѹ۹����
 * �������������� A�� A[i] ��ʾ�� i ���۹⾰������֣������������� i �� j ֮��ľ���Ϊ j-i.
 * һ�Ծ��㣨i < j�� ��ɵĹ۹���ϵĵ÷�Ϊ (A[j] + A[j] + i - j):
 * ���������֮�ͼ�ȥ��������֮��ľ���
 * ����һ�Թ۹⾰����ȡ�õ���߷�
 * @author Emily CH
 *
 */
public class MaxScoreSightseeingPairSolution {
	
	public static void main(String[] args) {
		int[] testArray = {8,1,5,2,6};
		System.out.println("�����"+optMaxScoreSightseeingPair(testArray));
		
	}
	
	//һ��˼·
	public static int maxScoreSightseeingPair(int[] A) {
		int result = 0;
		for(int i = 0; i < A.length; i++) {
			for(int j = i+1; j < A.length; j++) {
				result = Math.max(result, A[i]+A[j]+i-j);
			}
		}
		return result;
	}
	
	// �Ż����˼·
	public static int optMaxScoreSightseeingPair(int[] A) {
		int result = 0;
		for(int i = 1; i < A.length; i++) {
			result = Math.max(A[i-1] + A[i] - i, result);
			A[i] = Math.max(A[i-1], A[i]+i);
		}
		return result;
	}

}
