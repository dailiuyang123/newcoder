package od_2024_e.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 智能成绩表 {
				/**
					* 2024/11/12
					* URL ： https://blog.csdn.net/qfc_128220/article/details/134387126
					* 题目描述：
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								
								int n = in.nextInt();
								int m = in.nextInt();
								in.nextLine();
								
								int[][] a = new int[n][m + 1];
								
								HashMap<String, Integer> km = new HashMap<>();
								HashMap<Integer, String> stu = new HashMap<>();
								
								// 科目坐标
								String[] split = in.nextLine().split(" ");
								for (int i = 0; i < split.length; i++) {
												km.put(split[i], i);
								}
								
								for (int i = 0; i < n; i++) {
												String st = in.next();
												stu.put(i, st);
												int total = 0;
												for (int j = 0; j < m; j++) {
																a[i][j] = in.nextInt();
																total += a[i][j];
												}
												a[i][m] = total;
								}
								
								String next = in.next();
								String[][] total = new String[n][2];
								if (km.containsKey(next)) {
												Integer i = km.get(next);
												for (int j = 0; j < n; j++) {
																total[j][0] = stu.get(j);
																total[j][1] = a[j][i] + "";
												}
								} else {
												for (int j = 0; j < n; j++) {
																total[j][0] = stu.get(j);
																total[j][1] = a[j][m] + "";
												}
								}
								
								Arrays.stream(total).sorted((c,d)->{
												if (!c[1].equals(d[1])){
																return -(Integer.valueOf(c[1])-Integer.valueOf(d[1]));
												}else {
														return c[0].compareTo(d[0]);
												}
								}).forEach(a1-> System.out.println(a1[0]));
				}
}
