package od_2024_e;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OD003字符串重排序 {
				/**
					* 2024/12/18
					* URL ：
					* 题目描述：
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								String[] split = s.split(" ");
								
								// 内部排序
								split=Arrays.stream(split).map(o -> {
												char[] charArray = o.toCharArray();
												Arrays.sort(charArray);
												return String.valueOf(charArray);
								}).toArray(String[]::new);
								
								HashMap<String, Integer> cnt = new HashMap<>();
								for (String string : split) {
												cnt.put(string, cnt.getOrDefault(string, 0) + 1);
								}
								
								List<String> collect = Arrays.stream(split).sorted((a, b) -> {
												if (cnt.get(a) - cnt.get(b)!=0) {
																return cnt.get(b) - cnt.get(a);
												} else if (a.length() != b.length()) {
																return a.length() - b.length();
												} else {
																return a.compareTo(b);
												}
								}).collect(Collectors.toList());
								
								System.out.println(String.join(" ", collect));
								
				}
				
}
