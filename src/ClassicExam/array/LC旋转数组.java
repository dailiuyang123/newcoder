package ClassicExam.array;

public class LC旋转数组 {

    /**
     * 2023/3/26
     * LC地址： https://leetcode.cn/leetbook/read/top-interview-questions/xm42hs/
     * 题目描述：
     */


    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k != 0) {
            int[] clone = nums.clone();
            for (int i = 0; i < clone.length; i++) {
                // 当前节点移动k步后的坐标
                int index = (i + k) % nums.length;
                nums[index] = clone[i];
            }
        }
    }


    public static void main(String[] args) {

        LC旋转数组 lc = new LC旋转数组();
        int[] nums = {1,2,3,4,5,6,7};
        lc.rotate(nums,1);

    }

}
