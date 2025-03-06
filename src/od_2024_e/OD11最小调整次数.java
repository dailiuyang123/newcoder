package od_2024_e;

import java.util.LinkedList;
import java.util.Scanner;

public class OD11最小调整次数 {
				/**
					* 2025/3/3
					* URL ：
					* 题目描述：
					**/
				public static void main2(String[] args) {
								
								// 所有数据均合法：说明尾部数据为递增，不需要考虑非递增场景
								
								// add
								// tail 不需要调整顺序
								// head
								//     1. 当前队列是否有数据	 需要调整
								//     2. 当前队列没有数据   也不需要调整
								
								int res = 0;
								LinkedList<Integer> queue = new LinkedList<>();
								
								
								Scanner in = new Scanner(System.in);
								Integer n = Integer.valueOf(in.nextLine());
								for (int i = 0; i < 2 * n; i++) {
												String s = in.nextLine();
												if (s.startsWith("head")) {
																if (!queue.isEmpty()) {
																				queue.removeFirst();
																				res++;
																}
																queue.addFirst(Integer.valueOf(s.split(" ")[2]));
												} else if (s.startsWith("tail")) {
																queue.addLast(Integer.valueOf(s.split(" ")[2]));
												} else {
																if (!queue.isEmpty()) {
																				queue.removeFirst();
																}
												}
								}
								
								System.out.println(res);
								
				}
				
				
				public static void main(String[] args) {
								
								// 所有数据均合法：说明尾部数据为递增，不需要考虑非递增场景
								
								// add
								// tail 不需要调整顺序
								// head
								//     1. 当前队列是否有数据	 需要调整
								//     2. 当前队列没有数据   也不需要调整
								
								int res = 0;
								LinkedList<Integer> queue = new LinkedList<>();
								boolean flag = false;
								
								Scanner in = new Scanner(System.in);
								Integer n = Integer.valueOf(in.nextLine());
								for (int i = 0; i < 2 * n; i++) {
												String s = in.nextLine();
												if (s.startsWith("head")) {
																if (!queue.isEmpty()) {
																				flag = true;
																}
																queue.addFirst(Integer.valueOf(s.split(" ")[2]));
												} else if (s.startsWith("tail")) {
																queue.addLast(Integer.valueOf(s.split(" ")[2]));
												} else {
																if (flag) {
																				res++;
																				flag=false;
																}
																queue.removeFirst();
												}
								}
								
								System.out.println(res);
								
				}
}
