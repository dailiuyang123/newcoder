package od_2024_e;

import java.util.Scanner;

public class OD15相亲派对 {
				/**
					* 2025/3/25
					* URL ：
					* 题目描述：公司开展了一次相亲派对，若男生的颜值和女生的颜值相同，则可以进行配对。
					* <p>
					* 现在给出所有男生的颜值，以及所有女生的颜值，请你计算可以产生多少种配对。
					* <p>
					* 输入描述
					* 第一行输入男生颜值数组。数组长度不大于10000。
					* <p>
					* 第二行输入女生颜值数组。数组长度不大于10000。
					* <p>
					* 注意：颜值最大不超过100000
					* <p>
					* 输出描述
					* 输出可以产生多少种配对。
					* <p>
					* 用例
					* 输入
					* [1, 2, 2, 3, 3, 3, 4, 4]
					* [3, 3, 4, 5, 5]
					* 输出
					* 8
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								String[] boy = s.substring(1, s.length() - 1).split(", ");
								String s1 = in.nextLine();
								String[] girl = s1.substring(1, s1.length() - 1).split(", ");
								int[] yan_boy = new int[100001];
								int[] yan_girl = new int[100001];
								
								for (int i = 0; i < boy.length; i++) {
												yan_boy[Integer.valueOf(boy[i])]++;
								}
								
								for (int i = 0; i < girl.length; i++) {
												yan_girl[Integer.valueOf(girl[i])]++;
								}
								
								long res = 0;
								for (int i = 0; i < 100000; i++) {
												if (yan_boy[i] > 0 && yan_girl[i] > 0) {
																int min = Math.min(yan_boy[i], yan_girl[i]);
																int max = Math.max(yan_boy[i], yan_girl[i]);
																int tmp = 1;
																if (min != max) {
																				for (int j = 0; j < min; j++) {
																								tmp = tmp * (max - j);
																				}
																} else {
																				tmp = max * min;
																}
																
																res += tmp;
												}
								}
								
								System.out.println(res);
								
				}
				
}
