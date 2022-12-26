package second;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总合 2
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次
 */
public class LC40_dfs {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();

        dfs(candidates, target, path, 0, 0, res);

        return res;
    }


    void dfs(int[] candidates, int target, Deque<Integer> path, int curr_sum, int index, List<List<Integer>> res) {

        // 判断条件
        if (curr_sum == target) {
            res.add(new ArrayList<>(path));
            return;
        } else if (curr_sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // 绘画当前层节点
            path.push(candidates[i]);
            curr_sum += candidates[i];
            // 递归
            dfs(candidates, target, path, curr_sum, i + 1, res);
            // 回退
            path.pop();
            curr_sum -= candidates[i];
        }


    }


    public static void main(String[] args) {

        LC40_dfs lc40=new LC40_dfs();
        int[] candidates={2,3,5};
        int target=5;
        List<List<Integer>> lists = lc40.combinationSum2(candidates, target);

        System.out.println(lists.toString());
    }


}
