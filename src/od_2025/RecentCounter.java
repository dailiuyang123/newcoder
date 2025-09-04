package od_2025;

import java.util.LinkedList;

public class RecentCounter {
				/**
					* 2025/9/1
					* URL ：
					* 题目描述：
					**/
				
				private int count;
				
				private int[] queue;
				
				
				private LinkedList<Integer> stack;
				
				public RecentCounter() {
								count = 0;
								queue = new int[100000];
								stack = new LinkedList<>();
				}
				
				public static void main(String[] args) {
								RecentCounter recentCounter = new RecentCounter();
								int[] arr = {1, 100, 3001, 3002};
								for (int i = 0; i < arr.length; i++) {
												int ping = recentCounter.ping(arr[i]);
												System.out.println(ping);
								}
				}
				
				public int ping(int t) {
								int cnt = 1;
								if (!stack.isEmpty()) {
												cnt += stack.pop();
								}
								queue[t] = cnt;
								stack.push(cnt);
								
								return t <= 3001 ? cnt : (queue[t] - queue[t - 3001]);
				}
				
				
}
