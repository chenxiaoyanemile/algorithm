package newYear;
/**
 * 509. 쳲���������
 * ͨ���� F(n) ��ʾ���γɵ����г�Ϊ 쳲��������С�
 * ��������0 �� 1 ��ʼ�������ÿһ�����ֶ���ǰ�������ֵĺ͡�
 * F(0) = 0;
 * F(1) = 1;
 * F(n) = F(n-1) + F(n-2), n>1;
 * ���� n ������� F(n)
 * @author dell
 *
 */
public class FibSolution {
	
	public int fib(int n) {
		if(n < 2) {
			return n;		
		}
		int p = 0;
		int q = 0;
		int r = 1;
		for(int i = 2; i <= n; ++i) {
			p = q;
			q = r;
			r = p+q;			
		}
		return r;
		
	}

}