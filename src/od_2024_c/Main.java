package od_2024_c;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /**
     * 2024/2/5
     * URL ：
     * 题目描述：
     **/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Pattern compile = Pattern.compile(".(\\<)");
        while (true) {
            Matcher m = compile.matcher(s);
            if (m.find()) {
                String group = m.group();
                s = s.replace(group, "");
            } else {
                break;
            }
        }

        // todo 因为输入不包含 "<",所以同样要去除掉
        s = s.replace("<", "");
        if (s.length() < 8) {
            System.out.println(s + "," + false);
        } else {
            boolean b = Pattern.compile("[a-z]").matcher(s).find();
            boolean c = Pattern.compile("[A-Z]").matcher(s).find();
            boolean d = Pattern.compile("[0-9]").matcher(s).find();
            boolean e = Pattern.compile("[^a-zA-Z0-9]").matcher(s).find();

            if (b && c && d && e) {
                System.out.println(s + "," + true);
            } else {
                System.out.println(s + "," + false);
            }

        }
    }





}
