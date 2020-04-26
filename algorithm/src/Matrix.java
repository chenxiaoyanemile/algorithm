

import java.util.Arrays;

public class Matrix {
	
	private static void main(String[] args) {
		int[][] test = {{1,3},{2,6},{8,10},{15,18}};
		merge(test);
		
	}
	
	public static int[][] merge(int[][] intervals){
		Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
		int[][] res = new int[intervals.length][2];
		int idx = -1;
		for(int[] interval : intervals) {
			//如果数组是空的，或者当前区间的起始位置>最后区间的终止位置
			// 不合并，直接将当前区间加入数组
			if(idx == -1 || interval[0] > res[idx][1]) {
				res[++idx] = interval;
			}
			else {
				// 反之将当前区间合并至结果数组的最后区间
				res[idx][1] = Math.max(res[idx][1], interval[1]);
			}
		}
		
		return Arrays.copyOf(res, idx+1);
	}

}
