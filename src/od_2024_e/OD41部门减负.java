package od_2024_e;

import java.util.Arrays;
import java.util.Scanner;

public class OD41部门减负 {
				/**
					* 2025/4/14
					* URL ：
					* 题目描述：公司最近开展了减负运动，要求各部门每月的总需求数不能超出 sum 个。
					* <p>
					* 若某部门当月总需求数不超过 sum 个，则不需要减负。
					* 若某部门当月总需求数超出 sum 个，则需要设定一个 limit 阈值
					* 若开发人员手中需求数量超出 limit，则需要降到 limit 个。
					* 若开发人员手中需求数量不超过 limit，则不需要减负。
					* 部门领导为了不被削减太多需求，请你找到一个最大 limit 阈值，保证每个开发人员手中需求数量不超出 limit 的同时，所有开发人员手中需求总数不超过 sum。
					* <p>
					* 输入描述
					* 第一行输入 sum，sum 最大不超过 100000。
					* <p>
					* 第二行输入部门开发人员手中需求数量数组 count，每个开发手中需求数量不超过 100。
					* <p>
					* 输出描述
					* 输出一个最大的 limit 阈值。
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								int sum = in.nextInt();
								in.nextLine();
								String s = in.nextLine();
								int[] nums = Arrays.stream(s.substring(1, s.length() - 1).split(", ")).mapToInt(Integer::valueOf).sorted().toArray();
								int length = nums.length;
								int limit = 0;
								
								int pre = 0;
								for (int i = 0; i < nums.length; i++) {
												pre += nums[i];
												if ((length - i - 1) * nums[i] + pre < sum) {
																limit = Math.max(nums[i], limit);
												} else if ((length - i - 1) * nums[i] + pre > sum) {
																pre -= nums[i];
																int limits = erfen(nums[i - 1], nums[i], sum - pre, (length - i));
																limit = Math.max(limits, limit);
																break;
												} else {
																break;
												}
								}
								
								System.out.println(limit);
				}
				
				public static int erfen(int l, int r, int target, int length) {
								
								while (l <= r) {
												int mid = l + (r - l) / 2;
												if (mid * length == target) {
																return mid;
												} else if (mid * length > target) {
																r = mid - 1;
												} else {
																l = mid + 1;
												}
								}
								return 0;
				}
				
				
}
