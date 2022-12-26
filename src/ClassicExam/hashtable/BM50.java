package ClassicExam.hashtable;

import java.util.*;

public class BM50 {

    /**
     * 两数之和
     * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=295&tqId=745&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=/exam/oj
     */

    // 暴力双循环-- 超时。
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        int[] arr = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] + numbers[j] == target) {
                    arr[0] = i + 1;
                    arr[1] = j + 1;
                    return arr;
                }

            }
        }
        return arr;
    }

    /**
     *  使用hashtable 缓存做法，时间复杂度，降低 ac
     *
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i])+1, i+1};
            }
            m.put(nums[i], i);
        }
        return new int[]{0, 0};
    }


    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        BM50 bm50 = new BM50();
        int[] ints = bm50.twoSum2(nums, 0);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

}


