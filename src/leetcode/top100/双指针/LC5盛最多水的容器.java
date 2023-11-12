package leetcode.top100.双指针;

import ClassicExam.od_100.密室逃生;

public class LC5盛最多水的容器 {
    /**
     * 2023/11/12
     * URL ：https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
     * 题目描述：给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     **/
    public static void main(String[] args) {

        LC5盛最多水的容器 lc5盛最多水的容器 = new LC5盛最多水的容器();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = lc5盛最多水的容器.maxArea(height);
        System.out.println(i);


    }


    public int maxArea(int[] height) {
        int max = 0;
        if (height.length <= 1) {
            return max;
        }

        int l = 0, r = height.length-1;
        while (l < r) {
            if (max < (r - l) * Math.min(height[l], height[r])) {
                max = (r - l) * Math.min(height[l], height[r]);
            }
            // 说明左边界高，若想取得更大面积，则替换右边界,反之则变换左边界
            if (height[l] == Math.max(height[l], height[r])) {
                r--;
            } else {
                l++;
            }
        }
        return max;

    }

    /**
     * 超时
     */
    public int maxArea2(int[] height) {
        int max = 0;
        if (height.length <= 1) {
            return max;
        }
        for (int l = 0; l < height.length - 1; l++) {
            for (int r = l + 1; r < height.length; r++) {
                int min = Math.min(height[l], height[r]);
                max = Math.max(max, min * (r - l));
            }
        }
        return max;
    }

}
