package od_2024_e;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OD098字符串解密 {
				/**
					* 2024/12/16
					* URL ：
					* 题目描述：
					* 123admyffc79pt
					**/
				public static void main(String[] args) {
								
								Scanner in =new Scanner(System.in);
								String s1 = in.nextLine();
								String s2 = in.nextLine();
								int length = length(s2);
								
								String regx="[0-9|a-f]+";
								
								List<String> res=new ArrayList<>();
								String[] split = s1.split(regx);
								for (String s : split) {
												if(s.length()>0 && length(s)<=length){
																res.add(s);
												}
								}
								if(res.isEmpty()){
												System.out.println("Not Found");
												return;
								}
								
								List<String> collect = res.stream().sorted(
																(a, b) -> {
																				if (length(a) != length(b)) {
																								return length(b) - length(a);
																				} else {
																								return b.compareTo(a);
																				}
																}
								).collect(Collectors.toList());
								System.out.println(collect.get(0));
				}
				
				
				public static int length(String temp){
								HashSet<Character> s2Set=new HashSet<>();
								for (int i = 0; i < temp.length(); i++) {
												s2Set.add(temp.charAt(i));
								}
							return 	s2Set.size();
				}
}
