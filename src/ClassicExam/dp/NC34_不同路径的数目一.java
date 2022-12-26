package ClassicExam.dp;

public class NC34_不同路径的数目一 {


    /**
     * 不同路径的数目
     * 一个机器人在m×n大小的地图的左上角（起点）。
     * 机器人每次可以向下或向右移动。机器人要到达地图的右下角（终点）。
     * 可以有多少种不同的路径从起点走到终点？
     * <p>
     * 一般可以用dp
     * <p>
     * 画出dp方程式：
     * 初始化，第一行和第一列的dp值全部为1，这些位置可以确定只有一条路径。表格的其他位置，根据转移方程，进行填充即可。
     * 如下图，站在红叉的位置，根据规则，其只能从其左边和上面走到，那么到达红叉的走法就是前两步骤的和。
     * 状态转移方程：dp[i,j] = dp[i-1,j]+dp[i,j-1]
     */
    public int uniquePaths(int m, int n) {
        // write code here
        int[][] dp = new int[m][n];

        // 第一行初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // 第一列初始化：
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];

    }





}
