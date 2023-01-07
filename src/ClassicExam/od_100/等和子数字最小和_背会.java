package ClassicExam.od_100;

import java.util.Arrays;
import java.util.Scanner;

public class 等和子数字最小和_背会 {

    /**
     * 给定一个数组 nums,将元素分为若干个组，使得每组和相等
     * 求出满足条件的所有分组中，组内元素和的最小值
     * <p>
     * 输入描述：
     * 第一行输入 m
     * 接着输入m个数，表示此数组
     * 输出：
     * 最小拆分数组和。
     * <p>
     * 示例：
     * 输入：
     * 7l
     * 4 3 2 3 5 2 1
     * <p>
     * 输出 5
     * <p>
     * 说明：可以等分的情况有：
     * 4个子集(5),(1,4),(2,3),(2,3)
     * <p>
     * 2个子集 (5,1,4) , (2,3,2,3)
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int sum = Arrays.stream(arr).sum();

        for (int i = n; i > 0; i--) {
            if (canPartitionK(arr, i, sum)) {
                System.out.println(sum / i);
                break;
            }
        }

    }

    public static boolean canPartitionK(int[] nums, int k, int sum) {
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
        int[] cursum = new int[1 << n];

        dp[0] = true;
        for (int i = 0; i < 1 << n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (cursum[i] + nums[j] > avg) {
                    break;
                }
                if (((i >> j) & 1) == 0) {
                    int next = i | (1 << j);
                    if (!dp[next]) {
                        cursum[next] = (cursum[i] + nums[j]) % avg;
                        dp[next] = true;
                    }
                }
            }
        }

        return dp[(1 << n) - 1];
    }


}
