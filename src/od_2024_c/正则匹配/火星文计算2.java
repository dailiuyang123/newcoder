package od_2024_c.正则匹配;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class 火星文计算2 {
    /**
     * 2024/2/6
     * URL ：https://fcqian.blog.csdn.net/article/details/135398703
     * 题目描述：	7#6$5#12
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        // #
        Pattern pattern = compile("(\\d+)(#)(\\d+)");

        while (true) {
            Matcher matcher = pattern.matcher(s);
            if (!matcher.find()) {
                break;
            }
            String group = matcher.group();
            long[] ints = Arrays.stream(group.split("#")).mapToLong(Long::valueOf).toArray();
            long rs = ints[0] * 4 + 3 * ints[1] + 2;
            s = s.replaceFirst(group, rs + "");
        }

        // $
        // 48$58
        long rs = Arrays.stream(s.split("\\$")).mapToLong(Long::valueOf).reduce((x, y) -> 2 * x + y + 3).orElse(0L);
        System.out.println(rs);
    }


}
