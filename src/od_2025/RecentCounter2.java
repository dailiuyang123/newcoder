package od_2025;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter2 {
				/**
					* 2025/9/1
					* URL ：
					* 题目描述：
					**/
				
				// 使用队列存储请求的时间戳
				private Queue<Integer> requests;
				
				// 时间窗口大小，3000毫秒
				private static final int WINDOW_SIZE = 3000;
				
				public RecentCounter2() {
								// 初始化队列，使用LinkedList实现
								requests = new LinkedList<>();
				}
				
				/**
					* 记录新请求的时间戳，并返回过去3000毫秒内的请求数
					* @param t 新请求的时间戳
					* @return 时间范围内的请求数
					*/
				public int ping(int t) {
								// 将当前请求的时间戳加入队列
								requests.add(t);
								
								// 移除所有超出时间窗口的请求（早于t - 3000的请求）
								while (requests.peek() < t - WINDOW_SIZE) {
												requests.poll();
								}
								
								// 队列中剩余的元素数量就是时间范围内的请求数
								return requests.size();
				}
				
				
}
