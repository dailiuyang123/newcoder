package od_2024_e.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
	* 2025/3/11
	* URL ：
	* 题目描述：
	* 每个数字关联多个字母，关联关系如下:
	* <p>
	* 0 关联“a”,”b”,”c”
	* 1 关联“d”,”e”,”f”
	* 2 关联“g”,”h”,”i”
	* 3 关联“j”,”k”，”l”
	* 4 关联“m”,”n”,”o”
	* 5 关联“p”,”q”,”r”
	* 6 关联“s”，”t”
	* 7 关联“u”,”v”
	* 8 关联“w”,”x”
	* 9 关联“y”,”z”
	* 输入一串数字后，通过数字和字母的对应关系可以得到多个字母字符串(要求按照数字的顺序组合字母字符串);
	* <p>
	* 屏蔽字符串:屏蔽字符串中的所有字母不能同时在输出的字符串出现，如屏蔽字符串是abc，则要求字符串中不能同时出现a.b.c，但是允许同时出现a.b或a.c或b,c等:
	* <p>
	* 给定一个数字字符串和一个屏蔽字符串，输出所有可能的字符组合。
	* <p>
	* 例如输入数字字符串78和屏蔽字符串ux，输出结果为uw，vw;数字字符串78，可以得到如下字符串uw，ux，vw，vx;由于ux是屏蔽字符串，因此排除ux，最终的输出是uw，vw，vx;
	* <p>
	* 输入描述
	* <p>
	* 第一行输入为一串数字字符串，数字字符串中的数字不允许重复，数字字符串的长度大于0，小于等于5
	* <p>
	* 第二行输入是屏蔽字符串，屏蔽字符串的长度一定小于数字字符串的长度，屏蔽字符串中字符不会重复,
	* <p>
	* 输出描述
	* <p>
	* 输出可能的字符串组合
	**/
public class OD91字母组合 {
				static HashMap<Integer, String> map = new HashMap<>();
				static ArrayList<String> res = new ArrayList<>();
				static int length;
				
				static int[] nums;
				
				static {
								map.put(0, "abc");
								map.put(1, "def");
								map.put(2, "ghi");
								map.put(3, "jkl");
								map.put(4, "mno");
								map.put(5, "pqr");
								map.put(6, "st");
								map.put(7, "uv");
								map.put(8, "wx");
								map.put(9, "yz");
				}
				
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								String line = in.nextLine();
								length = line.length();
								nums=new int[length];
								String stop = in.nextLine();
								String strings = "";
								for (int i = 0; i < line.length(); i++) {
												int t = line.charAt(i) - '0';
												nums[i] = t;
												strings += map.get(t);
								}
								
								dfs(0, strings, stop, new StringBuilder());
								System.out.println(res.toString());
				}
				
				
				public static void dfs(int index, String strings, String stop, StringBuilder path) {
								
								if (path.length() == length) {
												String tmp = path.toString();
												if (tmp.indexOf(stop) == -1) {
																res.add(tmp);
												}
												return;
								}
								
								for (int i = index; i < strings.length(); i++) {
												char c = strings.charAt(i);
												// 当前处理的数字
												if (path.length() > 0) {
																int preNum = nums[path.length() - 1];
																// 跳过同一数字
																if (map.get(preNum).indexOf(c) != -1) {
																				continue;
																}
												}
												
												path.append(c);
												dfs(i + 1, strings, stop, path);
												path.deleteCharAt(path.length() - 1);
								}
								
				}
				
				
}
