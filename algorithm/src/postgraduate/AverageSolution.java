package postgraduate;

/**
 * 1491. 去掉最低工资和最高工资的工资平均值
 * 给你一个整数数组 salary, 数组里每个数都是唯一的，其中 salary[i] 是第 i 个员工的工资
 * 请返回去掉最低工资和最高工资后，剩下员工工资的平均值。
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
