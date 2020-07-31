package divide;

/**
 * ��ָ Offer 39. �����г��ֳ���һ�������
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 * @author dell
 *
 */
public class MajorityElementSolution {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,1,2,3,6,2,2,8,2,2,2,2};
		System.out.println(majorityElement(nums));
	}
	
	public static int majorityElement(int[] nums) {
		int x =0, votes = 0;
		for(int num : nums) {
			if(votes == 0) x = num;
			votes += num == x ? 1:-1;
			
		}
		return x;
	}

}
