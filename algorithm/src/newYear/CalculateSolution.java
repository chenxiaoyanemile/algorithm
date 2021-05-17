package newYear;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 227. ����������
 * ����һ���ַ������ʽ s , ����ʵ��һ�����������������㲢��������ֵ
 * ����������������������
 * 
 * ʵ����
 * ����: s = "3+2*2"
 * ����� 7
 * @author dell
 *
 */
public class CalculateSolution {
	
	public static void main(String[] args) {
		
	}
	
	// ʹ�� map ά��һ����������ȼ�
	// ��������ȼ����ְ�����ѧ���л���
	Map<Character,Integer> map = new HashMap<Character,Integer>(){{
		put('-',1);
		put('+',1);
		put('*',2);
		put('/',2);
		put('%',2);
		put('^',3);
	}};
	
	/**
	 * ˫ջ�ⷨ
	 * �����κα��ʽ���ԣ����Ƕ�����ʹ������ջ nums �� ops  �����
	 * nums:������е�����
	 * ops: ������е���������Ĳ���
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
		// �����еĿո�ȥ�������� (- �滻�� (0-, (+ �滻�� (0+
		s = s.replaceAll(" ", "");
		s = s.replaceAll("\\(-", "(0-");
		s = s.replaceAll("\\(\\+", "(0+");
		char[] cs = s.toCharArray();
		int n = s.length();
		// ������е�����
		Deque<Integer> nums = new ArrayDeque<>();
		// Ϊ�˷�ֹ��һ�����Ǹ��������� nums �Ӹ� 0
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
				// ���㵽���һ��������Ϊֹ
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
					// ��һ���²���Ҫ��ջʱ���Ȱ�ջ�ڿ�����Ķ�����
					// ֻ������ [ջ�������] �� [��ǰ�����] ���ȼ��� / ͬ�ȣ��Ž�������
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
