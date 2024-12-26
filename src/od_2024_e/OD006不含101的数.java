package od_2024_e;

import java.util.Scanner;

public class OD006不含101的数 {
				/**
					* 2024/12/26
					* URL ：
					* 题目描述：
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								int l = in.nextInt();
								int r = in.nextInt();
								
								String l_str = Integer.toBinaryString(l);
								String r_str = Integer.toBinaryString(r);
								
								System.out.println(l_str);
								System.out.println(r_str);
				}
				
}
