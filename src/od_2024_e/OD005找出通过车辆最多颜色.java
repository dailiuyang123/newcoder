package od_2024_e;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class OD005找出通过车辆最多颜色 {
				/**
					* 2024/12/26
					* URL ：
					* 题目描述：
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
								int l = in.nextInt();
								// todo 注意颜色不止3种，坑！！！！
								int[] color = new int[1000];
								ArrayDeque<Integer> deque = new ArrayDeque<>();
								int max = Integer.MIN_VALUE;
								for (int i = 0; i < array.length; i++) {
												if (deque.size() >= l) {
																Integer i1 = deque.removeFirst();
																color[i1]--;
												}
												deque.addLast(array[i]);
												color[array[i]]++;
												max = Math.max(color[array[i]], max);
								}
								System.out.println(max);
				}
				
}
