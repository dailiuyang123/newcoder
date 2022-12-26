package second;

import java.util.Arrays;
import java.util.List;

public class NC48 {

    /**
     *在旋转过的有序数组中寻找目标值 https://www.nowcoder.com/practice/87c0e7abcbda41e7963660fa7d020995?tpId=196&tqId=37078&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     *
     *
     *
     *
     */


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // write code here
        // 算出K
        if (nums.length < 1) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }


        int k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (target > nums[i] || target < nums[i + 1]) {
                    return -1;
                }
                k = nums.length - i - 1;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if (i + 1 > k) {
                    return i - k;
                } else {
                    return nums.length - k + i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {6, 8, 10, 0, 2, 4};

        int target = 0;
        NC48 nc48 = new NC48();
        int search = nc48.search(nums, target);
        System.out.println(search);

    }

}
