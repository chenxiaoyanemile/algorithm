package postgraduate;
/**
 * 922. ����ż��������
 * ����һ���Ǹ��������� A ,A ��һ��������������һ��������ż��
 * ��������������Ա㵱 A[i] Ϊ����ʱ��i Ҳ����������A[i] ��ż��ʱ��i Ҳ��ż��
 * �����κ���������������������Ϊ��
 * @author dell
 *
 */
public class SortArrayByParotySolution {
	
	public int[] sortArrayByParity(int[] A) 
	{
		int n = A.length;
		int[] ans = new int[n];
		int i = 0;
		for(int x : A) {
			if(x % 2 == 0) {
				ans[i] = x;
				i+=2;
			}	
		}
		i = 1;
		for(int x : A) {
			if(x % 2 == 1) {
				ans[i] = x;
				i+=2;				
			}
			
		}
		return ans;
	}

}
