package ClassicExam.string;

import java.util.*;

public class HJ96 {

    /**
     * 表示数字
     * <p>
     * https://www.nowcoder.com/practice/637062df51674de8ba464e792d1a0ac6?tpId=37&tqId=21319&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?difficulty=2&page=1&pageSize=50&search=&tpId=37&type=37&difficulty=2&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            String s = in.nextLine();

            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {

                if (stack.isEmpty()) {
                    if (Character.isDigit(s.charAt(i))) {
                        stack.push('*');
                    }
                    stack.push(s.charAt(i));
                    continue;
                }

                if (Character.isDigit(stack.peek()) && !Character.isDigit(s.charAt(i))) {
                    stack.push('*');
                }

                if (Character.isDigit(s.charAt(i)) && !Character.isDigit(stack.peek())) {
                    stack.push('*');
                }

                stack.push(s.charAt(i));

                if (Character.isDigit(s.charAt(i)) && i == (s.length() - 1)) {
                    stack.push('*');
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse());

        }


    }


}
