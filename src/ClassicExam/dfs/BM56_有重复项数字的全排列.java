package ClassicExam.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BM56_有重复项数字的全排列 {


    /**
     * 有重复项数字的全排列
     * <p>
     * 给出一组可能包含重复项的数字，返回该组数字的所有排列。结果以字典序升序排列。
     * <p>
     * https://www.nowcoder.com/practice/a43a2b986ef34843ac4fdd9159b69863?tpId=295&tqId=700&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=/exam/oj
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

        Arrays.sort(num);

        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[num.length];

        dfs(num, path, used);
        return res;
    }

    public void dfs(int[] num, LinkedList<Integer> path, boolean[] used) {

        if (path.size() == num.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            //  todo 剪枝
            if (i > 0 && (num[i - 1] == num[i]) && (!used[i - 1])) {
                continue;
            }
            path.addLast(num[i]);
            used[i] = true;
            dfs(num, path, used);
            //回退
            path.removeLast();
            used[i] = false;
        }
    }


    public static void main(String[] args) {

        BM56_有重复项数字的全排列 bm56 = new BM56_有重复项数字的全排列();
        int[] nums = {2, 1, 1};
        ArrayList<ArrayList<Integer>> arrayLists = bm56.permuteUnique(nums);
        System.out.println(arrayLists.toString());

    }


}
