package nums;

/**
 * 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）
 * 输入为非空字符串且只包含数字 1 和 0
 * 输入： a = "11", b = "1"
 * 输出： "100"
 * @author Emily CH
 *
 */
public class AddBinarySolution {
	
	public static void main(String[] args) {
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"; 
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		System.out.println("输出：" + addBinary(a,b)); 
	}
	/**
	 *   10100000100100110110010000010101111011011001101
	 * +                        111001100000011011110011
	 * -------------------------------------------------
	 * 
	  *  从右到左逐个相加
	 * @param a 加数
	 * @param b 加数
	 * @return 和的二进制字符串
	 */	
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
