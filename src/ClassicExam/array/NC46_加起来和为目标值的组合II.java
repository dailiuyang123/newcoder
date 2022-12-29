package ClassicExam.array;

import java.util.*;

public class NC46_加起来和为目标值的组合II {


    /**
     * 给出一组候选数 c 和一个目标数 t ，找出候选数中起来和等于 t 的所有组合。
     * <p>
     * c 中的每个数字在一个组合中只能使用一次。
     * https://www.nowcoder.com/practice/75e6cd5b85ab41c6a7c43359a74e869a?tpId=196&tqId=37076&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?page=1&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {

        if (num.length == 1 && num[0] != target) {
            return res;
        }
        Arrays.sort(num);
        LinkedList<Integer> path = new LinkedList<>();
        dfs(num, target, 0, path);
        return res;
    }


    public void dfs(int[] num, int target, int index, LinkedList<Integer> path) {
        if (target < 0) {
            return;
        }
        if (target == 0 && path.size() > 0) {
            res.add(new ArrayList<>(path));
        }

        int last = -1;
        for (int i = index; i < num.length; i++) {
            // skip duplicates
            if (num[i] == last) {
                continue;
            }
            // 剪枝
            if (num[i] > target) {
                return;
            }
            last = num[i];
            path.addLast(num[i]);
            dfs(num, target - num[i], i + 1, path);
            path.removeLast();
        }
    }


    public static void main(String[] args) {

        NC46_加起来和为目标值的组合II nc46_加起来和为目标值的组合II = new NC46_加起来和为目标值的组合II();
        int[] nums = {100, 10, 20, 70, 60, 10, 50};
        ArrayList<ArrayList<Integer>> arrayLists = nc46_加起来和为目标值的组合II.combinationSum2(nums, 80);
        System.out.println(arrayLists.toString());

    }


}
