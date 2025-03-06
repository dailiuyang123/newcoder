package od_2024_e;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class OD349游戏分组 {
				static int res = Integer.MAX_VALUE;
				static int sum = 0;
				
				/**
					* 2025/3/6
					* URL ：
					* 题目描述：
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::valueOf).toArray();
								sum = Arrays.stream(nums).sum();
//								dfs(0, nums, new boolean[nums.length], new LinkedList<>());
								dfs(0,0,nums,new LinkedList<>());
								System.out.println(res);
				}
				
				/**
					* 　全排列
					*/
				public static void dfs(int score, int[] nums, boolean[] used, LinkedList<Integer> path) {
								if (path.size() >= 5) {
												res = Math.min(res, Math.abs(sum - 2 * score));
												return;
								}
								
								for (int i = 0; i < nums.length; i++) {
												if (used[i]) {
																continue;
												}
												path.addLast(nums[i]);
												score += nums[i];
												used[i] = true;
												dfs(score, nums, used, path);
												path.removeLast();
												score -= nums[i];
												used[i] = false;
								}
								
				}
				
				/**
					* 组合
					*/
				public static void dfs(int index, int score, int[] nums, LinkedList<Integer> path) {
								if (path.size() >= 5) {
												res = Math.min(res, Math.abs(sum - 2 * score));
												System.out.println(path.toString());
												return;
								}
								
								for (int i = index; i < nums.length; i++) {
												path.addLast(nums[i]);
												score += nums[i];
												dfs(i + 1, score, nums, path);
												path.removeLast();
												score -= nums[i];
								}
								
				}
				
				
}
