package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 40. ����ܺ�
 * ����һ������ candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ� target ����ϡ�
 * candidates �е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
 * @author dell
 *
 */

public class CombinationSum2Solution {
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		
	       int len = candidates.length;
	        List<List<Integer>> res = new ArrayList<>();
	        if (len == 0) {
	            return res;
	        }

	        // �ؼ�����
	        Arrays.sort(candidates);

	        Deque<Integer> path = new ArrayDeque<>(len);
	        dfs(candidates, len, 0, target, path, res);
	        return res;
		
	}
	
	
	
	 /**
     * @param candidates ��ѡ����
     * @param len        �������
     * @param begin      �Ӻ�ѡ����� begin λ�ÿ�ʼ����
     * @param target     ��ʾʣ�࣬���ֵһ��ʼ���� target��������Ŀ��˵����"�������֣�����Ŀ����������������"�������
     * @param path       �Ӹ���㵽Ҷ�ӽ���·��
     * @param res
     */
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // ���֦
            if (target - candidates[i] < 0) {
                break;
            }

            // С��֦
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            // ������� ��
            // System.out.println("�ݹ�֮ǰ => " + path + "��ʣ�� = " + (target - candidates[i]));

            // ��ΪԪ�ز������ظ�ʹ�ã�����ݹ鴫����ȥ���� i + 1 ������ i
            dfs(candidates, len, i + 1, target - candidates[i], path, res);

            path.removeLast();

        }
    }



}
