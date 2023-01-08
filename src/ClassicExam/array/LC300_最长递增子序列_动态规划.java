package ClassicExam.array;

public class LC300_最长递增子序列_动态规划 {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列 是由数组派生而来的序列，
     * 删除（或不删除）数组中的元素而不改变其余元素的顺序。
     * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     * 示例1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     */
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int max = 1;

        for (int i = 1; i < nums.length; i++) {

            // 初始化值
            dp[i] = 1;

            // i之前的数字的最大值 + 1 ，与 dp[i] 比较， 取最大值。
            for (int j = 0; j < i; j++) {
                // 当前 nums[j]< nums[i] 才能进行 dp[j]+1操作
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            // 可能 当前 nums[i] 不是最大长度
            max = Math.max(dp[i], max);
        }

        return max;

    }


}
