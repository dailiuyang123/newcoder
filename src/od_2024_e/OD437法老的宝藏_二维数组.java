package od_2024_e;

import java.util.Scanner;

public class OD437法老的宝藏_二维数组 {
				static String ponit;
				
				/**
					* 2025/7/10
					* URL ：
					* 题目描述：题目描述
					* 传说，古埃及法老建造了一个矩阵迷宫，迷宫由 n 行 m 列的格子组成，每个格子上都标记了一个字母，同时流传出一个口诀单词。
					* <p>
					* 目前，我们只能从矩阵的边缘位置（第一行、第一列、最后一行、最后一列对应的所有位置）进入迷宫，假设口诀单词的长度为 k，则我们最多只能走 k 步。
					* <p>
					* 若 k 步路径上的字母按顺序拼接出来的单词是口诀单词，则可以获得法老的宝藏，且宝藏就在该路径的最后一步位置。 请你帮忙找出法老的宝藏所在位置 (x, y) 。注：迷宫左上角位置为(0, 0)。
					* <p>
					* 若不存在法老的宝藏，则返回-1。若存在多个法老的宝藏，则返回任意一个即可。
					* <p>
					* 输入描述
					* 第一行输入迷宫的行数 n 和列数 m，以及口诀单词。
					* <p>
					* 之后 n 行，每行 m 个字母，表示迷宫各个格子上标记的字母。
					* <p>
					* 输出描述
					* 输出法老的宝藏所在的位置
					* 4 4 OKG
					* X K X K
					* K G K O
					* X K O K
					* K G G O
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								String[] keys = in.nextLine().split(" ");
								int n = Integer.valueOf(keys[0]);
								int m = Integer.valueOf(keys[1]);
								String key = keys[2];
								
								
								char[][] map = new char[n][m];
								for (int i = 0; i < n; i++) {
												String s = in.nextLine().replaceAll(" ", "");
												map[i] = s.toCharArray();
								}
								
								for (int i = 0; i < n; i++) {
												for (int j = 0; j < m; j++) {
																if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
																				if (map[i][j] == key.charAt(0)) {
																								solution(j, i, map, new boolean[n][m], 0, key);
																								if (ponit != null) {
																												System.out.println(ponit);
																												return;
																								}
																				}
																}
												}
								}
								
								System.out.println(-1);
								
				}
				
				public static void solution(int x, int y, char[][] map, boolean[][] used, int step, String key) {
								// 不能回头
								if (used[y][x]) {
												return;
								}
								step++;
								if (step == key.length()) {
												ponit = y + " " + x;
												return;
								}
								
								// 向上
								if ((y - 1) >= 0 && map[y - 1][x] == key.charAt(step)) {
												solution(x, y - 1, map, used, step, key);
								}
								//向下
								if (y + 1 < map.length && map[y + 1][x] == key.charAt(step)) {
												solution(x, y + 1, map, used, step, key);
								}
								//向左
								if (x - 1 >= 0 && map[y][x - 1] == key.charAt(step)) {
												solution(x - 1, y, map, used, step, key);
								}
								//向右
								if (x + 1 < map[0].length && map[y][x + 1] == key.charAt(step)) {
												solution(x + 1, y, map, used, step, key);
								}
								
				}
				
				
}
