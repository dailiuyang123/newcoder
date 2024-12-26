package od_2024_e;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OD002寻找链表的中间节点 {
				/**
					* 2024/12/18
					* URL ：
					* 题目描述：
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								int f_addr = in.nextInt();
								int size = in.nextInt();
								
								
								int[][] nodes = new int[size][3];
								
								
								for (int i = 0; i < size; i++) {
												nodes[i][0] = in.nextInt();
												nodes[i][1] = in.nextInt();
												nodes[i][2] = in.nextInt();
								}
								
								
								List<Integer> list = new ArrayList<>();
								
								while (true) {
												for (int[] node : nodes) {
																if (node[0] == f_addr) {
																				f_addr = node[2];
																				list.add(node[1]);
																				break;
																}
												}
												if (f_addr == -1) {
																break;
												}
								}
								
								System.out.println(list.get(list.size() / 2));
								
				}
}
