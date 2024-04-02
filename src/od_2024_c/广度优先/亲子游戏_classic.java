package od_2024_c.广度优先;

import java.util.LinkedList;
import java.util.Scanner;

public class 亲子游戏_classic {
    /**
     * 2024/3/5
     * URL ：https://fcqian.blog.csdn.net/article/details/135062353?spm=1001.2014.3001.5502
     * 题目描述： 题目描述
     * 宝宝和妈妈参加亲子游戏，在一个二维矩阵（N*N）的格子地图上，宝宝和妈妈抽签决定各自的位置，地图上每个格子有不同的糖果数量，部分格子有障碍物。
     * <p>
     * 游戏规则是妈妈必须在最短的时间（每个单位时间只能走一步）到达宝宝的位置，路上的所有糖果都可以拿走，不能走障碍物的格子，只能上下左右走。
     * <p>
     * 请问妈妈在最短到达宝宝位置的时间内最多拿到多少糖果（优先考虑最短时间到达的情况下尽可能多拿糖果）。
     * <p>
     * 输入描述
     * 第一行输入为 N，N 表示二维矩阵的大小
     * <p>
     * 之后 N 行，每行有 N 个值，表格矩阵每个位置的值，其中：
     * <p>
     * -3：妈妈
     * -2：宝宝
     * -1：障碍
     * ≥0：糖果数（0表示没有糖果，但是可以走）
     * 输出描述
     * 输出妈妈在最短到达宝宝位置的时间内最多拿到多少糖果，行末无多余空格
     **/
    static int[][] map;
    static int[][] candy;

    static int[] x_arr = {1, -1, 0, 0};
    static int[] y_arr = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        map = new int[n][n];
        candy = new int[n][n];
        LinkedList<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                candy[i][j] = -1;
                map[i][j] = in.nextInt();
                if (map[i][j] == -3) {
                    queue.add(new int[]{i, j});
                    candy[i][j] = 0;
                }
            }
        }
        int res = -1;

        while (!queue.isEmpty()) {
            LinkedList<int[]> newQueue = new LinkedList<>();
            boolean flag = false;

            for (int[] ints : queue) {
                int y = ints[0];
                int x = ints[1];

                for (int i = 0; i < x_arr.length; i++) {
                    int t_y = y + y_arr[i];
                    int t_x = x + x_arr[i];
                    if (t_x < 0 || t_x >= n || t_y < 0 || t_y >= n || map[t_y][t_x] == -1) {
                        continue;
                    }
                    newQueue.add(new int[]{t_y, t_x});
                    // 从，当前记录糖果，与上一层便利与当前糖果数量，取最大值
                    candy[t_y][t_x] = Math.max(map[t_y][t_x], candy[y][x] + Math.max(0, map[t_y][t_x]));

                    if (map[t_y][t_x] == -2) {
                        flag = true;
                        res = candy[t_y][t_x];
                    }

                }
            }
            // 当前层，已经到达孩子层级，终止下一轮扩散
            if (flag) {
                break;
            }
            queue = newQueue;
        }

        System.out.println(res);
    }

}
