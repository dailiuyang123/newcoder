package corejava;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Math_Demo {
				/**
					* 2025/9/4
					* URL ：
					* 题目描述：
					**/
				
				public static void main(String[] args) {
								System.out.println("------------------------ round  四舍五入-------------------------------");
								long round = Math.round(1.5);
								System.out.println(round);
								long round1 = Math.round(-1.5);
								System.out.println(round1);
								long round2 = Math.round(1.4);
								System.out.println(round2);
								long round3 = Math.round(-1.4);
								System.out.println(round3);
								
								System.out.println("-------------------  ceil 向上取整 -----------------------");
								double ceil1 = Math.ceil(1.5);
								System.out.println(ceil1);
								double ceil2 = Math.ceil(1.4);
								System.out.println(ceil2);
								double ceil = Math.ceil(-1.5);
								System.out.println(ceil);
								
								System.out.println("----------------------- floor 向下取整 -------------------");
								double floor = Math.floor(1.5);
								System.out.println(floor);
								double floor2 = Math.floor(1.4);
								System.out.println(floor2);
								double floor1 = Math.floor(-1.5);
								System.out.println(floor1);
								
//								Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
				}
				
}
