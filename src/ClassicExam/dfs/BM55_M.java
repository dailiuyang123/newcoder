package ClassicExam.dfs;

import java.util.*;
import java.util.stream.Collectors;

public class BM55_M {

    /**
     * 没有重复项数字的全排列
     * https://www.nowcoder.com/practice/4bcf3081067a4d028f95acee3ddcd2b1?tpId=295&tqId=701&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=/exam/oj
     * <p>
     * 给出一组数字，返回该组数字的所有的排列
     */

    public ArrayList<ArrayList<Integer>> permute(int[] num) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (num.length == 0) {
            return res;
        }
        if (num.length == 1) {
            List<Integer> collect = Arrays.stream(num).boxed().collect(Collectors.toList());
            res.add((ArrayList<Integer>) collect);
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();

        boolean[] used = new boolean[num.length];

        int index = 0;

        dfs(res, path, num, used, index);

        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        return res;

    }

    private void dfs(ArrayList<ArrayList<Integer>> res, Deque<Integer> path, int[] num, boolean[] used, int index) {

        if (path.size() == num.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = index; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            path.push(num[i]);
            used[i] = true;
            dfs(res, path, num, used, index);
            // 回退
            path.pop();
            used[i] = false;
        }
    }


    public static void main(String[] args) {

        BM55_M bm55_m = new BM55_M();
        int[] num = {1, 2, 3};
        ArrayList<ArrayList<Integer>> permute = bm55_m.permute(num);

        System.out.println(permute.toString());
    }

}
