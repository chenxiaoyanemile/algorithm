package divide;

/**
 * 493. 翻转对
 * 给定一个数组 nums ， 如果 i < j 且 nums[i] > 2*nums[j] ,我们就将 （i,j）称为一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量
 * 示例：
 * 输入：{1,3,2,3,1}
 * 输出：2
 * @author EmilyCH
 * 解题思路：
 * 遍历每一个元素，让其与后面的元素对比，如果大于则 count++,时间复杂度 O(n^2)
 * 可以采用归并排序思路
 *
 */

public class ReversePairsSolution {
	
	public static void main(String[] args) {
		int[] arrays = {1,3,2,3,1};
		System.out.println("输出结果：" + reversePairs(arrays));
		
	}
	
	public static int reversePairs(int[] nums) {
		int len = nums.length;
		if(nums == null || len <= 0) {
			return 0;
		}
		return mergeSort(nums,0,len-1);
		
		
	}
	
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
				if(count > 100000007) {
					count %= 100000007;
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
		return (left_count + right_count + count)%100000007;
		
	}

}
