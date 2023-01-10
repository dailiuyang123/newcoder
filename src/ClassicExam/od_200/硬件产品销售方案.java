package ClassicExam.od_200;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 硬件产品销售方案 {

    /**
     * 题目描述
     * 某公司目前推出了AI开发者套件，AI加速卡，AI加速模块，AI服务器，智能边缘多种硬件产品，每种产品包含若干个型号。
     * 现某合作厂商要采购金额为amount元的硬件产品搭建自己的AI基座。
     * 例如当前库存有N种产品，每种产品的库存量充足，给定每种产品的价格，记为price（不存在价格相同的产品型号）。
     * 请为合作厂商列出所有可能的产品组合。
     * <p>
     * 输入描述
     * 输入包含采购金额amount和产品价格列表price。第一行为amount，第二行为price，例如：
     * <p>
     * 500
     * [100, 200, 300, 500]
     * <p>
     * 输出描述
     * 输出为组合列表。例如：
     * <p>
     * [[100, 100, 100, 100, 100], [100, 100, 100, 200], [100, 100, 300], [100, 200, 200], [200, 300], [500]]
     */
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int amount = Integer.valueOf(s);
        String s1 = in.nextLine();
        String[] split = s1.substring(1, s1.length() - 1).split("\\,");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        Deque<Integer> path = new LinkedList<>();
        dfs(nums,amount,0,path);
        System.out.println(res.toString());

    }

    /**
     * 组合
     */
    public static void dfs(int[] nums, int amount, int index, Deque<Integer> path) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            amount -= nums[i];
            path.push(nums[i]);
            dfs(nums, amount, i, path);
            amount += nums[i];
            path.pop();
        }
    }


}
