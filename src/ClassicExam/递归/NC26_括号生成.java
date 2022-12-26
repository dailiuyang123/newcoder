package ClassicExam.递归;

import java.util.ArrayList;

public class NC26_括号生成 {


    /**
     * 括号生成
     * https://www.nowcoder.com/practice/c9addb265cdf4cdd92c092c655d164ca?tpId=117&tqId=37748&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        recursion(0, 0, "", res, n);
        return res;

    }


    /**
     * 递归函数
     */
    public void recursion(int left, int right, String temp, ArrayList<String> res, int n) {

        if (left == n && right == n) {
            res.add(temp);
            return;
        }

        //使用一次左括号
        if (left < n) {
            recursion(left + 1, right, temp + "(", res, n);
        }

        // 使用一次右括号
        if (right < n && right < left) {
            recursion(left, right + 1, temp + ")", res, n);
        }

    }

    public static void main(String[] args) {

        NC26_括号生成 nc26_括号生成=new NC26_括号生成();
        ArrayList<String> strings = nc26_括号生成.generateParenthesis(3);
        System.out.println(strings.toString());

    }


}
