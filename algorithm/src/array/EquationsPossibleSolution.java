package array;
/**
 * ��ʽ���̵Ŀ�������
 * ����һ���ɱ�ʾ����֮���ϵ���ַ���������ɵ����飬ÿ���ַ������� equations[i] �ĳ���Ϊ 4
 * ���������ֲ�ͬ����ʽ֮һ�� ��a = b�� �� ��a != b��.
 * �����a �� b ��Сд��ĸ����һ����ͬ������ʾ����ĸ��������
 * ֻ�е����Խ�������������������Ա��������и����ķ���ʱ�ŷ��� true�����򷵻� false ��
 * @author dell
 *
 */
public class EquationsPossibleSolution {

	public static void main(String[] args) {
		String[] array = {"b == a","b != a"};
	}
	
	/**
	 * ���������鼯
	 * ��ÿһ����������ͼ�е�һ���ڵ㣬����ȵĹ�ϵ == ���������������ڵ�ıߣ�
	 * ��ô���ڱ�ʾ��ȹ�ϵ�ĵ�ʽ���̾��д����ԣ������ a == b �� b==c �������� a == c Ҳ������
	 * ������ȵı�������ͬһ����ͨ������
	 * ��ˣ����ǿ���ʹ�ò��鼯��ά��������ͨ�����Ĺ�ϵ��
	 * ���ȣ��������еĵ�ʽ�����첢�鼯��
	 * ͬһ����ʽ�е�������������ͬһ����ͨ��������˽������������кϲ���
	 * Ȼ��������еĲ���ʽ��ͬһ����ʽ�е�����������������ͬһ����ͨ������
	 * ��˶����������ֱ���������ڵ���ͨ�������������������ͬһ����ͨ�����أ������ì�ܣ����� false��
	 * ������������еĲ���ʽû�з���ì�ܣ��򷵻� true.
	 * @param equations
	 * @return
	 */
	public static boolean equationsPossible(String[] equations) {
		int length = equations.length;
		int[] parent = new int[26];
		for(int i = 0; i < 26; i++) {
			parent[i] = i;
		}
		
		for(String str : equations) {
			if(str.charAt(1) == '=') {
				int index1 = str.charAt(0) - 'a';
				int index2 = str.charAt(3) - 'a';
				union(parent,index1,index2);
			}
		}
		
		for(String str : equations) {
			if(str.charAt(1) == '!') {
				int index1 = str.charAt(0)-'a';
				int index2 = str.charAt(3)-'a';
				if(find(parent,index1) == find(parent,index2)) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static void union(int[] parent, int index1, int index2) {
		parent[find(parent,index1)] = find(parent,index2);
	}
	
	public static int find(int[] parent, int index) {
		while(parent[index] != index) {
			parent[index] = parent[parent[index]];
			index = parent[index];
		}
		return index;
	}
}
