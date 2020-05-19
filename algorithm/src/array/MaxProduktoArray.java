package array;

/**
 * 
 * 152. �˻����������
 * ��һ���������� nums , �����ҳ������г˻��������������飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻�
 * @author dell
 * ʾ����
 * ���룺{2,3,-2,4}
 * �����6
 *
 */
public class MaxProduktoArray {
	
	public static void main(String[] args) {
		int[] array = {2,3,-2,4};
		int result = maxProduct(array);
		System.out.println("�����"+result);
		
	}
	
	public static int maxProduct(int[] nums) {
		 
		int max = Integer.MIN_VALUE;
		int imax = 1;
		int imin = 1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < 0) {
				int tmp = imax;
				imax = imin;
				imin = tmp;
			}
			imax = Math.max(imax*nums[i], nums[i]);
			imin = Math.min(imin*nums[i], nums[i]);
			
			max = Math.max(max, imax);
		}
		
		return max;
	}

}
