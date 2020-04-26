

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
			//��������ǿյģ����ߵ�ǰ�������ʼλ��>����������ֹλ��
			// ���ϲ���ֱ�ӽ���ǰ�����������
			if(idx == -1 || interval[0] > res[idx][1]) {
				res[++idx] = interval;
			}
			else {
				// ��֮����ǰ����ϲ������������������
				res[idx][1] = Math.max(res[idx][1], interval[1]);
			}
		}
		
		return Arrays.copyOf(res, idx+1);
	}

}
