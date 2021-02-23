package newYear;

/**
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在哪一分钟结束后离开。
 * 
 * 在某些时候，书店老板会生气。如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1,否则 grumpy[i] = 0.
 * 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * 
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 x 分钟不生气，但只能使用一次。
 * 
 * 请你返回一天营业下来，最多有多少客户能够感到满意。
 * @author dell
 *
 */

public class MaxSatisfiedSolution {
	
	public static void main(String[] args) {
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy = {0,1,0,1,0,1,0,1};
		int x = 3;
		System.out.println("结果：" + maxStatisfy(customers,grumpy,x));
		
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
	 * 输入： 
	 * @param customers = {1,0,1,2,1,1,7,5} 
	 * @param grumpy =    {0,1,0,1,0,1,0,1}
	 * @param x = 3
	 * @return 16
	 * 
	 * 思路：
	 * 满意即grumpy[i] = 0
	 * customers[i] 相加
	 * 1+1+1+1+7+5 = 16
	 * 
	 * 第一步：求customers 连续 x 个相加最大值，记录 min ， mid， max下标。
	 * 第二步：判断 grumpy[i] 的值是否为0，且下标是否为 min ，mid，max ，是则 customers[i] 相加
	 * 第三步：返回最多客户满意数
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
