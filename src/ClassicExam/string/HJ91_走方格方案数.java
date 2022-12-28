package ClassicExam.string;


import java.util.Scanner;

public class HJ91_走方格方案数 {

    /**
     * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
     * <p>
     * 注：沿棋盘格之间的边缘线行走
     * <p>
     * 数据范围： 1 \le n,m \le 8 \1≤n,m≤8
     * <p>
     * https://www.nowcoder.com/practice/e2a22f0305eb4f2f9846e7d644dba09b?tpId=37&tqId=21314&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?page=2&tpId=37&type=37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        // 确定范围
        int[][] f = new int[n + 1][m + 1];

        // 初始化
        for (int i = 0; i < n + 1; i++) {
            f[i][0] = 1;
        }

        for (int i = 0; i < m + 1; i++) {
            f[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 状态转移方程
                f[i][j] = f[i][j - 1] + f[i - 1][j];

            }
        }

        System.out.println(f[n][m]);

    }


}
