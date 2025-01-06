package od_2024_e;

import java.util.Arrays;
import java.util.Scanner;

public class OD007租车骑绿道 {
				/**
					* 2024/12/26
					* URL ：
					* 题目描述：
					**/
				
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								String[] split = in.nextLine().split(" ");
								int m = Integer.valueOf(split[0]);
								int n = Integer.valueOf(split[1]);
								int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).sorted().toArray();
								int rs = 0;
								int l = 0, r = n - 1;
								while (l <= r) {
												int sum = nums[l] + nums[r];
												if (sum <= m || l == r) {
																l++;
																r--;
												} else {
																r--;
												}
												rs++;
								}
								System.out.println(rs);
								
				}
				
}
