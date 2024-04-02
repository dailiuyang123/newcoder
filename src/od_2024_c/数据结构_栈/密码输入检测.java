package od_2024_c.数据结构_栈;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 密码输入检测 {
    /**
     * 2024/3/28
     * URL ：https://blog.csdn.net/qfc_128220/article/details/134454085
     * 题目描述：给定用户密码输入流 input，输入流中字符 '<' 表示退格，可以清除前一个输入的字符，请你编写程序，输出最终得到的密码字符，并判断密码是否满足如下的密码安全要求。
     * <p>
     * 密码安全要求如下：
     * <p>
     * 密码长度 ≥ 8；
     * 密码至少需要包含 1 个大写字母；
     * 密码至少需要包含 1 个小写字母；
     * 密码至少需要包含 1 个数字；
     * 密码至少需要包含 1 个字母和数字以外的非空白特殊字符；
     * 注意空串退格后仍然为空串，且用户输入的字符串不包含 '<' 字符和空白字符。
     * <p>
     * 输入描述
     * 用一行字符串表示输入的用户数据，输入的字符串中 '<' 字符标识退格，用户输入的字符串不包含空白字符，例如：
     * <p>
     * ABC<c89%000<
     * <c$qRi$H<e<T$ux%R94L%e$8%87uDJt3o70%p%y%ju2mHSg%Ozi<exB<YJ7<$<N<x#%1<1K%<<C$cF<<nV2t<$Bb%#c
     * 12wdwd$<
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
