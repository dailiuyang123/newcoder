package od_2024_c.随机;

import java.util.Scanner;

public class 分披萨_分治递归 {
				/**
					* 2024/4/27
					* URL ：
					* 题目描述："吃货"和"馋嘴"两人到披萨店点了一份铁盘（圆形）披萨，并嘱咐店员将披萨按放射状切成大小相同的偶数个小块。但是粗心的服务员将披萨切成了每块大小都完全不同奇数块，且肉眼能分辨出大小。
					* <p>
					* 由于两人都想吃到最多的披萨，他们商量了一个他们认为公平的分法：从"吃货"开始，轮流取披萨。除了第一块披萨可以任意选取外，其他都必须从缺口开始选。
					* <p>
					* 他俩选披萨的思路不同。"馋嘴"每次都会选最大块的披萨，而且"吃货"知道"馋嘴"的想法。
					* <p>
					* 已知披萨小块的数量以及每块的大小，求"吃货"能分得的最大的披萨大小的总和。
					* <p>
					* 输入描述
					* 第 1 行为一个正整数奇数 N，表示披萨小块数量。
					* <p>
					* 3 ≤ N < 500
					* 接下来的第 2 行到第 N + 1 行（共 N 行），每行为一个正整数，表示第 i 块披萨的大小
					* <p>
					* 1 ≤ i ≤ N
					* 披萨小块从某一块开始，按照一个方向次序顺序编号为 1 ~ N
					* <p>
					* 每块披萨的大小范围为 [1, 2147483647]
					* 输出描述
					* "吃货"能分得到的最大的披萨大小的总和。
					**/
				
				static int max = 0;
				
				static int[] nums;
				static int n;
				
				public static void main(String[] args) {
								Scanner in = new Scanner(System.in);
								n = in.nextInt();
								nums = new int[n];
								for (int i = 0; i < n; i++) {
												nums[i] = in.nextInt();
								}
								
								for (int i = 0; i < n; i++) {
												int res = nums[i];
												max = Math.max(max, maxRs(checkIndex(i - 1), checkIndex(i + 1), res));
								}
								System.out.println(max);
								
				}
				
				public static int maxRs(int l, int r, int res) {
								
								// 馋嘴永远挑选最大的一块
								if (nums[l] > nums[r]) {
												l = checkIndex(l - 1);
								} else {
												r = checkIndex(r + 1);
								}
								
								//ToDo 吃货选择 1.剩余最后一块，么得选
								if (l == r) {
												return res += nums[l];
								} else {
												return Math.max(maxRs(checkIndex(l - 1), r, res + nums[l]), maxRs(l, checkIndex(r + 1), res + nums[r]));
								}
								
				}
				
				public static int checkIndex(int index) {
								if (index < 0) {
												return n + index;
								} else if (index >= n) {
												return index - n;
								} else {
												return index;
								}
				}
				
}
