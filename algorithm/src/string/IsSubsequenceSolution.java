package string;

/**
 * �ж�������
 * �����ַ��� s �� t, �ж� s �Ƿ�Ϊ t ��������
 * �������Ϊ s �� t �н�����Ӣ��Сд��ĸ���ַ��� t  ���ܻ�ܳ����� s �Ǹ����ַ�����
 * �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ�ַ������ı�ʣ���ַ����λ���γɵ����ַ�����
 * ʾ����
 * s = "abc" , t = "ahbgdc"
 * ���� true
 * @author dell
 *
 */

public class IsSubsequenceSolution {
	
	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		System.out.println("��������" + isSubsequence(s, t));
		
	}
	
	public static boolean isSubsequence(String s, String t) {
		
		//���ǵ� �Ե�һ���ַ��Ĵ����� t ֮ǰ��һ�����ַ�
		
		t = ' ' + t;
		
		// �� t ���ַ��� ��Ԥ����
		int[][] dp = new int[t.length()][26]; //�洢ÿһ��λ���� a--z ����һ���ַ����ֵ�λ��
		for(char c = 'a'; c <= 'z'; c++) { // ���ζ�ÿ���ַ�������
			int nextPos = -1; // ��ʾ�����������ڳ��ָ��ַ�
			for(int i = t.length() - 1; i >= 0; i--) {//�����һλ��ʼ����
				dp[i][c - 'a'] = nextPos; // dp[i][c-'a'] �������ѭ�� ���Ƕ�ÿһ��λ�õ�a--z �ַ��Ĵ�����
				 if (t.charAt(i) == c) {//��ʾ��ǰλ���и��ַ�  ��ôָ����һ�����ַ����ֵ�λ�þ�Ҫ������  Ϊi
	                    nextPos = i;
	                }
				
			}
		}
		
		 //���ݵ����� ����ʼƥ��
        int index=0;
        for (char c:s.toCharArray()){
            index=dp[index][c-'a'];//��Ϊ����' '������֮���ڴ����һ���ַ���ʱ��  ������ڵ�һ�У��ͻ�ȥ��һ�У���Ӱ��֮���ַ����ж�
            if(index==-1){
                return false;
            }
        }
        return true;
	}
	


}
