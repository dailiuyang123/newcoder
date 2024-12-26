package od_2024_e;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OD004完美走位 {
				/**
					* 2024/12/16
					* URL ：
					* 题目描述：在第一人称射击游戏中，玩家通过键盘的A、S、D、W四个按键控制游戏人物分别向左、向后、向右、向前进行移动，从而完成走位。
					* <p>
					* 假设玩家每按动一次键盘，游戏任务会向某个方向移动一步，如果玩家在操作一定次数的键盘并且各个方向的步数相同时，此时游戏任务必定会回到原点，则称此次走位为完美走位。
					* <p>
					* 现给定玩家的走位（例如：ASDA），请通过更换其中一段连续走位的方式使得原走位能够变成一个完美走位。其中待更换的连续走位可以是相同长度的任何走位。
					* <p>
					* 请返回待更换的连续走位的最小可能长度。
					* <p>
					* 如果原走位本身是一个完美走位，则返回0。
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								
								if (s.length() == 0) {
												System.out.println(0);
								}
								
								int cnt = s.length() / 4;
								
								Map<Character, Integer> map = new HashMap<>();
								Map<Character, Integer> z_map = new HashMap<>();
								int zheng = 0;
								
								for (int i = 0; i < s.length(); i++) {
												char c = s.charAt(i);
												map.put(c, map.getOrDefault(c, 0) + 1);
												if (map.get(c) - cnt > 0) {
																z_map.put(c, map.get(c) - cnt);
												}
								}
								
								for (Character c : z_map.keySet()) {
												zheng += z_map.get(c);
								}
								
								// todo 改为滑动窗口，否则会有超时风险
								for (int i = zheng; i < s.length(); i++) {
												int l = 0;
												while ((l + i) <= s.length()) {
																String tmp = s.substring(l, l + i);
																if (valid(tmp, z_map)) {
																				System.out.println(i);
																				return;
																}
																l++;
												}
								}
								
				}
				
				public static boolean valid(String temp, Map<Character, Integer> z_map) {
								for (Character c : z_map.keySet()) {
												int i = temp.length() - temp.replace(c + "", "").length();
												if (z_map.get(c) > i) {
																return false;
												}
								}
								return true;
				}
				
}
