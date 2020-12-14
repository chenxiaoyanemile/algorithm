package postgraduate;

/**
 * 1528. ���������ַ���
 * ����һ���ַ��� s ��һ��������ͬ���������� indices 
 * �������������ַ��� s �����е� i ���ַ���Ҫ�ƶ��� indices[i] ָʾ��λ��
 * �����������к���ַ���
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
