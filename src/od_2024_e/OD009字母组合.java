package od_2024_e;

import java.util.*;

public class OD009字母组合 {
				/**
					* 2025/1/6
					* URL ：
					* 题目描述：
					**/
				
				static Map<Character, String> map = new HashMap<>();
				
				static ArrayList<String> res = new ArrayList<>();
				
				static String ux;
				
				public static void main(String[] args) {
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								ux = in.nextLine();
								
								map.put('0', "abc");
								map.put('1', "def");
								map.put('2', "ghi");
								map.put('3', "jkl");
								map.put('4', "mno");
								map.put('5', "pqr");
								map.put('6', "st");
								map.put('7', "uv");
								map.put('8', "wx");
								map.put('9', "yz");
								
								
								dfs(s, 0, new boolean[s.length()], new ArrayDeque<Character>());
								StringBuilder sb = new StringBuilder();
								for (String re : res) {
												sb.append(re).append(",");
								}
								System.out.println(sb.toString());
				}
				
				public static void dfs(String s, int index, boolean[] used, ArrayDeque<Character> path) {
								if (index == s.length()) {
												StringBuilder sb = new StringBuilder();
												for (Character c : path) {
																sb.append(c);
												}
												if (!sb.toString().contains(ux)) {
																res.add(sb.toString());
												}
												return;
								}
								
								
								String val = map.get(s.charAt(index));
								for (int i = 0; i < val.length(); i++) {
												if (used[index]) {
																continue;
												}
												path.addLast(val.charAt(i));
												used[index] = true;
												index++;
												dfs(s, index, used, path);
												path.removeLast();
												index--;
												used[index] = false;
								}
								
				}
				
				
}
