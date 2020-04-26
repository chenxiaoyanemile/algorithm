

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	/**
	 * 用户 id 和推文（单链表）的对应关系
	 */
	private Map<Integer, Tweet> twitter;
	
	/**
	 * 用户 id 和她关注的用户列表的对应关系
	 */
	private Map<Integer, Set<Integer>> followings;
	
	/**
	 * 全局使用的时间戳字段，用户每发布一条推文之前 +1
	 */
	private static int timestamp = 0;
	
	/**
	 * 合并 k 组推文使用的数据结构（可以在方法了创建使用）声明成全局变量非必需，视个人情况使用
	 */
	private static PriorityQueue<Tweet> maxHeap;
	
	/**
	 * 初始化数据
	 * @author dell
	 *
	 */
	public Twitter() {
		followings = new HashMap<>();
		twitter = new HashMap<>();
		maxHeap = new PriorityQueue<>((o1,o2)->-o1.timestamp + o2.timestamp);
		
	}
	
	/**
	 * 发布一条推文
	 * @author dell
	 *
	 */
	public void postTweet(int userId, int tweetId) {
		timestamp++;
		if(twitter.containsKey(userId)) {
			Tweet oldHead = twitter.get(userId);
			Tweet newHead = new Tweet( tweetId, timestamp);
			newHead.next = oldHead;
			twitter.put(userId, newHead);
			
		}
		else {
			twitter.put(userId,new Tweet(tweetId,timestamp));
		}
	}
	
	/**
	 * 显示10条用户关注的推文
	 * @author dell
	 *
	 */
	public List<Integer> getNewsFeed(int userId){
		//由于是全局使用的，使用之前需要清空
		maxHeap.clear();
		//如果自己发了推文也算上
		if(twitter.containsKey(userId)) {
			maxHeap.offer(twitter.get(userId));
		}
		
		Set<Integer> followingList = followings.get(userId);
		if(followingList != null && followingList.size() > 0) {
			for(Integer followingId : followingList) {
				Tweet tweet = twitter.get(followingId);
				if(tweet != null) {
					maxHeap.offer(tweet);
				}
			}
		}
		List<Integer> res = new ArrayList<>(10);
		int count = 0;
		while(!maxHeap.isEmpty() && count < 10) {
			Tweet head = maxHeap.poll();
			res.add(head.id);
			
			// 这里最好的操作是 replace , 但不支持
			if(head.next != null) {
				maxHeap.offer(head.next);
			}
			count++;
			
		}
		
		return res;
	}
	
	/**
	 * 关注一个人
	 * @author dell
	 *
	 */
	public void follow(int followerId, int followeeId) {
		//被关注人不能是自己
		if(followeeId == followerId) {
			return;
		}
		
		// 获取我自己的关注列表
		Set<Integer> followingList = followings.get(followerId);
		if(followingList == null) {
			Set<Integer> init = new HashSet<>();
			init.add(followeeId);
			followings.put(followerId, init);
		}
		else {
			if(followingList.contains(followeeId)) {
				return;
			}
			followingList.add(followeeId);
		}
	}
	
	/**
	 * 取消关注  
	 * @author dell
	 *
	 */
	public void unfollow(int followerId, int followeeId) {
		if(followeeId == followerId) {
			return;
		}
		
		// 获取我自己的关注列表
		Set<Integer> followingList = followings.get(followerId);
		
		if(followingList == null) {
			return;
		}
		
		// 这里删除之前无需做判断，因为查找是否存在以后，就可以删除，反正删除之前都要查找
		followingList.remove(followeeId);
	}
	
	
	
	/**
	 * 推文类，是一个单链表（节点视角）
	 * @author dell
	 *
	 */
	
	private class Tweet{
		/**
		 * 推文 id
		 */
		private int id;
		/**
		 * 发推文的时间戳
		 */
		private int timestamp;
		private Tweet next;
		
		public Tweet(int id ,int timestamp) {
			this.id= id;
			this.timestamp = timestamp;
			
		}
	}
	
	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		List<Integer> res1 = twitter.getNewsFeed(1);
		System.out.println(res1);
		
		twitter.follow(1, 2);
		
		List<Integer> res2 = twitter.getNewsFeed(2);
		System.out.println(res2);
		
		twitter.unfollow(2, 1);
		
		List<Integer> res3 = twitter.getNewsFeed(2);
		System.out.println(res3);
	}
	


}
