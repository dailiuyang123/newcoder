package od_2024_e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OD16最远距离 {
				/**
					* 2025/3/27
					* URL ：
					* 题目描述：题目描述
					* 给定一个数组，请你找出数组中相同元素之间的最远距离。若数组中不存在相同元素，则输出 null。
					* <p>
					* 输入描述
					* 输入一个数组，数组长度不超过 10000。格式请见用例。
					* <p>
					* 输出描述
					* 输出数组中相同元素的最远距离。
					* <p>
					* 用例
					* 输入
					* [1, 2, 1, 2, 1, 2, 1, 2]
					* 输出
					* 5
					* 说明
					* 索引0的元素和索引6的元素相同，距离 6。
					* <p>
					* 索引1的元素和索引7的元素相同，距离 6。
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								int[] nums = Arrays.stream(s.substring(1, s.length() - 1).split(", ")).mapToInt(Integer::valueOf).toArray();
								int max = 0;
								List<Integer> cache = new ArrayList<>();
								for (int i = 0; i < nums.length; i++) {
												int curr = nums[i];
												if (!cache.contains(curr)) {
																for (int j = nums.length - 1; j > i; j--) {
																				if (nums[j] == curr) {
																								max = Math.max(j - i, max);
																								cache.add(curr);
																				}
																}
												}
								}
								System.out.println(max == 0 ? "null" : max);
				}
				
}
