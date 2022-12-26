package second;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总合
 */
public class LC39_dfs {


//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Deque<Integer> curr_entity = new ArrayDeque<>();
//        List<List<Integer>> res = new ArrayList<>();
//        // 深度遍历
//        dfs(candidates, curr_entity, 0, 0, target, res);
//
//        return res;
//    }
//
//
//    void dfs(int[] candidates, Deque<Integer> curr_entity, int curr_sum, int index, int target, List<List<Integer>> res) {
//
//        // 判断条件 是否成立？
//        if (curr_sum == target) {
//            // 判断是否有重复
//            res.add(new ArrayList<>(curr_entity));
//            return;
//        } else if (curr_sum > target) {
//            return;
//        }
//
//
//        // 循环继续
//        for (int i = 0; i < candidates.length; i++) {
//            // 拼接元素
//            curr_entity.push(candidates[i]);
//            curr_sum += candidates[i];
//            // 递归调用
//            dfs(candidates, curr_entity, curr_sum, i, target, res);
//            // 回退
//            curr_entity.pop();
//            curr_sum -= candidates[i];
//        }
//
//    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();

        if (length == 0) {
            return res;
        }

        //排序
        Deque<Integer> path = new ArrayDeque<>(length);
        dfs(candidates, length, path, 0, res, 0, target);
        return res;
    }

    /*
     * @param nums 原生数组
     * @param len 原生数组长度
     * @param depth 当前深度，遍历到第几层
     * @param path 当前层级的值
     * @param res 结果集
     * */
    private void dfs(int[] nums, int len, Deque<Integer> path, int begin, List<List<Integer>> res, int total, int target) {

        if (total == target) {
            res.add(new ArrayList<>(path));
            return;
        } else if (total > target) {
            return;
        }

        // 执行过程
        for (int i = begin; i < len; i++) {
            path.push(nums[i]);
            total = total + nums[i];
            dfs(nums, len, path, i, res, total, target);
            path.pop();
            total = total - nums[i];
        }
    }


    public static void main(String[] args) {

        LC39_dfs lc39=new LC39_dfs();
        int[] candidates={2,3,5};
        int target=8;
        List<List<Integer>> lists = lc39.combinationSum(candidates, target);

        System.out.println(lists.toString());


    }


}
