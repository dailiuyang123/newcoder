package ClassicExam.string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HJ71_Midum {

    /**
     * 字符串通配符
     * *  ：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
     * ？ ：匹配1个字符
     * <p>
     * 注意：匹配时不区分大小
     * <p>
     * 输入：
     * 通配符表达式；
     * 一组字符串。
     * 输出：
     * <p>
     * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String p = in.nextLine().toLowerCase();
            String s = in.nextLine().toLowerCase();

            p = p.replaceAll("\\?", "[0-9A-Za-z]{1}");
            p = p.replaceAll("\\*", "[0-9A-Za-z]{0,}");
            p = p.replaceAll("\\.", "\\\\.");
            boolean result = s.matches(p);
            System.out.println(result);

            continue;

//            if (p.indexOf('*') == -1 && p.indexOf('?') == -1) {
//                System.out.println(s.equals(p));
//                continue;
//            }
//
//            boolean hasX = false;
//            for (int i = 0; i < s.length(); i++) {
//                char c = p.charAt(i);
//                if (c != '*' && c != '?' && c != s.charAt(i)) {
//                    System.out.println(false);
//                    break;
//                }
//
//                if ((c == '*' || c == '?')) {
//                    if (c == '*') {
//                        hasX = true;
//                    }
//                    if (!Character.isLetter(s.charAt(i)) && !Character.isDefined(s.charAt(i))) {
//                        System.out.println(false);
//                        break;
//                    }
//                }
//
//
//            }


        }


    }


}
