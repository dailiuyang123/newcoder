package od_2024_c.正则匹配;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class 提取字符串中的最长合法简单数学表达式 {
    /**
     * 2024/2/14
     * URL ：2-355*4
     * 题目描述：
     **/

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String maxStr = "";
        Matcher matcher = compile("((\\d+[\\+\\-\\*])*\\d+)").matcher(s);
        while (matcher.find()) {
            String group = matcher.group(0);
            if (group.length() > maxStr.length()) {
                maxStr = group;
            }
        }
        // todo 注意：测试用例：abc
        if (maxStr.length() > 0) {
            long eval = eval(maxStr);
            System.out.println(eval);
        } else {
            System.out.println(0);
        }


    }

    public static long eval(String exp) {

        LinkedList<Long> stack = new LinkedList<>();
        StringBuilder numStr = new StringBuilder();
        long coef = 1;

        char begin = exp.charAt(0);
        if (begin == '+' || begin == '-') {
            exp = exp.substring(1);
        }

        if (begin == '-') {
            coef = -1;
        }

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c >= '0' && c <= '9') {
                numStr.append(c);
                continue;
            }

            stack.push(coef * Long.parseLong(numStr.toString()));
            numStr = new StringBuilder();

            switch (c) {
                case '+':
                    coef = 1;
                    break;
                case '-':
                    coef = -1;
                    break;
                case '*':
                    coef = stack.pop();
                    break;
            }
        }

        if (numStr.length() > 0) {
            stack.push(coef * Long.parseLong(numStr.toString()));
        }

        long res = 0;
        for (Long aLong : stack) {
            res += aLong;
        }
        return res;
    }


}
