package string;
/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 回文字符串：正序读和倒序读一样的字符串
 * @author Emily CH
 *
 */

public class IsPalindromeSolution {
		
	public static void main(String[] args) {
		String testValue = "A man, a plan, a canal: Panama";
		System.out.println("输出：" + isPalindrome(testValue));
	}
	
	public static boolean isPalindrome(String s) {
		String str = s.replaceAll("[^a-z^A-Z^0-9]", ""); 
		String newstr = str.toLowerCase();
		String rts = (new StringBuilder(newstr + "")).reverse().toString();
		if(newstr.equals(rts)) {
			return true;
		}
		return false;
	}
}
