package divide;

/**
 * 分治法：
 * 把一个复杂的问题分成两个或更多的相同或相似的子问题，再把子问题分成更小的子问题……直到最后子问题可以简单的直接求解，原问题的解即子问题的解的合并
 * 递归技术
 *  实际上就是类似于数学归纳法，找到解决本问题的求解方程公式，然后根据方程公式设计递归程序
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
		int[] arrays = {1,2,3,4,5,6,7,0};
		System.out.println("输出结果：" + optReversePairs(arrays));
		
	}
	/**
	 * 
	 *  1) 该问题的规模缩小到一定的程度就可以容易地解决
	 *  2) 该问题可以分解为若干个规模较小的相同问题，即该问题具有最优子结构性质。
	 *  3) 利用该问题分解出的子问题的解可以合并为该问题的解；☆
	 *  4) 该问题所分解出的各个子问题是相互独立的，即子问题之间不包含公共的子子问题。
	 *  第三条是关键，只具备前面两条用动态规划或者贪心算法
	 *  第四条是效率，如果不是独立的，则用动态规划
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
	 * step1 分解：将原问题分解为若干个规模较小，相互独立，与原问题形式相同的子问题；
	 * step2 解决：若子问题规模较小而容易被解决则直接解，否则递归地解各个子问题
	 * step3 合并：将各个子问题的解合并为原问题的解。
	 * 
	 * 经典问题：
	 * 1.二分搜索
	 * 2.大整数乘法
	 * 3. strassen 矩阵乘法
	 * 4. 棋盘覆盖
	 * 5.合并排序
	 * 6.快速排序
	 * 7.线性时间选择
	 * 8.最接近点对问题
	 * 9.循环赛日程表
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
	
    public static int optReversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return optMergeSort(nums, 0, nums.length - 1);
    }
    private static int optMergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l)/2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        int[] cache = new int[r - l + 1];
        int i = l, t = l, c = 0;
        for (int j = mid + 1; j <= r; j++, c++) {
            while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) cache[c++] = nums[t++];
        System.arraycopy(cache, 0, nums, l, r - l + 1);
        return count;
    }

}
