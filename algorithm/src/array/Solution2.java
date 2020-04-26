package array;
/**
 * ����˼�� --�鲢����
 * ������̽����Ĵ�����Ϊ�������
 * 
 * @author dell
 *
 */
public class Solution2 {
	
	public int reversePairs(int[] nums) {
		int len = nums.length;
		if(len < 2) {
			return 0;
		}
		int[] copy = new int[len];
		for(int i = 0; i < len; i++) {
			copy[i] = nums[i];
			
		}
		
		int[] temp = new int[len];
		return reversePairs(copy,0,len-1,temp);
	}

	private int reversePairs(int[] copy, int i, int j, int[] temp) {
		if(i == j) {
			return 0;
		}
		
		int mid = i + (j-i)/2;
		int leftPairs = reversePairs(copy,i, mid, temp);
		int rightPairs = reversePairs(copy,mid+1, j, temp);
		//������������Ѿ�����������ϲ���ע������ʹ��С�ڵ���
		
		if(copy[mid] <= copy[mid+1]) {
			return leftPairs + rightPairs;
		}
		
		int crossPairs = mergeAndCount(copy,i,mid,j,temp);
		return leftPairs+rightPairs+crossPairs;
	}

	private int mergeAndCount(int[] copy, int left, int mid, int right, int[] temp) {
		for(int i = left; i <= right; i++) {
			temp[i] = copy[i];
		}
		
		int i = left;
		int j = mid + 1;
		int count = 0;
		
		for(int k = left; k <= right; k++) {
			// ���±���ʣ������ж��Ƿ�Խ��
			if(i == mid+1) {
				copy[k] = temp[j];
				j++;				
			}
			else if(j == right + 1) {
				copy[k] = temp[i];
				i++;
			}
			else if(temp[i] <= temp[j]) {
				copy[k] = temp[i];
				i++;
				
			}
			else {
				copy[k] = temp[j];
				j++;
				// �� j ָ���Ԫ�ع鲢��ȥ��ʱ�򣬼�������Եĸ�����ֻ������һ�д���
				count += (mid - i +1);
				
			}
		}	
		
		return count;
	}

}
