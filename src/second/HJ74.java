package second;

import java.util.*;

public class HJ74 {

    /**
     * 参数解析 https://www.nowcoder.com/practice/668603dc307e4ef4bb07bcd0615ea677?tpId=37&tqId=21297&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * 在命令行输入一下信息
     * xcopy /s c:\\ d:\\e，
     * <p>
     * 各个参数如下：
     * <p>
     * 参数1：命令字xcopy
     * <p>
     * 参数2：字符串/s
     * <p>
     * 参数3：字符串c:\\
     * <p>
     * 参数4: 字符串d:\\e
     * <p>
     * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        List<String> list = new ArrayList<>();


        Deque<Character> stack = new ArrayDeque<>();

        Character begin = ' ';

        for (int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);

            if (begin != null && c == '"' && c.equals(begin)) {
                StringBuffer sb = new StringBuffer();
                // 出栈
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                if (sb.length() > 0) {
                    list.add(sb.reverse().toString());
                }
                begin = ' ';
                // 重置栈，标记符
                continue;
            }

            // 出栈
            if (begin != null && c == ' ' && begin.equals(c)) {
                // 出栈
                StringBuffer sb = new StringBuffer();
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                if (sb.length() > 0) {
                    list.add(sb.reverse().toString());
                }
                // 重置栈，标记符
                continue;
            }

            // 入栈
            if (c == '"') {
                begin = '"';
                continue;
            }
            stack.push(c);

        }

        if (!stack.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            list.add(sb.reverse().toString());
        }

        System.out.println(list.size());
        for (String s1 : list) {
            System.out.println(s1);
        }

    }


    public static void main2(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();





    }


}
