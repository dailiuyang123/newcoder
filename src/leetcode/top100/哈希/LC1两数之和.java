package leetcode.top100.哈希;

import java.util.*;

public class LC1两数之和 {
    /**
     * 2023/11/11
     * URL ：https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked
     * 题目描述：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案
     **/
    public static void main(String[] args) {

        LC1两数之和 lc1两数之和 = new LC1两数之和();
        int[] nums = {-1, 0, 1, 0};
        List<List<Integer>> list = lc1两数之和.threeSum(nums);
        Set<List<Integer>> sort = new HashSet<>(list);
        System.out.println(list.toString());

//        int[] ints = lc1两数之和.twoSum(nums, 6);
//        System.out.println(ints[0]);
//        System.out.println(ints[1]);

    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];
            if (map.containsKey(goal) && i != map.get(goal)) {
                return new int[]{i, map.get(goal)};
            }
        }

        return null;

    }


    /**
     * 三数之和
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> lists = new HashSet<>();
        Arrays.sort(nums);
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        if (nums[0] + nums[1] + nums[2] > 0) {
            return new ArrayList<>();
        }

        HashMap<Integer, Integer> zheng = new HashMap<>();
        HashMap<Integer, Integer> fu = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                zheng.put(nums[i], zheng.getOrDefault(nums[i], 0) + 1);
            } else {
                fu.put(nums[i], fu.getOrDefault(nums[i], 0) + 1);
            }
        }


        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            // 为了避免元素重复使用导致，错误命中。现分成正负两种情况
            if (target < 0) {

                for (int two : fu.keySet()) {
                    int three = target - two;
                    if (fu.containsKey(three)) {

                        if ((two == three && fu.get(two) >= 2) || two != three) {


                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(two);
                            list.add(three);
                            Collections.sort(list);
                            lists.add(list);
                        }
                    }
                }
            } else {
                for (int two : zheng.keySet()) {
                    int three = target - two;
                    if (zheng.containsKey(three)) {
                        if ((two == three && zheng.get(two) >= 2) || two != three) {
                            if (two == three && nums[i] == three) {
                                if (zheng.get(two) < 3) {
                                    continue;
                                }
                            }
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(two);
                            list.add(three);
                            Collections.sort(list);
                            lists.add(list);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(lists);

    }


}
