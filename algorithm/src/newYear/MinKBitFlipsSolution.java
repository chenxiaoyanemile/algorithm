package newYear;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 995. K 连续位的最小翻转次数
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的连续子数组，
 * 同时将子数组中的每个 0 更改为 1， 而每个 1 更改为 0.
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为0的元素。如果不可能，返回-1.
 * 
 * 输入：A = [0,1,0],k = 1
 * 输出： 2
 * 先翻转 A[0],再翻转 A[2]
 * 
 * 输入：A = [1,1,0],k = 2
 * 输出：-1
 * 
 * 输入 A = [0,0,0,1,0,1,1,0],k=3
 * 输出：3
 * @author dell
 *
 */

public class MinKBitFlipsSolution {
	
	public static void main(String[] args) {
		int[] A = {0,0,0,1,0,1,1,0};
		int k = 3;
		int result = minKBitFlips(A, k);
		System.out.print(result);
		
	}
	
	public static int minKBitFlips(int[] A, int k) {
		int result = 0;
		Queue<Integer> que = new LinkedList<>();
		for(int i = 0; i < A.length; i++) 
		{
			if(que.size() > 0 && i > que.peek() + k -1) {
				que.remove();
			}
			if(que.size() % 2 == A[i]) {
				if(i + k > A.length) return -1;
				que.add(i);
				result += 1;
			}
		}
		
		return result;
	}

}
