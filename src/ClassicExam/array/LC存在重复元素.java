package ClassicExam.array;

import java.util.ArrayList;
import java.util.Arrays;

public class LC存在重复元素 {
    /**
     * 2023/3/26
     * URL ：https://leetcode.cn/leetbook/read/top-interview-questions/xm1rfd/
     * 题目描述：
     **/

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }


}
