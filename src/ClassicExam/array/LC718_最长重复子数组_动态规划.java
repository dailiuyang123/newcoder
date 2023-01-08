package ClassicExam.array;

public class LC718_最长重复子数组_动态规划 {

    /**
     * 给两个整数数组 nums1 和 nums2 ，
     * 返回 两个数组中 公共的 、长度最长的子数组的长度。
     * <p>
     * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
     * 输出：3
     * 解释：长度最长的公共子数组是 [3,2,1] 。
     */
    public int findLength(int[] nums1, int[] nums2) {

        // 暴力可解

        // 动态规划解法

        // 确定dp数组及含义
        // dp[i][j] : 以下标i-1,j-1 ，最长重复子数组长度为：dp[i][j]

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        // 确定 递推公式
        // 如果：nums1[i-1] == nums2[j-1] 则 dp[i][j]=dp[i-1][j-1];

        int max = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max;

    }


    public static void main(String[] args) {

        LC718_最长重复子数组_动态规划 lc718 = new LC718_最长重复子数组_动态规划();
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        int length = lc718.findLength(nums1, nums2);
        System.out.println(length);

    }


}
