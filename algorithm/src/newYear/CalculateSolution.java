package newYear;

import java.util.ArrayDeque;
import java.util.Deque;
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
	
	/**
	 * 双栈解法
	 * 对于任何表达式而言，我们都可以使用两个栈 nums 和 ops  解决：
	 * nums:存放所有的数字
	 * ops: 存放所有的数字以外的操作
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
		// 将所有的空格去掉，并将 (- 替换成 (0-, (+ 替换成 (0+
		s = s.replaceAll(" ", "");
		s = s.replaceAll("\\(-", "(0-");
		s = s.replaceAll("\\(\\+", "(0+");
		char[] cs = s.toCharArray();
		int n = s.length();
		// 存放所有的数字
		Deque<Integer> nums = new ArrayDeque<>();
		// 为了防止第一个数是负数，先往 nums 加个 0
		nums.addLast(0);
		Deque<Character> ops= new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			char c = cs[i];
			if(c == '(') 
			{
				ops.addLast(c);
			}
			else if(c == ')') 
			{
				// 计算到最近一个左括号为止
				while(!ops.isEmpty()) 
				{
					if(ops.peekLast() != '(') 
					{
						calc(nums,ops);
					}
					else 
					{
						ops.pollLast();
						break;
					}
				}				
			}
			else 
			{
				if(isNumber(c)) 
				{
					int u = 0;
					int j = i;
					while(j < n && isNumber(cs[j])) u = u * 10 + (cs[j++] -'0');
					nums.addLast(u);
					i = j-1;
				}
				else 
				{
					// 有一个新操作要入栈时，先把栈内可以算的都算了
					// 只有满足 [栈内运算符] 比 [当前运算符] 优先级高 / 同等，才进行运算
					while(!ops.isEmpty() && ops.peekLast() != '(') 
					{
						char prev = ops.peekLast();
						if(map.get(prev) >= map.get(c)) {
							calc(nums,ops);
						}
						else {
							break;
						}
					}
					ops.addLast(c);
				}
			}
			
			
		}
		while(!ops.isEmpty())  calc(nums,ops);
		return nums.peekLast();
		
	}
	
	public void calc(Deque<Integer> nums, Deque<Character> ops) {
		if(nums.isEmpty() || nums.size() < 2) return;
		if(ops.isEmpty()) return;
		int b = nums.pollLast(), a = nums.pollLast();
		char op = ops.pollLast();
		int ans = 0;
		if(op == '+') ans = a+b;
		else if(op == '-') ans = a-b;
		else if(op == '*') ans = a*b;
		else if(op == '/') ans = a/b;
		else if(op == '^') ans = (int) Math.pow(a, b);
		else if(op == '%') ans = a%b;
		nums.addLast(ans);
		
	}
	
	boolean isNumber(char c) {
		return Character.isDigit(c);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
