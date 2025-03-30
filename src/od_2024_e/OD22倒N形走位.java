package od_2024_e;

import java.util.Scanner;

public class OD22倒N形走位 {
				/**
					* 2025/3/30
					* URL ：
					* 题目描述：有一个 n 行不定列的矩阵，请你从矩阵左上角位置，按照倒倒 N 形走位，依次填入 1 ~ x 数字。比如对于一个 3 行不定列矩阵，依次填入 1 ~ 8 数字的结果如下：
					* <p>
					* 1 6 7
					* 2 5 8
					* 3 4
					* <p>
					* 输入描述
					* 输入一行，两个正整数 n 和 x，其中 n 不大于 1000。
					* <p>
					* 输出描述
					* 输出结果矩阵，格式见用例
					* <p>
					* 用例
					* 输入
					* 3 8
					* 输出
					* 1 6 7
					* 2 5 8
					* 3 4
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								int n = in.nextInt();
								int x = in.nextInt();
								
								StringBuilder[] sbs = new StringBuilder[n];
								int index = 0;
								boolean flag = true;
								for (int i = 1; i <= x; i++) {
												if (sbs[index] == null) {
																sbs[index] = new StringBuilder();
												}
												sbs[index].append(i).append(" ");
												//计算当前行号下标
												if (i % n == 0) {
																flag = !flag;
												} else {
																index += flag ? 1 : -1;
												}
								}
								
								for (int i = 0; i < sbs.length; i++) {
												System.out.println(sbs[i].toString().trim());
								}
								
				}
				
}
