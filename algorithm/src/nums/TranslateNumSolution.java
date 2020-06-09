package nums;
/**
 * �����ַ�����ַ���
 * ����һ�����֣����ǰ������¹������������ַ�����
 * 0 -> a
 * 1 -> b
 * ...
 * 25 -> z
 * һ�����ֿ����ж������
 * ����ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
 * @author dell
 *
 */
public class TranslateNumSolution {
	
	public static void main(String[] args) {
		int input = 12258;
		int result = translateNum(input);
		System.out.println("�����"+result);
	}
	
	public static int translateNum(int num) {
		int a = 1, b = 1, x,y=num % 10;
		while(num != 0) {
			num /= 10;
			x = num % 10;
			int tmp = 10 *x +y;
			int c = (tmp >= 10 && tmp <= 25)? a+b :a;
			b = a;
			a = c;
			y = x;
		}
		return a;

	}

}
