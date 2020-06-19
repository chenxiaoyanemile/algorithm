package string;
/**
 * 125. ��֤���Ĵ�
 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
 * �����ַ�����������͵����һ�����ַ���
 * @author Emily CH
 *
 */

public class IsPalindromeSolution {
		
	public static void main(String[] args) {
		String testValue = "A man, a plan, a canal: Panama";
		System.out.println("�����" + isPalindrome(testValue));
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
