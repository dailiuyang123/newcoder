package ClassicExam.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class NC43_没有重复项数字的全排列 {


    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    /**
     * 给出一组数字，返回该组数字的所有排列
     * 例如：
     * [1,2,3]的所有排列如下
     * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
     * （以数字在数组中的位置靠前为优先级，按字典序排列输出。）
     * <p>
     * https://www.nowcoder.com/practice/4bcf3081067a4d028f95acee3ddcd2b1?tpId=196&tqId=37074&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?page=1&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {

        if (num.length == 0) {
            return res;
        }
        Arrays.sort(num);

        boolean[] used = new boolean[num.length];

        LinkedList<Integer> path = new LinkedList<>();

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
            path.addLast(num[i]);
            used[i] = true;
            dfs(num, path, used);
            path.removeLast();
            used[i] = false;
        }

    }


    public static void main(String[] args) {
        NC43_没有重复项数字的全排列 nc43_没有重复项数字的全排列 = new NC43_没有重复项数字的全排列();
        int[] num = {1, 2, 3};
        ArrayList<ArrayList<Integer>> permute = nc43_没有重复项数字的全排列.permute(num);
        System.out.println(permute.toString());
    }


}
