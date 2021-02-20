package newYear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. ����Ķ�
 * ����һ���ǿ���ֻ�����Ǹ������������� nums������ĶȵĶ�����ָ��������һԪ�س���Ƶ�������ֵ
 * 
 * �� nums ���ҵ��� nums ӵ����ͬ��С�Ķȵ�������������飬�����䳤��
 * 
 * ���룺 {1,2,2,3,1}
 * �����2
 * 
 * ���룺{1,2,2,3,1,4,2}
 * �����6
 * @author dell
 *
 */
public class FindShortestSubArraySolution {
	
	public static void main() {
		int[] A = {1,2,2,3,1,4,2};
		System.out.println(findShortestSubArray(A));
		
	}
	
	// �Ż��ⷨ
	public int findShortest(int[] nums) 
	{
		Map<Integer,int[]> map = new HashMap<Integer,int[]>();
		int n = nums.length;
		for(int i = 0; i < n; i++)
		{
			if(map.containsKey(nums[i])) // ������Ѵ����� map ��
			{
				map.get(nums[i])[0]++;// ���ֵĴ���
				map.get(nums[i])[2] = i; // ������ֵ�λ��
			}
			else   // ��������� map �У����� map 
			{
				map.put(nums[i], new int[] {1,i,i});// 1�ǳ��ִ�����i �ǵ�һ�γ��ֵ�λ�ã�i �����һ�γ��ֵ�λ��
			}
		}
		
		int maxNum = 0, minLen = 0;
		
		for(Map.Entry<Integer, int[]> entry : map.entrySet()) 
		{
			int[] arr = entry.getValue(); // int[] ������ֵ��һ����Ƶ����һ���ǵ�һ�γ��ֵ�λ�ã�һ�������һ�γ��ֵ�λ��
			if(maxNum < arr[0]) 
			{
				maxNum = arr[0];  // �ҵ����Ƶ��
				minLen = arr[2] - arr[1] + 1;
			}
			else if(maxNum == arr[0]) 
			{
				if(minLen > arr[2] - arr[1]+1) 
				{
					minLen = arr[2]-arr[1]+1; // �ҵ���̵Ķ�
				}
			}
		}
		return minLen;
		
	}
	
	
	/**
	 * [1] �ҳ����Ƕ��٣�Ƶ���������Ƕ���
	 * [2] �������飬�ҵ����һ��Ƶ��λ��
	 * [3] �ҵ���һ��Ƶ����λ��
	 * [3] ���һ��Ƶ��λ�� - ��һ��Ƶ��λ�� 
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
			array[i] = right - left + 1; // ��õ�һ��Ƶ������̳���
		}
		Arrays.parallelSort(array);
		return array[0];
		
	}
	
	// �� hashmap �� key ����������д��ڵ����֣�value ��Ÿ������������г��ֵĴ���
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
		//�ҳ�map �� value ���������֣�Ҳ�������������ֳ������Ĵ���
		int maxCount = Collections.max(count);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) 
		{
			//��ȡ value Ϊ maxCount �� key ��Ҳ���������г��ִ�����������
			if(maxCount == entry.getValue()) {
				list.add(entry.getKey()); // Ƶ����ߵ���
			}
			
		}
		return list;
		
	}

}
