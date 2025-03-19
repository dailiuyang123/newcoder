package od_2024_e.回溯;

import java.util.Arrays;
import java.util.Scanner;

public class 平衡天使游戏_球桶问题 {
				static int[] jobs;
				
				/**
					* 2025/3/19
					* URL ：
					* 题目描述：题目描述
					* 《平衡天使(Bamboleo)》是一款好玩的游戏，该游戏会在一根木柱上放置一个松木球，然后在松木球上放置一个圆盘，你需要将多个不同重量的木块放到圆盘上，若圆盘不倾倒，则游戏成功。
					* <p>
					* 根据力学知识，若所有木块可以分为重量相同的多个堆，然后将多个堆均匀地排布在圆盘上，则圆盘就可以平衡，并且分的堆数越多，则平衡越稳定。
					* <p>
					* 请你输出所有木块最多可以分为重量相同的几个堆。
					* <p>
					* 输入描述
					* 输入一个数组，数组元素是各个木块的重量。格式请见用例。数组长度最大30。
					* <p>
					* 输出描述
					* 输出所有木块最多可以平分几个重量相同的堆。
					* <p>
					* 输入
					* [1, 1, 1, 1, 2, 2, 2, 2]
					* 输出
					* 6
					**/
				public static void main(String[] args) {
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								jobs = Arrays.stream(s.substring(1, s.length() - 1).split(", ")).mapToInt(Integer::valueOf).sorted().toArray();
//								jobs = new int[]{4, 2, 1, 1};
								int sum = Arrays.stream(jobs).sum();
								
								for (int i = jobs.length; i >= 1; i--) {
												if (sum % i == 0) {
																int capacity = sum / i;
																if (dfs(0, capacity, new int[i])) {
																				System.out.println(i);
																				return;
																}
												}
								}
								
				}
				
				// 正确答案：
				// 循环桶，将每个球找到最合适的桶里
				public static boolean dfs(int curr, int capacity, int[] buckets) {
							 // 当前球的下标 == 球数组，说明已经放完。
								if (curr == jobs.length) {
												return true;
								}
								
								int job = jobs[curr];
								// ToDo 遍历桶，如果放不下，自动循环到一个桶。
								for (int i = 0; i < buckets.length; i++) {
												if (i > 0 && buckets[i] == buckets[i - 1]) {
																continue;
												}
												
												if (buckets[i] + job <= capacity) {
																buckets[i] += job;
																if (dfs(curr + 1, capacity, buckets)) {
																				return true;
																}
																// 回退：当前这个桶不放这个球，循环找下一个桶
																buckets[i] -= job;
												}
								}
								return false;
				}
				
				
				// 因为：curr一直累加，导致没法回溯，只能走到头，导致有问题。
				// 不能AC：{4, 2, 1, 1};
				public static boolean dfs(int curr, boolean[] used, int capacity, int[] bus) {
								if (curr == bus.length) {
												return true;
								}
								
								for (int i = 0; i < jobs.length; i++) {
												if (used[i]) {
																continue;
												}
												
												int job = jobs[i];
												if (bus[curr] + job <= capacity) {
																bus[curr] += job;
																used[i] = true;
																
																// 因为：curr一直累加，导致没法回溯，只能走到头，导致有问题。
																// 不能AC：{4, 2, 1, 1};
																if (bus[curr] == capacity) {
																				curr++;
																}
																if (dfs(curr, used, capacity, bus)) {
																				return true;
																}
																bus[curr] -= job;
																used[i] = false;
												}
								}
								
								return false;
				}
				
}
