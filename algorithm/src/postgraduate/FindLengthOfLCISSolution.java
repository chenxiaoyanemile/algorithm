package postgraduate;

/**
 * 674. �������������
 * ����һ��δ��������������飬�ҵ�������������������У������ظ����еĳ��ȡ�
 * ���������������п����������±� l �� r(l < r)ȷ�����������ÿ�� l <= i < r��
 * ����
 * @author dell
 *
 */

public class FindLengthOfLCISSolution {
	
	/**
	 * ����
	 * count Ϊ��ǰԪ�ط�ֵ��ans Ϊ����ֵ
	 * ��ʼ�� count = 1
	 * �� 0 λ�ÿ�ʼ����������ʱ����ǰ��Ԫ��״̬�ж��Ƿ������������ count++,
	 * �ݼ��� count = 1,��� count > ans ������� ans
	 * ֱ��ѭ������
	 * 
	 * @param nums
	 * @return
	 */
	public int findLengthOfLCIS(int[] nums) {
		if(nums.length <= 1)
			return nums.length;
		int ans = 1;
		int count = 1;
		for(int i = 0; i < nums.length-1; i++) {
			if(nums[i+1] > nums[i]) {
				count++;
			}else {
				count = 1;
			}
			ans = count > ans ? count:ans;
		}
		return ans;
		
	}
	
	//������
    public int findLengthOfLCIS2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }




}
