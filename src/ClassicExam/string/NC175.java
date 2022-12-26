package ClassicExam.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class NC175 {

    /**
     * 有效括号
     * https://www.nowcoder.com/practice/eceb50e041ec40bd93240b8b3b62d221?tpId=196&tqId=39324&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&tags=592&difficulty=undefined&judgeStatus=undefined&tags=592&title=
     */
    public boolean isValidString(String s) {
        // write code here

        // todo 注意要声明两个栈 一个为 "（" ，另一个为：" * "
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                left.push(i);
            }
            if (c == '*') {
                star.push(i);
            }

            if (c == ')') {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        // todo  当星号 作为 右括号" ）" 时。
        while (!left.isEmpty() && !star.isEmpty()) {
            Integer pop = left.pop();
            Integer pop1 = star.pop();
            if (pop1 < pop) {
                return false;
            }
        }

        return left.isEmpty();

    }

    public static void main(String[] args) {

        NC175 nc175 = new NC175();
        boolean validString = nc175.isValidString("(*)");
        System.out.println(validString);

    }


}
