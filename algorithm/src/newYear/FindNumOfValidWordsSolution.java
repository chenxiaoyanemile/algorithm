package newYear;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1178. ������
 * ���յ����� puzzle ���ַ�����ʽ���������һ������ word ��������������������ô���Ϳ��������յף�
 * ���� word �а������� puzzle �ĵ�һ����ĸ��
 * ���� word �е�ÿһ����ĸ������������ puzzle ���ҵ���
 * 
 *����һ�������� answer�� �����е�ÿ��Ԫ�� answer[i] ���ڸ����ĵ����б� words �п�����Ϊ �������� puzzles[i] ����Ӧ���յ׵ĵ�����Ŀ��
 *
 * @author dell
 *
 */
public class FindNumOfValidWordsSolution {
	
	// ���룺 words = {"aaaa","asas","able","ability","actt","actor","access"};
	// ���룺puzzles  = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
	// �����{1,1,3,2,4,0}
	public static void main(String[] args) {
		String[]  words = {"aaaa","asas","able","ability","actt","actor","access"};
		String[] puzzles  = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
		List<Integer> res = new ArrayList<>();
		res = findNumOfValidWords(words,puzzles);
		for(int i = 0; i < res.size(); i++) {
			System.out.println("�����" + res.get(i));
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
