package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1-9 的正整数，并且每种组合中不存在重复的数字
 * @author dell
 *
 */

public class CombinationSum3Solution {
	
    // res存放最终答案
    List<List<Integer>> res = new ArrayList<>();

	
	public List<List<Integer>> combinationSum3(int k , int n){
        // 判断此时是否有解
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
