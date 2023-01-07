package ClassicExam.dp.背包01;

import java.util.Arrays;

public class LC322_零钱兑换 {


    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     */

    public int coinChange2(int[] coins, int amount) {

        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }

        // memo[n]的值：表示凑成总金额为n所需的最少硬币数
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {

                if (i - coins[j] > 0 && dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
            }
            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    /**
     * 题目求 最小数，不要求顺序，排列组合都可以
     */

    public int coinChange(int[] coins, int amount) {

        int max = Integer.MAX_VALUE;

        int[] dp = new int[amount + 1];

        // 初始化dp 数组
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 当金额为0时，需要的硬币数目为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {

            // 正序遍历，完全背包每个硬币可以选择多次
            for (int j = coins[i]; j <= amount; j++) {
                // 只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != max) {
                    // 选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        LC322_零钱兑换 lc322_零钱兑换=new LC322_零钱兑换();
        int[] coins={1,3,5};
        int i = lc322_零钱兑换.coinChange(coins, 11);
        System.out.println(i);

    }

}
