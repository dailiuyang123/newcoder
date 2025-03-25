package od_2024_e;

import java.util.LinkedList;
import java.util.Scanner;

public class OD025走梅花桩_二维数组 {
				static int res = Integer.MIN_VALUE;
				
				/**
					* 2025/3/25
					* URL ：
					* 题目描述：
					* 少林寺武僧有一项训练科目就是走梅花桩，现在有 m 行 n 列的梅花桩，每个梅花桩都有一个高度，若相邻梅花桩之间的高度相差为 x，则可以走到相邻梅花桩上。
					* <p>
					* 少林武僧可以选择任意起始位置，请你计算出少林武僧最多可以走多少个梅花桩。
					* <p>
					* 输入描述
					* 第一行输入 m 和 n 和 x，以空格分隔。m 和 n 不大于100。高度差 x 不大于10。
					* <p>
					* 之后 m 行，每行 n 个数，分别表示梅花桩的高度。高度不大于100。
					* <p>
					* 输出描述
					* 请输出少林武僧最多可以走的梅花桩数量。
					* <p>
					* 用例
					* 输入
					* 5 5 1
					* 1 2 3 4 5
					* 9 8 7 6 5
					* 9 9 9 9 9
					* 1 2 3 4 5
					* 1 2 3 4 5
					* 输出
					* 15
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								int m = in.nextInt();
								int n = in.nextInt();
								int x = in.nextInt();
								int[][] map = new int[m][n];
								
								for (int i = 0; i < m; i++) {
												for (int j = 0; j < n; j++) {
																map[i][j] = in.nextInt();
												}
								}
								
								for (int i = 0; i < m; i++) {
												for (int j = 0; j < n; j++) {
																dfs(j, i, map, new boolean[m][n], new LinkedList<>(), x);
												}
								}
								System.out.println(res);
								
				}
				
				// 二维数组，向四周深度递归，直到不能走为止 找到最大值
				public static void dfs(int x, int y, int[][] map, boolean[][] used, LinkedList<Integer> path, int limit) {
								
								// 不能回头
								if (used[y][x]) {
												res = Math.max(res, path.size());
												return;
								}
								used[y][x] = true;
								int curr = map[y][x];
								path.addLast(map[y][x]);
								
								// 向上
								if ((y + 1) < map.length && Math.abs(map[y + 1][x] - curr) <= limit) {
												dfs(x, y + 1, map, used, path, limit);
								}
								
								// 向下
								if ((y - 1) > 0 && Math.abs(map[y - 1][x] - curr) <= limit) {
												dfs(x, y - 1, map, used, path, limit);
								}
								
								// 向右
								if ((x + 1) < map[0].length && Math.abs(map[y][x + 1] - curr) <= limit) {
												dfs(x + 1, y, map, used, path, limit);
								}
								// 向左
								if ((x - 1) >= 0 && Math.abs(map[y][x - 1] - curr) <= limit) {
												dfs(x - 1, y, map, used, path, limit);
								}
				}
				
				
}
