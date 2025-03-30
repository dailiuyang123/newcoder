package od_2024_e;

import java.util.Arrays;
import java.util.Scanner;

public class OD17数组的平衡点2 {
				/**
					* 2025/3/27
					* URL ：
					* 题目描述：给定一个长度为 n 的数组 nums，若其中存在某个位置 index，使得 [0, index - 1] 范围的元素之积 等于 [index + 1, n - 1] 范围的元素之积，则称 index 位置是数组 nums 的平衡点。
					* <p>
					* 请你找出数组 nums 的平衡点位置，若存在多个平衡点位置，则输出最后一个，若不存在平衡点位置，则输出 null。
					* <p>
					* 输入描述
					* 输入一个数组 nums，格式请见用例。数组长度不大于10000。
					* <p>
					* 注意：用例保证乘积结果不会超出 long 范围。不用担心整型溢出问题。数组元素都为 int 类型。
					* <p>
					* 输出描述
					* 输出数组 nums 的平衡点位置，若存在多个平衡点位置，则输出最后一个，若不存在平衡点位置，则输出 null。
					* <p>
					* 用例
					* 输入
					* [1, 1, 1, 1, 1]
					* [1, 2, 3, 2, 1]
					* [1, 2, 3, 2, 2]
					* 输出
					* 4
					* 说明
					* 若平衡点位置 index = 0，则其左侧范围元素为空，此时认为左侧范围元素之积为1。
					* <p>
					* 若平衡点位置 index = n-1，则其右侧范围元素为空，此时认为右侧范围元素之积为1。
					**/
				public static void main(String[] args) {
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								int[] nums = Arrays.stream(s.substring(1, s.length() - 1).split(", ")).mapToInt(Integer::valueOf).toArray();
								long[] mut_l = new long[nums.length + 1];
								mut_l[0] = 1;
								long mut = 1;
								for (int i = 0; i < nums.length; i++) {
												int num = nums[i];
												mut_l[i + 1] = mut_l[i] * num;
												mut *= num;
								}
								
								// todo  使用前缀和思想，算出[0,i]下标的乘积，存放在[i+1]下标的数组内。
								for (int i = nums.length - 1; i >= 0; i--) {
												int curr = nums[i];
												long sqrt = mut / curr;
												// 成立
												if(mut_l[i]*mut_l[i]==sqrt){
																System.out.println(i);
																return;
												}
								}
								
								System.out.println("null");
								
				}
}
