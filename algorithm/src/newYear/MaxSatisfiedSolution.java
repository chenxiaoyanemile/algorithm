package newYear;

/**
 * 1052. ������������ϰ�
 * ���죬����ϰ���һ�ҵ������Ӫҵ customers.length ���ӡ�ÿ���Ӷ���һЩ�˿ͣ�customers[i]���������꣬������Щ�˿Ͷ�������һ���ӽ������뿪��
 * 
 * ��ĳЩʱ������ϰ���������������ϰ��ڵ� i ������������ô grumpy[i] = 1,���� grumpy[i] = 0.
 * ������ϰ�����ʱ����һ���ӵĹ˿;ͻ᲻���⣬������������������ġ�
 * 
 * ����ϰ�֪��һ�����ܼ��ɣ��������Լ����������������Լ����� x ���Ӳ���������ֻ��ʹ��һ�Ρ�
 * 
 * ���㷵��һ��Ӫҵ����������ж��ٿͻ��ܹ��е����⡣
 * @author dell
 *
 */

public class MaxSatisfiedSolution {
	
	public static void main(String[] args) {
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy = {0,1,0,1,0,1,0,1};
		int x = 3;
		System.out.println("�����" + maxStatisfy(customers,grumpy,x));
		
	}
	
	public static int maxStatisfy(int[] customers,int[] grumpy,int X) 
	{
		int total = 0;
		int n = customers.length;
		for(int i = 0; i < n; i++) {
			if(grumpy[i] == 0) {
				total += customers[i];
			}			
		}
		int increase = 0;
		for(int i = 0; i < X; i++) {
			increase += customers[i] * grumpy[i];
		}
		
		int maxIncriease = increase;
		for(int i = X; i < n; i++) {
			increase = increase - customers[i-X]*grumpy[i-X] + customers[i]*grumpy[i];
			maxIncriease = Math.max(maxIncriease, increase);
		}
		return total + maxIncriease;
		
	}
	
	/**
	 * ���룺 
	 * @param customers = {1,0,1,2,1,1,7,5} 
	 * @param grumpy =    {0,1,0,1,0,1,0,1}
	 * @param x = 3
	 * @return 16
	 * 
	 * ˼·��
	 * ���⼴grumpy[i] = 0
	 * customers[i] ���
	 * 1+1+1+1+7+5 = 16
	 * 
	 * ��һ������customers ���� x ��������ֵ����¼ min �� mid�� max�±ꡣ
	 * �ڶ������ж� grumpy[i] ��ֵ�Ƿ�Ϊ0�����±��Ƿ�Ϊ min ��mid��max ������ customers[i] ���
	 * ���������������ͻ�������
	 */
	public static int maxSatisfied(int[] customers,int[] grumpy,int X) 
	{
		int max = getMax(customers,X);
		int result = 0;
		int min = max - X +1;
		for(int i = 0; i < grumpy.length; i++) 
		{
			if( i == min) 
			{
				for(int j = min ; j <= max; j++) 
				{
					result += customers[j];
					++i;
				}				
			}
			else if (grumpy[i] == 0) 
			{
				result += customers[i];
			}		
		}
		
		return result;
	}
	
	public static int getMax(int[] customers,int x) 
	{
		int temp = 0;
		int result = 0;
		int num = 0;
		for(int i = 0; i < customers.length; i++) 
		{
			for(int j = i; j < x; j++) 
			{
				temp += customers[j];
			}
			if(result < temp) 
			{
				result = temp;
				num = i;
			}
			if(x < customers.length) {
				
				++x;
			}

		}
		return num;
		
	}

}
