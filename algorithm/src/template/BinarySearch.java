package template;

/**
 * ���ֲ���
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
			if(x == Array[mid]) return mid; // �ж��ҵ���
			if(x < Array[mid]) right = mid; //û���ҵ�����С����
			else left = mid +1; // û���ҵ�����������
		
		}		
		return 0; // û���ҵ�
		
	}

}
