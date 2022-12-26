package test.dp;

import java.util.Arrays;

public class MaxAddArray {

    // 求最大递增公共子序列

    public int maxHeigh(int[] men, int n) {

        int[] dp = new int[n];

        if (men.length == 1) {
            return 1;
        }
        Arrays.fill(dp, 1);

        int rt = 1;
        // 求下标 i 的最长 公共子序列
        for (int i = 0; i < men.length; i++) {
            // 遍历
            for (int j = 0; j < i; j++) {
                // 如果当前节点 ，比 最后一个节点小
                if (men[j] < men[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            rt = Math.max(dp[i], rt);
        }

        return rt;
    }

    public static void main(String[] args) {
        MaxAddArray maxAddArray = new MaxAddArray();
        int[] men = {1, 6, 2, 5, 3, 4};
        int i = maxAddArray.maxHeigh(men, 6);
        System.out.println(i);

    }

}
