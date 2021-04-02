package newYear;

import java.util.HashMap;
import java.util.Map;

/**
 * 227. 基本计算器
 * 给你一个字符串表达式 s , 请你实现一个基本计算器来计算并返回他的值
 * 整数除法仅保留整数部分
 * 
 * 实例：
 * 输入: s = "3+2*2"
 * 输出： 7
 * @author dell
 *
 */
public class CalculateSolution {
	
	public static void main(String[] args) {
		
	}
	
	// 使用 map 维护一个运算符优先级
	// 这里的优先级划分按照数学进行划分
	Map<Character,Integer> map = new HashMap<Character,Integer>(){{
		put('-',1);
		put('+',1);
		put('*',2);
		put('/',2);
		put('%',2);
		put('^',3);
	}};
	
	public int calculate(String s) {
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
