package ClassicExam.od_200;

import java.util.Scanner;

public class 探索地块建立_动态规划_Undo_背会 {

    /**
     * 题目描述
     * 给一块n*m的地块，相当于n*m的二维数组，每个元素的值表示这个小地块的发电量；
     * <p>
     * 求在这块地上建立正方形的边长为c的发电站，发电量满足目标电量k的地块数量。
     * <p>
     * 输入描述
     * 第一行为四个按空格分隔的正整数，分别表示n, m , c k
     * <p>
     * 后面n行整数，表示每个地块的发电量
     * <p>
     * 输出描述
     * 输出满足条件的地块数量
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();
        int k = in.nextInt();

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }

        int rs = getRs(map, n, m, c, k);
        System.out.println(rs);
    }


    public static int getRs(int[][] map, int n, int m, int c, int k) {

        // 行压缩
        int[][] dps = new int[n][];
        // 遍历每一行进行水平方向区块压缩
        for (int i = 0; i < n; i++) {
            int[] arr = map[i];
            // 每c个相邻块压缩的话，则一行最多压缩为 m -c +1 个压缩快
            int[] dp = new int[m - c + 1];
            for (int j = 0; j < c; j++) {
                dp[0] += arr[j];
            }

            // 第二个开始的压缩区块的发电量，基于前面一个压缩区块的差异比较计算出，而不是全部重新计算。
            for (int j = 1; j < dp.length; j++) {
                dp[j] = dp[j - 1] - arr[j - 1] + arr[j + c - 1];
            }
            dps[i] = dp;
        }

        // 列压缩
        int[][] newDps = new int[m - c + 1][];
        // 遍历经过行压缩后的地块的每一列，在垂直方向上压缩
        for (int i = 0; i < m - c + 1; i++) {
            // 如果c个相邻区块压缩的话，则一列最多压缩为 n-c+1个
            int[] newDp = new int[n - c + 1];
            // 计算每列第一个压缩区块的发电量作为基准值
            for (int j = 0; j < c; j++) {
                newDp[0] += dps[j][i];
            }

            //第二个开始的压缩快发电量，基于和前面一个压缩区块的差异比较计算出，而不是全部重新计算
            for (int j = 1; j < newDp.length; j++) {
                newDp[j] = newDp[j - 1] - dps[j - 1][i] + dps[j + c - 1][i];
            }
            newDps[i] = newDp;
        }

        int ans = 0;
        for (int i = 0; i < newDps.length; i++) {

            for (int j = 0; j < newDps[i].length; j++) {

                if (newDps[i][j] >= k) {
                    ans++;
                }

            }

        }

        return ans;
    }


}
