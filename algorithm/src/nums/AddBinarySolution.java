package nums;

/**
 * ���������
 * ���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ��
 * ����Ϊ�ǿ��ַ�����ֻ�������� 1 �� 0
 * ���룺 a = "11", b = "1"
 * ����� "100"
 * @author dell
 *
 */

public class AddBinarySolution {
	
	public static void main(String[] args) {
		String a = "1001"; //9
		String b = "10";//2
		System.out.println("�����" + addBinary(a,b)); // 11 : 1011
	}
	
	public static String addBinary(String a, String b) {
		StringBuilder stringBuilder = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while(i >= 0 || j >= 0) {
			int sum = carry;
			if(j >= 0) sum += b.charAt(j--) - '0';
			if(i >= 0) sum += a.charAt(i--) - '0';
			stringBuilder.append(sum % 2);
			carry = sum / 2;
		}
		
		if(carry != 0) stringBuilder.append(carry);
		return stringBuilder.reverse().toString();
		
	}

}
