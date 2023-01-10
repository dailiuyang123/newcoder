package ClassicExam.od_200;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 组装新的数组_dfs_组合 {

    /**
     * 题目描述
     * 给你一个整数M和数组N，N中的元素为连续整数，要求根据N中的元素组装成新的数组R，组装规则：
     * <p>
     * R中元素总和加起来等于M
     * R中的元素可以从N中重复选取
     * R中的元素最多只能有1个不在N中，且比N中的数字都要小（不能为负数）
     * 输入描述
     * 第一行输入是连续数组N，采用空格分隔
     * 第二行输入数字M
     * <p>
     * 输出描述
     * 输出的是组装办法数量，int类型
     * <p>
     * 备注
     * 1 ≤ M ≤ 30
     * 1 ≤ N.length ≤ 1000
     * 用例
     * 输入	2
     * 5
     * 输出	1
     * 说明	只有1种组装办法，就是[2,2,1]
     */

    static int min = 0;
    static int count = 0;
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] split = s.split("\\ ");
        int[] nums = new int[split.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        int M = in.nextInt();

        min = nums[0];
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, M, 0, 0, path);
        System.out.println(count);


    }


    public static void dfs(int[] nums, int target, int currSum, int index, Deque<Integer> path) {

        if (currSum > target) {
            return;
        }

        if (target - currSum < min || currSum == target) {
            count++;
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = index; i < nums.length; i++) {
            path.push(nums[i]);
            currSum += nums[i];
            dfs(nums, target, currSum, i, path);
            path.pop();
            currSum -= nums[i];
        }


    }


}
