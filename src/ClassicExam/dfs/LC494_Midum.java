package ClassicExam.dfs;

import java.util.Arrays;
import java.util.Collections;

public class LC494_Midum {

    /**
     * 目标和  https://leetcode.cn/problems/target-sum/
     * 给你一个整数数组【nums】和一个整数 target。
     * 向数组中的每个整数前面添加"+"，"-" ，然后串联起所有整数，可以构成一个
     * 表达式：
     * 例如 nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，
     * 然后串联起来得到表达式 "+2-1"
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目
     *
     * 【题解】：
     *      我们假设 p 是正子集，n 是负子集。根据题意可知：
     *
     *      sum[p]-sum[n] = target
     *
     *      sum[p]-sum[n] + sum[p] +sum[n] = target+sum[n]+target[p]
     *
     *      2 * sum[p] = target + sum[nums];
     *
     *      由此推导出： 只要 正子集：sum[p]= (target+sum[nums])/2 即满足条件，
     *      另外，target + sum[nums] 必须为偶数，否则返回 0。
     */


    /**
     * 标准题解：
     */
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        // sum +target 不为偶数，直接返回0
        if ((sum + target) % 2 > 0 || sum < target || -sum > target) {
            return 0;
        }

        int temp = (sum + target) / 2;

        // 滑动窗口不能够解决，由多少种拼法的问题。
        // 动态规划 解法
        // 问题转移为：从nums 中凑出 temp 的方案数。因此【状态定义】和【状态转移】都需要进行调整【01背包求方案数】
        // 定义：f[i][j] 为从nums 凑出总和恰好 为 j的方案数
        // 最终答案为：f[n][temp],f[0][0]=1为起始条件：代表不考虑任何数，凑出计算结果为0的方案数为1种。
        // 每个数值有：选 和 不选 两种决策，转移方程为：
        //   f[i][j]=f[i-1][j]+f[i-1][j-nums[i-1]]

        int[][] f = new int[n + 1][temp + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= temp; j++) {
                f[i][j] += f[i - 1][j];
                if (j >= x) {
                    f[i][j] += f[i - 1][j - x];
                }
            }
        }
        return f[n][temp];

    }

    public static void main(String[] args) {

        LC494_Midum lc494_midum = new LC494_Midum();
        int[] nums = {1, 1, 1, 1, 1};
        int targetSumWays = lc494_midum.findTargetSumWays(nums, 3);
        System.out.println(targetSumWays);

    }
}