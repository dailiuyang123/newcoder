package od_2024_e;

import java.util.Arrays;
import java.util.Scanner;

public class OD31云短信平台优惠活动 {
				/**
					* 2025/4/2
					* URL ：
					* 题目描述：题目描述
					* 某云短信厂商为庆祝国庆，推出充值优惠活动。现在给出客户预算和优惠售价序列，求最多可获得的短信总条数。
					* <p>
					* 输入描述
					* 第一行是客户预算 M，其中 0 ≤ M ≤ 10^6。
					* 第二行是售价表 P1, P2, … Pn，其中 1 ≤ n ≤ 100，Pi 表示充值 i 元获得的短信条数，1 ≤ Pi ≤ 1000。
					* 输出描述
					* 输出客户在预算内最多可以获得的短信条数。
					* <p>
					* 示例
					* 示例1
					* 输入：
					* 6
					* 10 20 30 40 60
					* 输出：
					* 70
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								int m = Integer.valueOf(in.nextLine());
								int[] prices = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
								
								// 假设 dp[i] 为 预算i下能获得最大值
								// dp[i]=dp[i-1]+
								int[] dp = new int[m + 1];
								
								for (int i = 0; i < prices.length; i++) {
												
												for (int j = i + 1; j <= m; j++) {
																// price[0]花费1元，price【i】花费 i+1元
																// todo 放/不放两种选择
																//  1.放：dp[j - i - 1] + prices[i] ：当前物品price[i] + 剩余空间
																//  2.不放：dp[j]
																dp[j] = Math.max(dp[j], dp[j - i - 1] + prices[i]);
												}
								}
								System.out.println(dp[m]);
								
				}
}
