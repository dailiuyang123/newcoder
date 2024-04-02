package od_2024_c.深度遍历;

import ClassicExam.od_200.无向图染色_UP;

import java.util.Scanner;

public class 小华地图找黄金 {
    /**
     * 2024/3/2
     * URL ：https://hydro.ac/d/HWOD2023/p/OD361
     * 题目描述：题目描述
     * 小华按照地图去寻宝，地图上被划分成 m 行和 n 列的方格，横纵坐标范围分别是 [0, n-1] 和 [0, m-1]。
     * <p>
     * 在横坐标和纵坐标的数位之和不大于 k 的方格中存在黄金（每个方格中仅存在一克黄金），但横坐标和纵坐标之和大于 k 的方格存在危险不可进入。小华从入口 (0,0) 进入，任何时候只能向左，右，上，下四个方向移动一格。
     * <p>
     * 请问小华最多能获得多少克黄金？
     * <p>
     * 输入描述
     * 坐标取值范围如下：
     * <p>
     * 0 ≤ m ≤ 50
     * 0 ≤ n ≤ 50
     * k 的取值范围如下：
     * <p>
     * 0 ≤ k ≤ 100
     * 输入中包含3个字数，分别是m, n, k
     * <p>
     * 输出描述
     * 输出小华最多能获得多少克黄金
     **/
    static int[][] map;
    static int k;

    static int res;

    // 数位和数组
    static int[] digitSums;

    // 该方法用于求解 0 ~ maxSize - 1 各个数对应的数位和，提前计算好，避免后期重复计算某个数的数位和
    public static void digitSum(int maxSize) {
        // digitSums数组的索引是原始数，值是原始数对应的数位和
        digitSums = new int[maxSize];

        for (int i = 0; i < maxSize; i++) {
            int num = i;
            while (num > 0) {
                digitSums[i] += num % 10;
                num /= 10;
            }
        }
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        k = in.nextInt();

        // todo 注意是数位之和，就是各位的数字之和：39： 3+9 =12
        digitSum(Math.max(m, n));

        map = new int[m][n];
        dfs(0, 0, new boolean[m][n]);
        System.out.println(res);


    }

    public static void dfs(int y, int x, boolean[][] used) {


        int[] y_arr = {0, 1, -1, 0};
        int[] x_arr = {1, 0, 0, -1};
        used[y][x] = true;
        if((digitSums[x] + digitSums[y]) <= k){
            res++;
        }

//        System.out.println(y + ":" + x);

        // 上下左右
        for (int i = 0; i < x_arr.length; i++) {
            x += x_arr[i];
            y += y_arr[i];
            if ((y >= 0 && y < map.length) && (x >= 0 && x < map[0].length) && (digitSums[x] + digitSums[y]) <= k && !used[y][x]) {
                dfs(y, x, used);
            }
            x -= x_arr[i];
            y -= y_arr[i];
        }

    }

}
