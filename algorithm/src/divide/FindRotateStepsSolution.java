package divide;

import java.util.LinkedList;

/**
 * 514. 自由之路
 * 视频游戏“辐射4” 中，任务”通向自由“要求玩家到达名为”Freedom Trail Ring“ 的金属表盘，并使用表盘拼写特定关键词才能开门
 * 给定一个字符串 ring, 表示刻在外环上的编码；
 * 给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * 最初，ring 的第一个字符与 12:00 方向对齐。您需要顺时针或逆时针旋转ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，
 * 以此逐个拼写完 key 中的所有字符。
 * 
 * @author dell
 *
 */

public class FindRotateStepsSolution {
	
	public static void main(String[] args) {
		System.out.println("输出结果：" + findRotateSteps("godding","gd"));
	}
	
	
	/**
	 * 对于 key 的第一个字符 'g' ，已经在正确的位置，我们只需要 1 步来拼写这个字符
	 * 对于 key 的第二个字符 'd' ， 我们需要逆时针旋转 ring “godding” 2步使他编程 “ddinggo”
	 * 当然，我们还需要1步进行拼写
	 * 因此，最终输出的是4.
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
