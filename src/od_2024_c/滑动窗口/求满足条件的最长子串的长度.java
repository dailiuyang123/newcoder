package od_2024_c.滑动窗口;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 求满足条件的最长子串的长度 {
    /**
     * 2024/3/20
     * URL ：abC124ACb1234x
     * abC124A1233
     * a5213123
     * 52132132a
     * 5BB9
     * b2
     * 题目描述：
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int max = -1;

//        Pattern compile = Pattern.compile("(([0-9]+)([a-zA-Z]))|(([a-zA-z])([0-9]+))|(([0-9]+)([a-zA-Z])([0-9]+))");
        Pattern compile = Pattern.compile("(([0-9]+)([a-zA-Z])(([0-9]+)?))");

        while (true) {
            Matcher matcher = compile.matcher(s);
            if (!matcher.find()) {
                break;
            }
            String group = matcher.group(0);
            max = Math.max(group.length(), max);
            System.out.println(group);
            s = s.replaceFirst(group, "");
        }


        System.out.println(max);
    }

}
