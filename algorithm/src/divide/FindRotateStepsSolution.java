package divide;

import java.util.LinkedList;

/**
 * 514. ����֮·
 * ��Ƶ��Ϸ������4�� �У�����ͨ�����ɡ�Ҫ����ҵ�����Ϊ��Freedom Trail Ring�� �Ľ������̣���ʹ�ñ���ƴд�ض��ؼ��ʲ��ܿ���
 * ����һ���ַ��� ring, ��ʾ�����⻷�ϵı��룻
 * ������һ���ַ��� key����ʾ��Ҫƴд�Ĺؼ��ʡ�����Ҫ����ܹ�ƴд�ؼ����������ַ������ٲ�����
 * �����ring �ĵ�һ���ַ��� 12:00 ������롣����Ҫ˳ʱ�����ʱ����תring ��ʹ key ��һ���ַ��� 12:00 ������룬Ȼ�������İ�ť��
 * �Դ����ƴд�� key �е������ַ���
 * 
 * @author dell
 *
 */

public class FindRotateStepsSolution {
	
	public static void main(String[] args) {
		System.out.println("��������" + findRotateSteps("godding","gd"));
	}
	
	
	/**
	 * ���� key �ĵ�һ���ַ� 'g' ���Ѿ�����ȷ��λ�ã�����ֻ��Ҫ 1 ����ƴд����ַ�
	 * ���� key �ĵڶ����ַ� 'd' �� ������Ҫ��ʱ����ת ring ��godding�� 2��ʹ����� ��ddinggo��
	 * ��Ȼ�����ǻ���Ҫ1������ƴд
	 * ��ˣ������������4.
	 * @param ring = "godding"
	 * @param key = "gd"
	 * @return  4
	 */
	public static int findRotateSteps(String ring,String key) {
		int min = Integer.MAX_VALUE;
		LinkedList<Integer>[] lists = new LinkedList[26];
		int index = 0;
		for(char c : ring.toCharArray()) {
			if(lists[c - 'a'] == null) {
				lists[c - 'a'] = new LinkedList<>();
				
			}
			lists[c - 'a'].add(index++);
		}
		int[][] dp = new int[key.length()][ring.length()];
		for(int x : lists[key.charAt(0) - 'a']) {
			dp[0][x] = Math.min(x, ring.length() - x);
		}
		
		for(int i = 1; i < key.length(); i++) {
			for(int x : lists[key.charAt(i) - 'a']) {
				int temp = Integer.MAX_VALUE;
				for(int y : lists[key.charAt(i-1) - 'a']) {
					temp = Math.min(temp, dp[i-1][y] + Math.min(Math.abs(x-y), ring.length()-Math.abs(x-y)));
					
				}
				dp[i][x] = temp;
			}
		}
		
		for(int i : lists[key.charAt(key.length() - 1)- 'a']) {
			min = Math.min(dp[key.length()-1][i], min);
		}
		
		return min + key.length();
		
		
	}
	

}
