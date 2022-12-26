package test.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class HJ43 {

    //迷宫问题


//    它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，
//    只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。
//    入口点为[0,0],既第一格是可以走的路。
//    数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
//    输入两个整数，分别表示二维数组的行数，列数

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {

            int y = in.nextInt();
            int x = in.nextInt();

            // 构造迷宫
            int[][] map = new int[y][x];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            Deque<Pos> path = new ArrayDeque<>();
            // dfs 遍历
            dfs(map, 0, 0, path);
            // 输出
            for (Pos p : path) {
                System.out.println("(" + p.x + "," + p.y + ")");
            }


        }


    }

    private static boolean dfs(int[][] map, int x, int y, Deque<Pos> path) {

        path.push(new Pos(x, y));
        map[y][x] = 1;

        // 走到终点
        if (y == map.length - 1 && x == map[0].length - 1) {
            return true;
        }

        // 向下
        if (y + 1 < map.length && map[y + 1][x] == 0) {
            dfs(map, x, y + 1, path);
            return true;
        }

        // 向右
        if (x + 1 < map.length && map[y][x + 1] == 0) {
            dfs(map, x + 1, y, path);
            return true;
        }

        //向左
        if (x - 1 > -1 && map[y][x - 1] == 0) {
            dfs(map, x - 1, y, path);
            return true;
        }

        //向上
        if (y - 1 > -1 && map[y - 1][x] == 0) {
            dfs(map, x, y - 1, path);
            return true;
        }

        //回溯
        path.pop();
        map[x][y] = 0;
        return false;
    }

    // 简单的位置类
    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
