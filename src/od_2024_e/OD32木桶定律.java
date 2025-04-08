package od_2024_e;

import java.util.PriorityQueue;
import java.util.Scanner;

public class OD32木桶定律 {
				static long res = 0;
				
				/**
					* 2025/4/8
					* URL ：
					* 题目描述：
					* 一只木桶由 n 块木板箍成，n 块木板的长度可能并不相同，而一只木桶盛水量的多少，取决于桶壁上最短的那块木板。
					* <p>
					* 现在有一块长度 m 的木料，你可以将其分割为任意多份，每份长度为正整数即可。分割出来的木料可以用于增加木桶短板的长度。
					* <p>
					* 为了保证木桶可以盛最多的水，请你计算出补充了木料后，木桶的最短板长度。
					* <p>
					* 输入描述
					* 第一行输入两个整数 n，m，以空格分隔。
					* <p>
					* 第二行输入箍木桶的 n 块木板的长度，以空格分隔。
					* <p>
					* 输出描述
					* 输出补充木料后，木桶的最短板长度。
					* <p>
					* 用例1
					* 输入
					* 2 19
					* 5 4
					* 输出
					* 14
					**/
				public static void main(String[] args) {
								Scanner in = new Scanner(System.in);
								int n = in.nextInt();
								int m = in.nextInt();
								
								PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
								for (int i = 0; i < n; i++) {
												long c = in.nextLong();
												priorityQueue.offer(c);
								}
								// 只有1根木板
								if (n == 1) {
												System.out.println(priorityQueue.peek() + m);
												return;
								}
								while (m > 0) {
												long min = priorityQueue.poll();
												long secend_min = priorityQueue.peek();
												if (min != secend_min) {
																priorityQueue.offer(secend_min);
																m -= secend_min - min;
												} else {
																priorityQueue.offer(min + 1);
																m--;
												}
								}
								System.out.println(priorityQueue.peek());
				}
				
				
				/**
					* 1. 找出最短模板
					* 2. 将将最短模板，补平至第二度短木板
					* 3. 重复1，2步，直到木料m为0结束
					* 递归解决- todo  栈溢出:深层方法嵌套：某些算法（如复杂递归）需要极深的栈空间。
					*/
				public static void solution(int m, PriorityQueue<Long> priorityQueue) {
								if (m == 0) {
												res = priorityQueue.peek();
												return;
								}
								
								long min = priorityQueue.poll();
								long secend_min = priorityQueue.peek();
								if (min == secend_min) {
												m--;
												min++;
												priorityQueue.offer(min);
								} else {
												m -= secend_min - min;
												priorityQueue.offer(secend_min);
								}
								solution(m, priorityQueue);
				}
				
				
}
