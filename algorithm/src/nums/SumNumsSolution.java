package nums;
/**
 * �� 1+2+...+n
 * Ҫ����ʹ�ó˳����� for ,while, if, else, switch,case �ȹؼ��ּ������жϣ�for ѭ���õݹ�ʵ�֣��Ȳ�������͹�ʽ��
 * ʾ����
 * ���룺n=3
 * �����6
 * @author dell
 *
 */
public class SumNumsSolution {
	
	public static void mian(String[] args) {
		int n = 3;
		int result = sumNums(n);
		System.out.println("��������"+result);
		
	}
	
	/**
	 * ѭ���ķ�ʽ
	 * @param n ����
	 * @return
	 */
	public static int sumNums(int n) {
		int result = 1;
		for(int i = 1; i < n; i++) {
			result = result +i;
		}

		return result;
	}
	
	/**
	 * �ݹ�ķ�ʽ
	 */
	
	public static int sumNums1(int n) {
		int sum = n;
		boolean flag = n>0 && (sum += sumNums1(n-1)) > 0;
		return sum;
	}
	
	/**
	 * �Ȳ�������͹�ʽ
	 */
	public static int sumNums2(int n) {
		return (int)(Math.pow(n, 2)+n)>>1;
	}

}
