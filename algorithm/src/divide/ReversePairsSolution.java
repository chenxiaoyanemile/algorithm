package divide;

/**
 * ���η���
 * ��һ�����ӵ�����ֳ�������������ͬ�����Ƶ������⣬�ٰ�������ֳɸ�С�������⡭��ֱ�������������Լ򵥵�ֱ����⣬ԭ����Ľ⼴������Ľ�ĺϲ�
 * �ݹ鼼��
 *  ʵ���Ͼ�����������ѧ���ɷ����ҵ�������������ⷽ�̹�ʽ��Ȼ����ݷ��̹�ʽ��Ƶݹ����
 * 493. ��ת��
 * ����һ������ nums �� ��� i < j �� nums[i] > 2*nums[j] ,���Ǿͽ� ��i,j����Ϊһ����Ҫ��ת�ԡ�
 * ����Ҫ���ظ��������е���Ҫ��ת�Ե�����
 * ʾ����
 * ���룺{1,3,2,3,1}
 * �����2
 * @author EmilyCH
 * ����˼·��
 * ����ÿһ��Ԫ�أ�����������Ԫ�ضԱȣ���������� count++,ʱ�临�Ӷ� O(n^2)
 * ���Բ��ù鲢����˼·
 *
 */

public class ReversePairsSolution {
	
	public static void main(String[] args) {
		int[] arrays = {1,2,3,4,5,6,7,0};
		System.out.println("��������" + reversePairs(arrays));
		
	}
	/**
	 * 
	 *  1) ������Ĺ�ģ��С��һ���ĳ̶ȾͿ������׵ؽ��
	 *  2) ��������Էֽ�Ϊ���ɸ���ģ��С����ͬ���⣬����������������ӽṹ���ʡ�
	 *  3) ���ø�����ֽ����������Ľ���Ժϲ�Ϊ������Ľ⣻��
	 *  4) ���������ֽ���ĸ������������໥�����ģ���������֮�䲻�����������������⡣
	 *  �������ǹؼ���ֻ�߱�ǰ�������ö�̬�滮����̰���㷨
	 *  ��������Ч�ʣ�������Ƕ����ģ����ö�̬�滮
	 * @param nums
	 * @return
	 */
	
	public static int reversePairs(int[] nums) {
		int len = nums.length;
		if(nums == null || len <= 0) {
			return 0;
		}
		return mergeSort(nums,0,len-1);
		
		
	}
	/**
	 * step1 �ֽ⣺��ԭ����ֽ�Ϊ���ɸ���ģ��С���໥��������ԭ������ʽ��ͬ�������⣻
	 * step2 ��������������ģ��С�����ױ������ֱ�ӽ⣬����ݹ�ؽ����������
	 * step3 �ϲ���������������Ľ�ϲ�Ϊԭ����Ľ⡣
	 * 
	 * �������⣺
	 * 1.��������
	 * 2.�������˷�
	 * 3. strassen ����˷�
	 * 4. ���̸���
	 * 5.�ϲ�����
	 * 6.��������
	 * 7.����ʱ��ѡ��
	 * 8.��ӽ��������
	 * 9.ѭ�����ճ̱�
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	
	public static int mergeSort(int[] array, int start, int end) {
		if(start == end) return 0;
		int mid = (start + end)/2;
		int left_count = mergeSort(array, start, mid);
		int right_count = mergeSort(array, mid +1, end);
		int i = mid, j = end;
		int[] copy = new int[end - start +1];
		int copy_index = end - start;
		int count = 0;
		while(i >= start && j >= mid +1) {
			if(array[i] > array[j]) {
				copy[copy_index --] = array[i--];
				count += j - mid;
				if(count > 1000000007) {
					count %= 1000000007;
				}
			}else{
				copy[copy_index --] = array[j--];
			}
		}
		while(i >= start) {
			copy[copy_index--] = array[i--];
		}
		while(j >= mid +1) {
			copy[copy_index--] = array[j--];
		}
		i = 0 ;
		while(start <= end) {
			array[start++] = copy[i++];
		}
		return (left_count + right_count + count)%1000000007;
		
	}

}
