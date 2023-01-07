package ClassicExam.od_100;

import java.util.Scanner;

public class 最大报酬_01背包_Undo_背会 {

    /**
     * 题目描述
     * 小明每周上班都会拿到自己的工作清单，工作清单内包含 n 项工作，每项工作都有对应的耗时时间（单位 h）和报酬，工作的总报酬为所有已完成工作的报酬之和，那么请你帮小明安排一下工作，保证小明在指定的工作时间内工作收入最大化。
     * <p>
     * 输入描述
     * 输入的第一行为两个正整数 T，n。
     * T 代表工作时长（单位 h， 0 < T < 1000000），
     * n 代表工作数量（ 1 < n ≤ 3000）。
     * 接下来是 n 行，每行包含两个整数 t，w。
     * t 代表该工作消耗的时长（单位 h， t > 0），w 代表该项工作的报酬。
     * <p>
     * 输出描述
     * 输出小明指定工作时长内工作可获得的最大报酬。
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int n = in.nextInt();

        int[][] tws = new int[n][2];

        for (int i = 0; i < n; i++) {
            tws[i][0] = in.nextInt();
            tws[i][1] = in.nextInt();
        }

        System.out.println(getRs(T, tws));
    }


    public static int getRs(int T, int[][] tws) {

        int MaxI = tws.length;
        int MaxJ = T + 1;

        int[][] dp = new int[MaxI][MaxJ];

        // 背包物品集合
        for (int i = 0; i < MaxI; i++) {
            // 背包重量
            for (int j = 0; j < MaxJ; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }

                // 计算出：要选择问题的，重量与价值
                int t = tws[i - 1][0]; // 要选择物品的重量
                int w = tws[i - 1][1]; // 要选择物品的价值

                if (t > j) {
                    // 如果当前要放入的重量，大于背包容量，则无法放入背包，最大价值继承自上一行该列值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], w + dp[i - 1][j - t]);
                }
            }
        }

        return dp[MaxI - 1][MaxJ - 1];

    }


}
