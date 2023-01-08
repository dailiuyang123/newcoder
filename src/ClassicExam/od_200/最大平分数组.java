package ClassicExam.od_200;

import java.util.Arrays;
import java.util.Scanner;

public class 最大平分数组 {

    /**
     * 题目描述
     * 给定一个数组nums，可以将元素分为若干个组，使得每组和相等，求出满足条件的所有分组中，最大的平分组个数。
     * <p>
     * 输入描述
     * 第一行输入 m
     * 接着输入m个数，表示此数组
     * 数据范围:1<=M<=50, 1<=nums[i]<=50
     * <p>
     * 输出描述
     * 最大的平分组数个数
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = in.nextInt();
        }

        int sum = Arrays.stream(nums).sum();

        for (int i = m; i > 0; i--) {
            if (ispartion(nums, i, sum)) {
                System.out.println(i);
                return;
            }
        }


    }


    public static boolean ispartion(int[] nums, int k, int sum) {

        if (sum % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        int avg = sum / k;
        if (nums[nums.length - 1] > avg) {
            return false;
        }

        int n = nums.length;

        boolean[] dp = new boolean[1 << n];
        int[] currSum = new int[1 << n];

        dp[0] = true;

        for (int i = 0; i < 1 << n; i++) {

            if (!dp[i]) {
                continue;
            }

            for (int j = 0; j < n; j++) {

                if (currSum[i] + nums[j] > avg) {
                    break;
                }

                if ((i >> j & 1) == 0) {

                    int next = i | 1 << j;

                    if (!dp[next]) {

                        currSum[next] = (currSum[i] + nums[j]) % avg;
                        dp[next] = true;
                    }

                }
            }
        }

        return dp[1 << n - 1];

    }


}
