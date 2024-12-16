package od_2024_e.base;

import java.util.HashMap;
import java.util.Scanner;

public class 字符统计及重排 {
				/**
					* 2024/11/13
					* URL ：https://blog.csdn.net/qfc_128220/article/details/127418440
					* 题目描述：
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								
								String s = in.nextLine();
								
								HashMap<Character, Integer> maps = new HashMap<>();
								
								for (int i = 0; i < s.length(); i++) {
												char c = s.charAt(i);
												maps.put(c, maps.getOrDefault(c, 0) + 1);
								}
								
								maps.keySet().stream().sorted((a, b) -> {
												if (maps.get(a) != maps.get(b)) {
																return maps.get(b) - maps.get(a);
												} else {
																if ((Character.isLowerCase(a) && Character.isLowerCase(b)) || (Character.isUpperCase(a) && Character.isUpperCase(b))) {
																				return a.compareTo(b);
																} else {
																				return Character.isUpperCase(a) ? 1 : -1;
																}
												}
								}).forEach(o -> {
												System.out.println(o + ":" + maps.get(o) + ";");
								});
								
				}
				
}
