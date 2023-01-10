package ClassicExam.od_200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class 上班之路 {

    /**
     * 题目描述
     * Jungle 生活在美丽的蓝鲸城，大马路都是方方正正，但是每天马路的封闭情况都不一样。
     * 地图由以下元素组成：
     * 1）”.” — 空地，可以达到;
     * 2）”*” — 路障，不可达到;
     * 3）”S” — Jungle的家;
     * 4）”T” — 公司.
     * 其中我们会限制Jungle拐弯的次数，同时Jungle可以清除给定个数的路障，现在你的任务是计算Jungle是否可以从家里出发到达公司。
     * <p>
     * 输入描述
     * 输入的第一行为两个整数t,c（0 ≤ t,c ≤ 100）,t代表可以拐弯的次数，c代表可以清除的路障个数。
     * <p>
     * 输入的第二行为两个整数n,m（1 ≤ n,m ≤ 100）,代表地图的大小。
     * <p>
     * 接下来是n行包含m个字符的地图。n和m可能不一样大。
     * <p>
     * 我们保证地图里有S和T。
     * <p>
     * 输出描述
     * 输出是否可以从家里出发到达公司，是则输出YES，不能则输出NO。
     * <p>
     * 输入
     * 2 0
     * 5 5
     * ..S..
     * ****.
     * T....
     * ****.
     * .....
     * 输出	YES
     * 说明	无
     */
    static int t, c, n, m;
    static String[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        c = sc.nextInt();

        n = sc.nextInt();
        m = sc.nextInt();

        matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = sc.next().split("");
        }

        System.out.println(getResult());
    }

    public static String getResult() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("S".equals(matrix[i][j])) {
                    HashSet<Integer> path = new HashSet<>();
                    path.add(i * m + j);
                    return dfs(i, j, 0, 0, 0, path) ? "YES" : "NO";
                }
            }
        }
        return "NO";
    }

    // 元素含义【行偏移，列偏移，运动方向】，运动方向：1上，2下，3左，4右
    static int[][] offsets = {{-1, 0, 1}, {1, 0, 2}, {0, -1, 3}, {0, 1, 4}};

    /**
     * @param si         当前位置横坐标
     * @param sj         当前位置纵坐标
     * @param ut         已拐弯次数
     * @param uc         已破壁次数
     * @param lastDirect 上一次运动方向，初始为0，表示第一次运动不会造成拐弯
     * @param path       行动路径，用于记录走过的位置，避免走老路
     * @return 终点是否可达
     */
    public static boolean dfs(int si, int sj, int ut, int uc, int lastDirect, HashSet<Integer> path) {
        // 如果当前位置就是目的地，则返回true
        if ("T".equals(matrix[si][sj])) {
            return true;
        }

        // 有四个方向选择走下一步
        for (int[] offset : offsets) {
            int direct = offset[2];
            int newI = si + offset[0];
            int newJ = sj + offset[1];

            // flag1记录本次运动是否拐弯
            boolean flag1 = false;
            // flag2记录本次运动是否破壁
            boolean flag2 = false;

            // 如果下一步位置没有越界，则进一步检查
            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                // 如果下一步位置已经走过了，则是老路，可以不走
                int pos = newI * m + newJ;
                if (path.contains(pos)) {
                    continue;
                }

                // 如果下一步位置需要拐弯
                if (lastDirect != 0 && lastDirect != direct) {
                    // 如果拐弯次数用完了，则不走
                    if (ut + 1 > t) continue;
                    // 否则就走
                    flag1 = true;
                }

                // 如果下一步位置需要破壁
                if ("*".equals(matrix[newI][newJ])) {
                    // 如果破壁次数用完了，则不走
                    if (uc + 1 > c) continue;
                    // 否则就走
                    flag2 = true;
                }

                // 记录已走过的位置
                path.add(pos);

                // 继续下一步递归
                boolean res = dfs(newI, newJ, ut + (flag1 ? 1 : 0), uc + (flag2 ? 1 : 0), direct, path);

                // 如果某路径可以在给定的t,c下，到达目的地T，则返回true
                if (res) {
                    return true;
                }

                // 否则，回溯
                path.remove(pos);
            }
        }
        return false;
    }

}
