package nums;
/**
 * 每日温度
 * 根据每日气温列表，重新生成一个列表，
 * 对应位置的输出是需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替
 * @author dell
 * 
 * 给定列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，为啥输出就是 [1, 1, 4, 2, 1, 1, 0, 0] ？
 * 下面来一个个进行解释。
 * 对于输入 73，它需要 经过一天 才能等到温度的升高，也就是在第二天的时候，温度升高到 74 ，所以对应的结果是 1。
 * 对于输入 74，它需要 经过一天 才能等到温度的升高，也就是在第三天的时候，温度升高到 75 ，所以对应的结果是 1。
 * 对于输入 75，它经过 1 天后发现温度是 71，没有超过它，继续等，一直 等了四天，在第七天才等到温度的升高，温度升高到 76 ，所以对应的结果是 4 。
 * 对于输入 71，它经过 1 天后发现温度是 69，没有超过它，继续等，一直 等了两天，在第六天才等到温度的升高，温度升高到 72 ，所以对应的结果是 2 。
 * 对于输入 69，它 经过一天 后发现温度是 72，已经超过它，所以对应的结果是 1 。
 * 对于输入 72，它 经过一天 后发现温度是 76，已经超过它，所以对应的结果是 1 。
 * 对于输入 76，后续 没有温度 可以超过它，所以对应的结果是 0 。
 * 对于输入 73，后续 没有温度 可以超过它，所以对应的结果是 0 。
 */
public class DailyTemperaturesSolution {
	
	public static void main(String[] args) {
		
		int[]  temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		// 1,1,4,2,1,1,0,0
		int[] result = dailyTeperatures(temperatures);
		for(int i = 0; i < result.length; i++) {
			System.out.println("结果：" + result[i]);
		}
		
		
	}
	
	public static int[] dailyTeperatures(int[] T) {
		int length = T.length;
		int[] result = new int[length];
		for(int i = 0; i < length; i++) {
			int current = T[i];
			if(current <100) {
				for(int j = i+1; j < length; j++) {
					if(T[j] > current) {
						result[i] = j -i;
						break;
					}
				}
			}
		}
		
		return result;
	}

}
