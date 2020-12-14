package postgraduate;

/**
 * 1528. 重新排列字符串
 * 给你一个字符串 s 和一个长度相同的整数数组 indices 
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置
 * 返回重新排列后的字符串
 * @author dell
 *
 */
public class RestoreStringSolution {
	
	public String restoreString(String s, int[] indices) 
	{
		int length = s.length();
		char[] result = new char[length];
		for(int i = 0; i < length; i++) {
			result[indices[i]] = s.charAt(i);
		}
		return new String(result);
		
	}

}
