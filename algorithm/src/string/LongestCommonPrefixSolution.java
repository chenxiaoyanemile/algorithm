package string;
/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀
 * 如果不存在公共前缀，返回空字符串“”
 * 
 * @author dell
 *
 */

public class LongestCommonPrefixSolution {
	
	public static void main(String[] args) {
		String[] test = {"dog","racecar","car"};
		String res = moreBetterSolution(test);
		System.out.println("结果：" + res);
	}
	public static String moreBetterSolution(String[] strs) {
		
        if(strs.length == 0) 
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;


	}
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}
		String result = "";
		String firstStr = strs[0];
		char[] charArray = firstStr.toCharArray();
		int n = 0;
		int res = 100;
		for(int i = 1; i < strs.length; i++) {
			n = compare(firstStr,strs[i]);
			res = Math.min(n, res);
			firstStr = strs[i];
			
		}

		if(res != 0) {
			result = firstStr.substring(0,res);	
		}
		return result;
	}
	
	public static int compare(String one, String two) {
		char[] oneArray = one.toCharArray();
		char[] sencondArray = two.toCharArray();
		int result = 0;
		for(int i = 0; i < Math.min(oneArray.length, sencondArray.length);) {
			if(oneArray[i] == sencondArray[i]) {
				i++;
				result = i;
			}else {
				
				break;
			}

		}
		return result;
		
	}

}
