package leetcode.top100.双指针;

public class LC4移动零 {
    /**
     * 2023/11/12
     * URL ：https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
     * 题目描述：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     **/
    public static void main(String[] args) {

        LC4移动零 lc4移动零 = new LC4移动零();
        int[] nums = {0};
        lc4移动零.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    public void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0 && i < nums.length - 1) {
                int l = i;
                while (l < nums.length - 1) {
                    if (nums[l + 1] == 0) {
                        break;
                    }
                    // 与后边的值交换位置
                    nums[l] = nums[l + 1];
                    nums[l + 1] = 0;
                    l++;
                }
            }
        }

    }

    private void swap(int[] nums) {

    }


}
