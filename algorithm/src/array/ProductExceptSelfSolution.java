package array;

/**
 * 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums , 其中 n > 1 ，返回输出数组 output 
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
 * 
 * 示例：
 * 输入{1,2,3,4}
 * 输出{24,12,8,6}
 * @author dell
 *
 */

public class ProductExceptSelfSolution {
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4};
		int[] result = productExceptSelf(array);
		System.out.println(result.toString());
		
		
	}
	
	//当前数的左边 * 右边
	public int[] productExceptSelf1(int[] nums) {
		int[] res = new int[nums.length];
		int k = 1;
		for(int i = 0; i < nums.length; i++) {
			res[i] = k;
			k = k * nums[i]; // 此时数据存储的是除去当前元素左边的元素乘积。
		}
		
		k = 1;
		for(int i = res.length -1; i >= 0; i--) {
			res[i] *= k; // k 为该数右边的乘积
			k *= nums[i]; //此时数组等于左边 * 该数右边的。
			
		}
		
		return res;
	}
	
	public static int[] productExceptSelf(int[] array) {
		int[] result = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = 1;
			for(int j = 0; j < array.length; j++) {
				if(j != i) {
					result[i] = result[i]*array[j];
				}
			}
			
		}
		return result;
	}

}
