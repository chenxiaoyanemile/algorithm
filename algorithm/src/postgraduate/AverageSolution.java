package postgraduate;

/**
 * 1491. ȥ����͹��ʺ���߹��ʵĹ���ƽ��ֵ
 * ����һ���������� salary, ������ÿ��������Ψһ�ģ����� salary[i] �ǵ� i ��Ա���Ĺ���
 * �뷵��ȥ����͹��ʺ���߹��ʺ�ʣ��Ա�����ʵ�ƽ��ֵ��
 * @author dell
 *
 */

public class AverageSolution {
	
	public double average(int[] salary) {
		double sum = 0;
		double maxValue = Integer.MAX_VALUE;
		double minValue = Integer.MIN_VALUE;
		for(int num : salary) {
			sum+=num;
			maxValue = Math.max(maxValue, num);
			minValue = Math.min(minValue, num);
			
		}
		return (sum - maxValue - minValue)/(salary.length - 2);
		
	}

}
