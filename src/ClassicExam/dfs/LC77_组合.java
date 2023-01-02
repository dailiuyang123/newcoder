package ClassicExam.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC77_组合 {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * <p>
     * 你可以按 任何顺序 返回答案。
     * <p>
     * https://leetcode.cn/problems/combinations/
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(n, k, 1, path);
        return res;
    }

    public void dfs(int n, int k, int index, LinkedList<Integer> path) {

        if (path.size() == k) {
            // todo 注意要 new 新list
            res.add(new ArrayList<>(path));
            return;
        }

        // todo 注意 i 的初始值
        for (int i = index; i <= n; i++) {
            path.addLast(i);
            // todo 注意 i+1 不是 index+1 !!!!
            dfs(n, k, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        LC77_组合 lc77_组合=new LC77_组合();
        List<List<Integer>> combine = lc77_组合.combine(4, 2);
        System.out.println(combine.toString());
    }


}
