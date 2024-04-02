package test;

import java.util.Arrays;

public class Demo0114 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1};
        boolean partion = isPartion(nums, 4, 4);
        System.out.println(partion);
    }


    public static boolean isPartion(int[] nums, int k, int sum) {

        if (sum % k != 0) {
            return false;
        }

        int avg = sum / k;
        Arrays.sort(nums);

        if (nums[nums.length - 1] > avg) {
            return false;
        }

        int n = nums.length;
        boolean[] dp = new boolean[1 << n];
        int[] curSum = new int[1 << n];
        dp[0] = true;

        for (int i = 0; i < 1 << n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (curSum[i] + nums[j] > avg) {
                    break;
                }
                if ((i >> j & 1) == 0) {
                    int next = i | 1 << j;
                    if (!dp[next]) {
                        curSum[next] = (curSum[i] + nums[j]) % avg;
                        dp[next] = true;
                    }
                }
            }
        }

        return dp[1 << n - 1];

    }

    ///i>>(m-map[j][0])&1==1


}
