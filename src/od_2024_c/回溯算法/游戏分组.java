package od_2024_c.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 游戏分组 {
    /**
     * 2024/2/19
     * URL ：https://fcqian.blog.csdn.net/article/details/134633477
     * 题目描述：
     **/

    static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = in.nextInt();
        }

        dfs(0, new boolean[10], nums, 0, new LinkedList<Integer>());
        int sum = Arrays.stream(nums).sum();
        int min = Integer.MAX_VALUE;
        for (Integer re : res) {
            min = Math.min(Math.abs(sum - re * 2), min);
        }
        System.out.println(min);
    }

    public static void dfs(int index, boolean[] uesd, int[] nums, int temp, LinkedList<Integer> path) {

        if (path.size() == 5) {
            res.add(temp);
            System.out.println(path.toString());
        }

        for (int i = 0; i < nums.length; i++) {
            if (uesd[i]) {
                continue;
            }
            path.push(nums[i]);
            uesd[i] = true;
            temp += nums[i];
            dfs(index, uesd, nums, temp, path);
            path.pop();
            uesd[i] = false;
            temp -= nums[i];
        }

    }


}
