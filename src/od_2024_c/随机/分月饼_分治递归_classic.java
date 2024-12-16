package od_2024_c.随机;

import java.util.Scanner;

public class 分月饼_分治递归_classic {
				/**
					* 2024/4/27
					* URL ：https://fcqian.blog.csdn.net/article/details/134629018
					* 题目描述：分月饼 题目描述
					* 中秋节，公司分月饼，m 个员工，买了 n 个月饼，m ≤ n，每个员工至少分 1 个月饼，但可以分多个，
					* <p>
					* 单人分到最多月饼的个数是 Max1 ，单人分到第二多月饼个数是 Max2 ，Max1 - Max2 ≤ 3 ，
					* 单人分到第 n - 1 多月饼个数是 Max(n-1)，单人分到第n多月饼个数是 Max(n) ，Max(n-1) – Max(n) ≤ 3,
					* 问有多少种分月饼的方法？
					* <p>
					* 输入描述
					* 每一行输入m n，表示m个员工，n个月饼，m ≤ n
					* <p>
					* 输出描述
					* 输出有多少种月饼分法
					**/
				static int m;
				
				static int n;
				
				static int res = 0;
				
				public static void main(String[] args) {
								Scanner in = new Scanner(System.in);
								m = in.nextInt();
								n = in.nextInt();
								solution(0, 1, n / m, n);
								System.out.println(res);
								
				}
				
				public static void solution(int level, int min, int max, int remain) {
								
								if (level == m - 1) {
												if (min - remain <= 3) {
																res++;
												}
												return;
								}
								
								for (int i = min; i <= max; i++) {
												remain -= i;
												solution(level + 1, i, Math.min(i + 3, remain / (m - level - 1)), remain);
												remain += i;
								}
								
				}
				
}
