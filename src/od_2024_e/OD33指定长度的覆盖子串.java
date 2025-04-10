package od_2024_e;

import java.util.HashMap;
import java.util.Scanner;

public class OD33指定长度的覆盖子串 {
				/**
					* 2025/4/10
					* URL ：
					* 题目描述：请你从字符串 s 中找到一个长度为 len 的子串 sub，子串 sub 需要覆盖另一个字符串 t。
					* <p>
					* 若 t 中任意字符都满足：sub 中该字符数量 >= t 中该字符数量，则称 sub 可以覆盖 t。
					* <p>
					* 比如 sub = "abcc" 可以覆盖 t = "abc"，但是无法覆盖 t = "abbc"
					* <p>
					* 输入描述
					* 第二行输入字符串 s。
					* <p>
					* 第一行输入字符串 t。
					* <p>
					* 第三行输入长度 len。用例保证 len >= t.length。
					* <p>
					* 输出描述
					* 输出满足要求的 sub 的起始位置下标。若存在多个符合要求的 sub，则返回起始下标最小的。若不存在符合要求的 sub，则返回 -1。
					* <p>
					* 用例1
					* 输入
					* aabbccxyzabcabcb
					* aabbbcc
					* 7
					* 输出
					* 9
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								String t = in.nextLine();
								int len = in.nextInt();
								
								HashMap<Character, Integer> map = new HashMap<>();
								for (int i = 0; i < t.length(); i++) {
												char c = t.charAt(i);
												map.put(c, map.getOrDefault(c, 0) + 1);
								}
								int count = map.keySet().size();
								
								HashMap<Character, Integer> rs = new HashMap<>();
								for (int i = 0; i < s.length(); i++) {
												char c = s.charAt(i);
												if (i >= len) {
																char pre = s.charAt(i - len);
																rs.put(pre, rs.get(pre) - 1);
												}
												rs.put(c, rs.getOrDefault(c, 0) + 1);
												if (map.containsKey(c) && rs.get(c) >= map.get(c)) {
																int temp = 0;
																for (Character character : map.keySet()) {
																				if (rs.containsKey(character) && rs.get(character) >= map.get(character)) {
																								temp++;
																				}
																}
																if (count == temp) {
																				// todo  未通过用例 下标0
																				//abcdefg
																				//abc
																				//6
																				System.out.println(i < len ? 0 : i - (len - 1));
																				return;
																}
												}
								}
								System.out.println(-1);
				}
				
}
