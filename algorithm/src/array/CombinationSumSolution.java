package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSumSolution {
	
	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target){
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;

	}
	
	   /**
     * @param candidates ��ѡ����
     * @param begin      �������
     * @param len        ����������� candidates ������ԣ����Բ���
     * @param target     ÿ��ȥһ��Ԫ�أ�Ŀ��ֵ��С
     * @param path       �Ӹ���㵽Ҷ�ӽ���·������һ��ջ
     * @param res        ������б�
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target Ϊ������ 0 ��ʱ���ٲ����µĺ��ӽ��
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // �ص��������� begin ��ʼ����������
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // ע�⣺����ÿһ��Ԫ�ؿ����ظ�ʹ�ã���һ�������������Ȼ�� i������ǳ�����Ū��
            dfs(candidates, i, len, target - candidates[i], path, res);

            // ״̬����
            path.removeLast();
        }
    }


}
