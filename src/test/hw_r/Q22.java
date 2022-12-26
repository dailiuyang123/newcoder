package test.hw_r;

import java.util.Arrays;

public class Q22 {
    //  一个整形数组，任意选择两个数之和绝对值最小

    public static void main(String[] args) {

        int[] nums = {-1, 1, 4, 7, 3};
        int min = 0;
        int l = 0, r = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (i == 0 && j == 1) {
                    min = Math.abs(sum);
                    l = i;
                    r = j;
                } else {
                    if (Math.abs(sum) < min) {
                        min = sum;
                        l = i;
                        r = j;
                    }
                }
            }

        }

        System.out.println(Math.max(nums[l], nums[r]) + ":" + Math.min(nums[l], nums[r]) + ":" + min);


    }

}
