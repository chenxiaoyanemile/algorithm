package newYear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值
 * 
 * 在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度
 * 
 * 输入： {1,2,2,3,1}
 * 输出：2
 * 
 * 输入：{1,2,2,3,1,4,2}
 * 输出：6
 * @author dell
 *
 */
public class FindShortestSubArraySolution {
	
	public static void main() {
		int[] A = {1,2,2,3,1,4,2};
		System.out.println(findShortestSubArray(A));
		
	}
	
	// 优化解法
	public int findShortest(int[] nums) 
	{
		Map<Integer,int[]> map = new HashMap<Integer,int[]>();
		int n = nums.length;
		for(int i = 0; i < n; i++)
		{
			if(map.containsKey(nums[i])) // 这个数已存在于 map 中
			{
				map.get(nums[i])[0]++;// 出现的次数
				map.get(nums[i])[2] = i; // 后面出现的位置
			}
			else   // 这个数不在 map 中，加入 map 
			{
				map.put(nums[i], new int[] {1,i,i});// 1是出现次数，i 是第一次出现的位置，i 是最后一次出现的位置
			}
		}
		
		int maxNum = 0, minLen = 0;
		
		for(Map.Entry<Integer, int[]> entry : map.entrySet()) 
		{
			int[] arr = entry.getValue(); // int[] 有三个值，一个是频数，一个是第一次出现的位置，一个是最后一次出现的位置
			if(maxNum < arr[0]) 
			{
				maxNum = arr[0];  // 找到最大频数
				minLen = arr[2] - arr[1] + 1;
			}
			else if(maxNum == arr[0]) 
			{
				if(minLen > arr[2] - arr[1]+1) 
				{
					minLen = arr[2]-arr[1]+1; // 找到最短的度
				}
			}
		}
		return minLen;
		
	}
	
	
	/**
	 * [1] 找出度是多少，频数最大的数是多少
	 * [2] 遍历数组，找到最后一个频数位置
	 * [3] 找到第一个频数的位置
	 * [3] 最后一个频数位置 - 第一个频数位置 
	 * @param nums
	 * @return
	 */
	public static int findShortestSubArray(int[] nums)
	{
		
		int right = 0;
		int left = 0;		
		List<Integer> list = findMaxNum(nums);
		int[] array = new int[list.size()];
		for(int i = 0; i < list.size(); i++) 
		{
			int temp = list.get(i);
			boolean  flag = false;
			for(int k =0; k < nums.length; k++) 
			{
				if(nums[k] == temp) 
				{
					if(!flag) 
					{
						left = k;
						flag = true;
					}
					right = k;

				}
			}
			array[i] = right - left + 1; // 求得第一个频数的最短长度
		}
		Arrays.parallelSort(array);
		return array[0];
		
	}
	
	// 用 hashmap 的 key 来存放数组中存在的数字，value 存放该数字在数组中出现的次数
	public static List<Integer> findMaxNum(int[] nums) 
	{
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) 
		{
			if(map.containsKey(nums[i])) 
			{
				int temp = map.get(nums[i]);
				map.put(nums[i], temp+1);
			}
			else 
			{
				map.put(nums[i], 1);				
			}			
		}		
		Collection<Integer> count = map.values();
		//找出map 的 value 中最大的数字，也就是数组中数字出现最多的次数
		int maxCount = Collections.max(count);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) 
		{
			//获取 value 为 maxCount 的 key ，也就是数组中出现次数最多的数字
			if(maxCount == entry.getValue()) {
				list.add(entry.getKey()); // 频数最高的数
			}
			
		}
		return list;
		
	}

}
