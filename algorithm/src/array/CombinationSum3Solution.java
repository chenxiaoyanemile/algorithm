package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. ����ܺ� 
 * �ҳ��������֮��Ϊ n �� k ��������ϡ������ֻ������ 1-9 ��������������ÿ������в������ظ�������
 * @author dell
 *
 */

public class CombinationSum3Solution {
	
    // res������մ�
    List<List<Integer>> res = new ArrayList<>();

	
	public List<List<Integer>> combinationSum3(int k , int n){
        // �жϴ�ʱ�Ƿ��н�
		create(k,n,0,0,new ArrayList<>());
        return res;	
	}
	
	public void create(int k,int n,int start,int sum,List<Integer> flag){
        if (k==0&&sum==n){
            res.add(new ArrayList<>(flag));
        }else if (sum>n){
            return;
        }else{
            for(int i=start;i<9;i++){
                sum += i+1;
                flag.add(i+1);
                create(k-1,n,i+1,sum,flag);
                flag.remove(flag.size()-1);
                sum = sum -i -1;
            }
        }
    }

}
