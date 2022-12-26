package ClassicExam.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LC16_medium {

    /**
     * 给你一个长度为n 的整数数组nums,和一个目标值 target 。 请你从nums 中选中三个数，使他们的和与 target 最相近
     * <p>
     * https://leetcode.cn/problems/3sum-closest/
     */
    public int threeSumClosest2(int[] nums, int target) {


        int sum = -1;

        int curr_sum = 0;

        int index = 0;

        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();

        Set<Integer> res = new HashSet<>();

        dfs(res, curr_sum, index, path, nums, target, used);

        for (Integer curr : res) {
            if (sum == -1) {
                sum = curr;
            } else {
                if (Math.abs(target - curr) < Math.abs(target - sum)) {
                    sum = curr;
                }
            }
        }
        return sum;
    }


    private void dfs(Set<Integer> res, int curr_sum, int index, Deque<Integer> path, int[] nums, int target, boolean[] used) {
        // 减枝 判断条件
        if (path.size() == 3) {
            res.add(curr_sum);
            return;
        }

        if (path.size() > 3) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.push(nums[i]);
            curr_sum += nums[i];
            used[i] = true;
            dfs(res, curr_sum, index, path, nums, target, used);

            path.pop();
            used[i] = false;
            curr_sum -= nums[i];
        }

    }


    public int threeSumClosest(int[] nums, int target) {
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    int curr = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - sum) > Math.abs(target - curr)) {
                        sum = curr;
                    }
                }
            }
        }

        return sum;

    }

    public static void main(String[] args) {

        LC16_medium lc16 = new LC16_medium();
        int[] nums = {-1, 2, 1, -4};
        int i = lc16.threeSumClosest(nums, 1);
        System.out.println(i);

    }


}
