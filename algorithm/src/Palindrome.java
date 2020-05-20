
/**
 * 验证回文字符串
 * 给定一个非空字符串 s, 最多删除一个字符，判断是否能成为回文字符串
 * 
 * @author dell
 *
 */

public class Palindrome {
	
	public static void main(String[] args) {
		String s = "aba";
		boolean result = validPalindrome(s);
		System.out.println("输出："+result);
		
		String st = "abca";
		boolean result1 = validPalindrome(st);
		System.out.println("输出："+result1);
	}

	// 判断回文数字
	 public static boolean validPalindrome(String s) {	         
	        int length = s.length();
	        char[] ch = new char[length];	    
	        for (int i = 0; i < length; i++) { 
	            ch[i] = s.charAt(i); 
	        }

	        if(length%2 == 0){
	            int mid = length/2;
	            String left = "" ;
	            String right = "";
	            for(int i = 0; i < length; i++){
	                if(i >= mid){
	                    right += ch[i];
	                }
	                else{
	                    left += ch[i];
	                }

	            }
	            if(left.equals(right)){
	                return true;
	            }
	        }
	        else{
	            int mid = length/2;
	            
	            String left = "" ;
	            String right = "";
	            for(int i = 0; i < length; i++){
	                if(i < mid ){
	                	left += ch[i];
	                   
	                }
	                if(i > mid ){
	                	 right += ch[i];
	                }

	            }
	            if(left.equals(right)){
	                return true;
	            }
	        }
	        return false;
	    }
	 
	 // 判断回文串用双指针， i 从前往后遍历，j 从后往前遍历
	 // 第一次发现不相等时，有一次删除机会，
	 // 等价于 子串范围为 （i+1，j）或者（i,j-1）的两个子串只要有任意一个是回文串，那么就是回文串，否则不是
	 public boolean validPalidrome(String s) {
		 int i = 0, j = s.length() - 1;
		 while(i < j) {
			 if(s.charAt(i) != s.charAt(j)) {
				 return isValid(s,i+1,i)|| isValid(s,i,j-1);
			 }
			 i++;
			 j++;
		 }
		
		 return true;
	 }
	 
	 public boolean isValid(String s, int i , int j) {
		 while(i < j) {
			 if(s.charAt(i) != s.charAt(j)) {
				 return false;
			 }
			 i++;
			 j++;
		 }
		 return true;
	 }
}
