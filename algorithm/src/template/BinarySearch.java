package template;

/**
 * 二分查找
 * 
 * @author dell
 *
 */

public class BinarySearch {
	
	public int binary_search(int[] Array,int x) 
	{
		int mid = 0;
		int left = 0;
		int right = Array.length;
		while(left < right) {
			mid = left +(right-1)/2;
			if(x == Array[mid]) return mid; // 判断找到了
			if(x < Array[mid]) right = mid; //没有找到，且小于它
			else left = mid +1; // 没有找到，但大于它
		
		}		
		return 0; // 没有找到
		
	}

}
