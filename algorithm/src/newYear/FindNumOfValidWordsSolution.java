package newYear;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1178. 猜字谜
 * 字谜的谜面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 
 *返回一个答案数组 answer， 数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为 字谜谜面 puzzles[i] 所对应的谜底的单词数目。
 *
 * @author dell
 *
 */
public class FindNumOfValidWordsSolution {
	
	// 输入： words = {"aaaa","asas","able","ability","actt","actor","access"};
	// 输入：puzzles  = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
	// 输出：{1,1,3,2,4,0}
	public static void main(String[] args) {
		String[]  words = {"aaaa","asas","able","ability","actt","actor","access"};
		String[] puzzles  = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
		List<Integer> res = new ArrayList<>();
		res = findNumOfValidWords(words,puzzles);
		for(int i = 0; i < res.size(); i++) {
			System.out.println("输出：" + res.get(i));
		}
		
	}
	
	/**
	 * 
	 * @param words
	 * @param puzzles
	 * @return
	 */
	public static List<Integer> findNumOfValidWords(String[] words,String[] puzzles){
		Map<Integer,Integer> map = new HashMap<>(); 
		for(String word:words) {
			int key = 0;
			for(char ch : word.toCharArray()) key |= 1 << ch - 'a';
			map.put(key, map.getOrDefault(key, 0)+1);
		}
		
		List<Integer> res = new ArrayList<>(puzzles.length);
		for(String p : puzzles) {
			char[] puzzle = p.toCharArray();
			res.add(dfs(puzzle,1,map,1<<puzzle[0]-'a'));
		}
		return res;
	}
	
	public static int dfs(char[] puzzle,int idx, Map<Integer,Integer> map,int key) {
		if(idx == puzzle.length) return map.getOrDefault(key, 0);
		return dfs(puzzle,idx+1,map,key) + dfs(puzzle,idx +1,map,key | 1<<puzzle[idx] - 'a');
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
