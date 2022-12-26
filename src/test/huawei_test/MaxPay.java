package test.huawei_test;

import java.util.*;

public class MaxPay {
//
//    双十一众多商品进行打折销售，小明想购买自己心仪的一些物品，但由于受购买资金限制，所以他决定从众多心仪商品中购买三件，而且想尽可能的花完资金。
//    现在请你设计一个程序帮助小明计算尽可能花费的最大资金数额。

    public static void main(String[] args) {

        int[] shops = {23, 26, 36, 27};
        int max = 78;
        int length = shops.length;
        Deque<Integer> path = new ArrayDeque<>(3);

        boolean[] used = new boolean[length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(shops, path, res,  used, 0, max);
        System.out.println(res);
    }


    private static void dfs(int[] nums, Deque<Integer> path, List<List<Integer>> res,  boolean[] used, int total, int max) {

        if (total >= max) {
            return;
        }
        if (path.size() == 3) {
            List<Integer> list = new ArrayList<>(path);
            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            total += nums[i];
            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, path, res,  used, total, max);
            path.removeLast();
            used[i] = false;
            total -= nums[i];
        }


    }

}
