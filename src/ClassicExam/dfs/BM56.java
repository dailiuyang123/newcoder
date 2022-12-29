package ClassicExam.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BM56 {


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
        List<String> temp = new ArrayList<>();

        dfs(num, 0, path, used, temp);
        return res;
    }

    public void dfs(int[] num, int index, LinkedList<Integer> path, boolean[] used, List<String> temp) {

        if (path.size() == num.length) {
            String string = path.toString();
            if (!temp.contains(string)) {
                res.add(new ArrayList<Integer>(path));
                temp.add(string);
            }
            return;
        }


        for (int i = index; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(num[i]);
            used[i] = true;
            dfs(num, index, path, used, temp);
            //回退
            path.removeLast();
            used[i] = false;
        }
    }


    public static void main(String[] args) {

        BM56 bm56 = new BM56();
        int[] nums = {2,1,1};
        ArrayList<ArrayList<Integer>> arrayLists = bm56.permuteUnique(nums);
        System.out.println(arrayLists.toString());

    }


}
