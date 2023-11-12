package leetcode.top100.双指针;

import java.util.LinkedList;

public class No3接雨水 {
    /**
     * 2023/11/12
     * URL ：https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
     * 题目描述：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     **/

    public static void main(String[] args) {


    }

    public int trap(int[] height) {

        int sum = 0;

        if (height.length < 3) {
            return sum;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(height[0]);
        for (int i = 1; i < height.length; i++) {
            int next = height[i];



        }


    }
}
