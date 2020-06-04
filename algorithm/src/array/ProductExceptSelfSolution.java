package array;

/**
 * ��������������ĳ˻�
 * ����һ������Ϊ n ���������� nums , ���� n > 1 ������������� output 
 * ���� output[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻�
 * 
 * ʾ����
 * ����{1,2,3,4}
 * ���{24,12,8,6}
 * @author dell
 *
 */

public class ProductExceptSelfSolution {
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4};
		int[] result = productExceptSelf(array);
		System.out.println(result.toString());
		
		
	}
	
	//��ǰ������� * �ұ�
	public int[] productExceptSelf1(int[] nums) {
		int[] res = new int[nums.length];
		int k = 1;
		for(int i = 0; i < nums.length; i++) {
			res[i] = k;
			k = k * nums[i]; // ��ʱ���ݴ洢���ǳ�ȥ��ǰԪ����ߵ�Ԫ�س˻���
		}
		
		k = 1;
		for(int i = res.length -1; i >= 0; i--) {
			res[i] *= k; // k Ϊ�����ұߵĳ˻�
			k *= nums[i]; //��ʱ���������� * �����ұߵġ�
			
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
