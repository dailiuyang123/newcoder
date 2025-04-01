package od_2024_e;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class OD27寻找关键钥匙 {
				/**
					* 2025/4/1
					* URL ：
					* 题目描述
					* 小强正在参加《密室逃生》游戏，当前关卡要求找到符合给定密码K（升序的不重复小写字母组成）的箱子，并给出箱子编号，箱子编号为1~N。
					* <p>
					* 每个箱子中都有一个字符串s，字符串由大写字母、小写字母、数字、标点符号和空格组成，需要在这些字符串中找到所有的字母，忽略大小写后排列出对应的密码串，并返回匹配密码的箱子序号。
					* <p>
					* 提示：满足条件的箱子不超过1个。
					* <p>
					* 输入描述
					* 第一行为key的字符串，第二行为箱子boxes（数组格式），以空格分隔。
					* <p>
					* 箱子N数量满足1 <= N <= 10000，s长度满足0 <= s.length <= 50，密码仅为包含小写字母的升序字符串，且不存在重复字母，密码K长度为K.length，其中1 <= K.length <= 26。
					* <p>
					* 输出描述
					* 返回对应箱子编号，如果不存在符合要求的密码箱，则返回-1。
					* <p>
					* 补充说明：
					* 箱子中字符拼出的字符串与密码的匹配忽略大小写，且要求与密码完全匹配，如密码abc匹配aBc，但是密码abc不匹配abcd。
					* <p>
					* 示例描述
					* 示例一
					* 输入：
					* <p>
					* abc
					* s,sdf123 A2c4b
					* 1
					* 2
					* 输出：
					* <p>
					* 2
					* 1
					* 说明：
					* 第2个箱子中的Abc，符合密码abc。
					* <p>
					* 示例二
					* 输入：
					* <p>
					* abc
					* s,sdf123 A2c4bd 523[]
					* 1
					* 2
					* 输出：
					* <p>
					* -1
					* 1
					* 说明：
					* 第2个箱子中的Abcd，与密码不完全匹配，不符合要求。
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								String key = in.nextLine();
								String[] split = in.nextLine().split(" ");
								boolean flag = false;
								for (int i = 0; i < split.length; i++) {
												String curr = split[i];
												curr = curr.toLowerCase(Locale.ROOT);
												char[] charArray = curr.replaceAll("[^a-z]", "").toCharArray();
												Arrays.sort(charArray);
												if (charArray.length == key.length()) {
																if (String.valueOf(charArray).equals(key)) {
																				flag = true;
																				System.out.println(i + 1);
																}
												}
								}
								
								if (!flag) {
												System.out.println(-1);
								}
								
				}
				
}
