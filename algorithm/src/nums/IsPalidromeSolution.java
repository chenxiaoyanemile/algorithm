package nums;
/**
 * �ж�һ�������Ƿ��ǻ�����
 * ��������������͵����һ��������
 * @author dell
 *
 */
public class IsPalidromeSolution {
	public static void mian(String[] args) {
		int x = 132231;
		System.out.println("�����"+ isPalidrome(x));
		
	}
	
	public static boolean isPalidrome(int x) {
		String reversedStr = (new StringBuilder(x + "")).reverse().toString();
		return (x+"").equals(reversedStr);
	}
}
