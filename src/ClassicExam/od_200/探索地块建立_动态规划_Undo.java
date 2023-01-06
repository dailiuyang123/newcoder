package ClassicExam.od_200;

import java.util.Scanner;

public class 探索地块建立_动态规划_Undo {

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




    }





}
