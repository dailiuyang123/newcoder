package ClassicExam.od_100;

import java.util.Arrays;
import java.util.Scanner;

public class 计算子数组最小和 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int sum = Arrays.stream(nums).sum();

        for (int i = n; i > 0; i--) {
            if (canPartion(nums, i, sum)) {
                System.out.println(sum / i);
                break;
            }
        }


    }


    public static boolean canPartion(int[] nums, int k, int sum) {


        // 判断当前分组能否被整除
        if (sum % k != 0) {
            return false;
        }

        int avg = sum / k;
        int n = nums.length;
        // 排序
        Arrays.sort(nums);
        // 最大值，大于平均值
        if (nums[nums.length - 1] > avg) {
            return false;
        }

        // 声明两个数组
        boolean[] dp = new boolean[1 << n];
        int[] cursum = new int[1 << n];

        dp[0] = true;

        for (int i = 0; i < 1 << n; i++) {

            if (!dp[i]) {
                continue;
            }

            for (int j = 0; j < n; j++) {

                // 当前值 是否大于 avg
                if ((cursum[i] + nums[j]) > avg) {
                    break;
                }
                // 判断是否为偶数
                if (((i >> j) & 1) == 0) {

                    int next = i | 1 << j;
                    if (!dp[next]) {
                        cursum[next] = (cursum[i] + nums[j]) % avg;
                        dp[next] = true;
                    }
                }

            }

        }

        return dp[1 << n - 1];

    }


}
