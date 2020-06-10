package nums;

/**
 * ��֤�����ַ���
 * ����һ���ǿ��ַ��� s, ���ɾ��һ���ַ����ж��Ƿ��ܳ�Ϊ�����ַ���
 * 
 * @author dell
 *
 */

public class Palindrome {
	
	public static void main(String[] args) {
		String s = "aba";
		boolean result = validPalindrome(s);
		System.out.println("�����"+result);
		
		String st = "abca";
		boolean result1 = validPalindrome(st);
		System.out.println("�����"+result1);
	}

	// �жϻ�������
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
	 
	 // �жϻ��Ĵ���˫ָ�룬 i ��ǰ���������j �Ӻ���ǰ����
	 // ��һ�η��ֲ����ʱ����һ��ɾ�����ᣬ
	 // �ȼ��� �Ӵ���ΧΪ ��i+1��j�����ߣ�i,j-1���������Ӵ�ֻҪ������һ���ǻ��Ĵ�����ô���ǻ��Ĵ���������
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
