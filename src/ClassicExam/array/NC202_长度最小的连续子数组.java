package ClassicExam.array;

import java.util.Arrays;
import java.util.Map;

public class NC202_长度最小的连续子数组 {

    /**
     * 长度最小的连续子数组
     * https://www.nowcoder.com/practice/10dd5f8c5d984aa3bd69788d86aaef23?tpId=196&tqId=39383&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&tags=5059&difficulty=undefined&judgeStatus=undefined&tags=5059&title=
     */

    // 双指针解法：
    public int minSubarray(int[] nums, int target) {

        int sum = Arrays.stream(nums).sum();

        if (sum < target) {
            return 0;
        }

        // todo 双指针解法：
        // 当窗口内的和大于target时，右移左边界
        //
        // 当窗口内的和小于target时，右移右边界
        int l = 0;
        int r = 0;
        int s = 0;
        int rs = nums.length;
        while (r < nums.length) {

            while (r < nums.length && s < target) {
                s += nums[r];
                r++;
            }
            // todo  注意： s >= target 不是 > 这一种情况
            while (l < r && s >= target) {
                rs = Math.min(rs, r - l);
                s -= nums[l];
                l++;
            }
        }

        return rs;

    }


    // 暴力解法 --超时
    public int minSubarray2(int[] nums, int target) {
        // write code here

        int sum = Arrays.stream(nums).sum();

        if (sum < target) {
            return 0;
        }

        int minL = nums.length;

        // 确定长度
        for (int i = 1; i < nums.length; i++) {
            // 确定 起点
            for (int j = 0; j + i <= nums.length; j++) {
                int sumTemp = 0;
                int r = j + i;
                for (int k = j; k < r; k++) {
                    sumTemp += nums[k];
                }
                if (sumTemp >= target) {
                    minL = Math.min(minL, i);
                    return minL;
                }
            }
        }

        return nums.length;


    }


    public static void main(String[] args) {

        NC202_长度最小的连续子数组 nc202_长度最小的连续子数组 = new NC202_长度最小的连续子数组();
        int[] arr = {1, 1, 1, 2, 4};
        int i = nc202_长度最小的连续子数组.minSubarray(arr, 7);
        System.out.println(i);

    }


}
