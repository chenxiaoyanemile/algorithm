package design;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. ӵ������ǹ��ĺ���
 * ����һ������ candies ��һ������ extraCandies ,���� candies[i] ����� i ������ӵ�е��ǹ���Ŀ��
 * ��ÿһ�����ӣ�����Ƿ����һ�ַ������������ extraCandies ���ǹ������������֮�󣬴˺���ӵ�������ǹ���
 * �������ж������ͬʱӵ�������ǹ���Ŀ��
 * @author dell
 *
 */

public class KidsWithCandiesSolution {
	
	public static void mian(String[] args) {
		int[] candies = {2,3,5,1,3};
		int extraCandies = 3;
		 List<Boolean> result = kidsWithCandies(candies,extraCandies) ;
		 for(int i = 0; i < result.size(); i++) {
			 System.out.println("���"+result.toString());
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
