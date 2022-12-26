package ClassicExam.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class NC318 {

    /**
     * 字符的相邻字符串去重 https://www.nowcoder.com/practice/8c7d55263c624faa8e48a16d92c2e90d?tpId=196&tqId=40332&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */

    public String removeDuplicates(String s) {
        // write code here
        int begin = 0;

        Deque<Character> stack = new ArrayDeque<>();
        while (begin < s.length()) {
            char c = s.charAt(begin);
            //入栈
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            }else {  // 出栈
                stack.pop();
            }
            begin++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {

        NC318 nc318=new NC318();
        String s="bcaace";
        String s1 = nc318.removeDuplicates(s);
        System.out.println(s1);

    }


}
