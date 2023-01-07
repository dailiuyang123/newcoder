package ClassicExam.od_200;

import java.util.*;

public class 查找充电设备组合 {

    /**
     * 题目描述
     * 某个充电站，可提供n个充电设备，每个充电设备均有对应的输出功率。任意个充电设备组合的输出功率总和，均构成功率集合P的1个元素。功率集合P的最优元素，表示最接近充电站最大输出功率p_max的元素。
     * <p>
     * 输入描述
     * 输入为3行：
     * <p>
     * 第1行为充电设备个数n
     * 第2行为每个充电设备的输出功率
     * 第3行为充电站最大输出功率p_max
     * 输出描述
     * 功率集合P的最优元素
     * <p>
     * 备注
     * 充电设备个数 n > 0
     * 最优元素必须小于或等于充电站最大输出功率p_max
     * <p>
     * 【 全排列解法】
     */
    static List<Integer> res = new ArrayList<>();

    static List<List<Integer>> rs = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] powers = new int[n];
        for (int i = 0; i < n; i++) {
            powers[i] = in.nextInt();
        }

        int p_max = in.nextInt();
        int path = 0;

        boolean[] used = new boolean[n];
        dfs(powers, p_max, 0, used);
        Collections.sort(res);
        System.out.println(res.get(res.size() - 1));

    }

    /**
     * 动态规划 -- 01 背包解决此问题
     */
    public static int getRs(int[] nums, int n, int p_max) {

        int[][] dp = new int[n + 1][p_max + 1];

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= p_max; j++) {

                if (i == 0 || j == 0) {
                    continue;
                }

                // nums[i-1] 充电设备功率，大于当前允许的功率，继承上一个合法充电设备
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], nums[i - 1] + dp[i - 1][j - nums[i - 1]]);
                }
            }
        }

        return dp[n][p_max];

    }


    public static void dfs(int[] powers, int p_max, int path, boolean[] used) {

        if (path <= p_max) {
            res.add(path);
        } else {
            return;
        }

        for (int i = 0; i < powers.length; i++) {

            if (used[i]) {
                continue;
            }
            // 全排列
            if (i > 0 && powers[i] == powers[i - 1] && (!used[i - 1])) {
                continue;
            }
            path += powers[i];
            used[i] = true;
            dfs(powers, p_max, path, used);
            path -= powers[i];
            used[i] = false;
        }

    }


    /**
     * 含有 重复元素的全排列
     */
    public static void dfs(int[] powers, LinkedList<Integer> path, boolean[] used) {

        rs.add(new ArrayList<>(path));

        for (int i = 0; i < powers.length; i++) {
            if (used[i]) {
                continue;
            }
            // 全排列
            if (i > 0 && powers[i] == powers[i - 1] && (!used[i - 1])) {
                continue;
            }
            path.addLast(powers[i]);
            used[i] = true;
            dfs(powers, path, used);
            path.removeLast();
            used[i] = false;
        }
    }


}
