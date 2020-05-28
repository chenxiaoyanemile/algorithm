package string;

import java.util.LinkedList;

/**
 * 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * @author dell
 *
 */
public class DecodeStringSolution {
	public static void mian(String[] args) {
		String str = "3[a]2[bc]";
		String res = decodeString(str);
		System.out.println("结果："+ res);
		
		
		
	}
	
	public static String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		int multi = 0;
		LinkedList<Integer> stack_multi = new LinkedList<>();
		LinkedList<String> stack_res = new LinkedList<>();
		for(Character c : s.toCharArray()) {
			if(c == '[') {
				stack_multi.addLast(multi);
				stack_res.addLast(res.toString());
				multi = 0;
				res = new StringBuilder();
			}
			else if(c == ']') {
				StringBuilder tmp = new StringBuilder();
				int cur_multi = stack_multi.removeLast();
				for(int i = 0; i < cur_multi; i++) {
					tmp.append(res);
				}
				res = new StringBuilder(stack_res.removeLast() + tmp);
			}
			else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
			else res.append(c);
		}
		
		return res.toString();
	}

}
