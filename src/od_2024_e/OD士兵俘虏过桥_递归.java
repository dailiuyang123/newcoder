package od_2024_e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OD士兵俘虏过桥_递归 {
				static List<Integer> res = new ArrayList<>();
				
				/**
					* 2025/3/24
					* URL ：
					* 题目描述：题目描述
					* 一名指挥官带领 x 名新兵押送 y 名俘虏去往监狱。
					* <p>
					* 途中遇到了一座危桥，若想要通过这座危桥，则必须由熟悉危桥情况的指挥官带领。而危桥上除了引路的指挥官外，最多还能容 z 个人同时行走。
					* <p>
					* 由于俘虏不惧怕新兵，只惧怕指挥官，因此指挥官在时，俘虏不会逃跑；但若是指挥官离开，且此时新兵数量不大于俘虏数量，则俘虏会挟持新兵逃跑。
					* <p>
					* 俘虏需要挟持新兵才能逃跑，若俘虏独自逃跑，则指挥官会直接开枪射杀。
					* <p>
					* 请你计算出指挥官至少需要往返几次，才能保证在俘虏不逃跑的情况下，让所有士兵俘虏过桥。
					* <p>
					* 输入描述
					* 第一行输入士兵数量 x
					* <p>
					* 第二行输入俘虏数量 y
					* <p>
					* 第三行输入 z，表示桥上最多 z 人同时行走，超出了桥就会断。
					* <p>
					* 输出描述
					* 输出指挥官至少往返的次数（往+返算一次），若无论如何规划，都会有俘虏逃跑，则输出 0。
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								int x = in.nextInt();
								int y = in.nextInt();
								int z = in.nextInt();
								
								dfs(x, y, z, 0, 0, 0);
								
								if (res.isEmpty()) {
												System.out.println(0);
								} else {
												System.out.println(Collections.min(res));
								}
				}
				
				public static void dfs(int left_soldier, int left_capture, int capacity, int right_soldier, int right_capture, int count) {
								if (left_soldier == 0 && left_capture == 0) {
												res.add(count);
												return;
								}
								
								if (left_soldier + left_capture <= capacity) {
												res.add(count + 1);
												return;
								}
								
								for (int i = 0; i <= Math.min(left_soldier, capacity); i++) {
												for (int j = 0; j <= Math.min(left_capture, capacity); j++) {
																// 跳过空载
																if (i + j == 0) {
																				continue;
																}
																// 超载
																if (i + j > capacity) {
																				break;
																}
																// todo 说明士兵运少了。
																if (left_soldier - i <= left_capture - j && left_soldier - i != 0) {
																				continue;
																}
																// 对岸俘虏大于等于士兵 && 对岸有士兵（没有士兵，则不可逃跑，会被击毙！） == 俘虏挟持士兵逃跑
																if (right_soldier + i <= right_capture + j && right_soldier + i != 0) {
																				break;
																}
																// 对岸没有士兵，但是对岸逃兵数量大于桥容量，下一次全运士兵也无法超过俘虏！
																if (right_soldier + i == 0 && right_capture + j >= capacity) {
																				break;
																}
																dfs(left_soldier - i, left_capture - j, capacity, right_soldier + i, right_capture + j, count + 1);

												}
								}
								
				}
				
}
