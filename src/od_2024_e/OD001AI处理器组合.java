package od_2024_e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OD001AI处理器组合 {
				/**
					* 2024/12/11
					* URL ：
					* 题目描述：
					**/
				public static void main(String[] args) {
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								if(s.equals("[]")){
												System.out.println("[]");
												return;
								}
								int[] array = Arrays.stream(s.substring(1, s.length() - 1).split(", ")).mapToInt(Integer::valueOf).sorted().toArray();
								int[] a = Arrays.stream(array).filter(o -> o <= 3).toArray();
								int[] b = Arrays.stream(array).filter(o -> o > 3).toArray();
								int a_len = a.length;
								int b_len = b.length;
								List<int[]> rs = new ArrayList<>();
								if (array.length <= 0) {
												System.out.println("[]");
												return;
								} else {
												int num = in.nextInt();
												if (num == 8) {
																if (array.length == 8) {
																				rs.add(array);
																}
												} else if (num == 4) {
																if (a_len == 4 || b_len == 4) {
																				if (a_len == 4) {
																								rs.add(a);
																				}
																				if (b_len == 4) {
																								rs.add(b);
																				}
																}
												} else if (num == 2) {
																if (a_len == 2 || b_len == 2) {
																				if (a_len == 2) {
																								rs.add(a);
																				}
																				if (b_len == 2) {
																								rs.add(b);
																				}
																} else if (a_len == 4 || b_len == 4) {
																				if (a_len == 4) {
																								for (int i = 0; i < a_len; i++) {
																												for (int j = i + 1; j < a_len; j++) {
																																rs.add(new int[]{a[i], a[j]});
																												}
																								}
																				}
																				if (b_len == 4) {
																								for (int i = 0; i < b_len; i++) {
																												for (int j = i + 1; j < b_len; j++) {
																																rs.add(new int[]{b[i], b[j]});
																												}
																								}
																				}
																				
																} else if (a_len == 3 || b_len == 3) {
																				if (a_len == 3) {
																								for (int i = 0; i < a_len; i++) {
																												for (int j = i + 1; j < a_len; j++) {
																																rs.add(new int[]{a[i], a[j]});
																												}
																								}
																				}
																				if (b_len == 3) {
																								for (int i = 0; i < b_len; i++) {
																												for (int j = i + 1; j < b_len; j++) {
																																rs.add(new int[]{b[i], b[j]});
																												}
																								}
																				}
																}
												} else {
																
																if (a_len == 1 || b_len == 1) {
																				if (a_len == 1) {
																								for (int i : a) {
																												rs.add(new int[]{i});
																								}
																				}
																				if (b_len == 1) {
																								for (int i : b) {
																												rs.add(new int[]{i});
																								}
																				}
																				
																} else if (a_len == 3 || b_len == 3) {
																				if (a_len == 3) {
																								for (int i : a) {
																												rs.add(new int[]{i});
																								}
																				}
																				if (b_len == 3) {
																								for (int i : b) {
																												rs.add(new int[]{i});
																								}
																				}
																				
																} else if (a_len == 2 || b_len == 2) {
																				if (a_len == 2) {
																								for (int i : a) {
																												rs.add(new int[]{i});
																								}
																				}
																				if (b_len == 2) {
																								for (int i : b) {
																												rs.add(new int[]{i});
																								}
																				}
																} else {
																				for (int i : array) {
																								rs.add(new int[]{i});
																				}
																}
												}
								}
								List<List<Integer>> rsp = new ArrayList<>();
								for (int[] r : rs) {
												List<Integer> tmp = new ArrayList<>();
												for (int i : r) {
																tmp.add(i);
												}
												rsp.add(tmp);
								}
								System.out.println(rsp.toString());
								
				}
				
}
