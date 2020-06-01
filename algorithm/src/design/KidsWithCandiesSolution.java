package design;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 * 给你一个数组 candies 和一个整数 extraCandies ,其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子拥有最多的糖果。
 * （允许有多个孩子同时拥有最多的糖果数目）
 * @author dell
 *
 */

public class KidsWithCandiesSolution {
	
	public static void mian(String[] args) {
		int[] candies = {2,3,5,1,3};
		int extraCandies = 3;
		 List<Boolean> result = kidsWithCandies(candies,extraCandies) ;
		 for(int i = 0; i < result.size(); i++) {
			 System.out.println("结果"+result.toString());
		 }
		
	}
	
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
		 List<Boolean> result = new ArrayList<>();
		 
		 int max = candies[0];
		 for(int i = 0; i < candies.length; i++) {
			 if(candies[i] > max) {
				 max = candies[i];
			 }
		 }
		 
		 for(int j = 0; j < candies.length; j++) {
			 if(candies[j] + extraCandies >= max ) {
				 result.add(true);
			 }
			 else {
				 result.add(false);
			 }
		 }	
		return result;		
	}
	
	public static List<Boolean> kidsWithCandies1(int[] candies, int extraCandies){
		 List<Boolean> result = new ArrayList<Boolean>();	 
		 int max = candies[0];
		 for(int candy : candies) {
			 max = Math.max(candy, max);
		 }
		 extraCandies = max - extraCandies;
		 for(int candy : candies) {
			 result.add(candy >= extraCandies);
		 }	 
		return result;		
		
	}

}
