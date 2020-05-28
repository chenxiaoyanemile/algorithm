package nums;
/**
 * 287. Ѱ���ظ���
 * ����һ������ n+1 ������������ nums , �����ֶ��� 1 �� n ֮�䣨���� 1 �� n��
 * ��֪���ٴ���һ���ظ�������������ֻ��һ���ظ����������ҳ�����ظ�������
 * @author dell
 *
 */
public class FindDuplicateSolution {
	
	/**
	 * ����ָ��˼�룬 fast �� slow ��ָ�룬 nums[slow] ��ʾȡָ���Ӧ��Ԫ��
	 * ע�� nums �����е����ֶ����� 1- n ֮��ģ��������н������߲���Խ�磩
	 * ��Ϊ���ظ����ֵĳ��֣�����������߱�Ȼ�ǳɻ��ģ�������ھ����ظ���Ԫ��
	 * ������Ѱ��������ڵ�˼·����
	 * @param nums
	 * @return
	 */
	
	public int findDuplicate(int[] nums) {
		int fast = 0, slow = 0;
		while(true) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			if(slow == fast) {
				fast = 0;
				while(nums[slow] != nums[fast]) {
					fast = nums[fast];
					slow = nums[fast];
				}
				return nums[slow];
			}
		}
		
	}
	
	/**
	 * ���ַ�
	 */
	public int binaryFindDuplicate(int[] nums) {
		int len = nums.length;
		int left = 1;
		int right = len-1;
		while(left < right) {
			int mid = (left + right)>>>1;
			int cnt = 0;
			for(int num : nums) {
				if(num <= mid) {
					cnt += 1;
				}
			}
			
			if(cnt > mid) {
				right = mid;
			}else {
				left = mid +1;
			}
		}
		return left;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
