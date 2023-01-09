package ClassicExam.array;

public class LC674_最长连续递增序列_动态规划 {

    /**
     * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
     * <p>
     * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，
     * 如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
     * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = 1;
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= nums.length; i++) {
            dp[i] = 1;
            if (nums[i - 1] > nums[i - 2]) {
                dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
                max = Math.max(max, dp[i]);
            }
        }

        return max;

    }


    public static void main(String[] args) {

        LC674_最长连续递增序列_动态规划 lc674 = new LC674_最长连续递增序列_动态规划();
//        int[] nums = {1, 3, 5, 4, 7};
        int[] nums = {1, 3, 5, 7};
        int lengthOfLCIS = lc674.findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);

    }


}
