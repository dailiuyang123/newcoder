package od_2024_c.随机;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 数据单元的变化替换 {
				/**
					* 2024/4/27
					* URL ：	1,2<A>00
					* 题目描述：
					**/
				public static void main(String[] args) {
								Scanner in = new Scanner(System.in);
								String s = in.nextLine();
								String[] cells = s.split(",");
								
								Pattern compile = Pattern.compile("(<)[A-Z](>)");
								
								while (true) {
												Matcher matcher = compile.matcher(s);
												if (!matcher.find()) {
																break;
												}
												String group = matcher.group();
												// 解析引用
												int index = group.charAt(1) - 'A';
												String cell_v = cells[index];
												// ToDo replace 与 replaceAll 都是替换所有匹配到的字符，
												//  区别是，repalceAll是正则匹配
												s = s.replace(group, cell_v);
								}
								
								System.out.println(s);
								
				}
				
}
