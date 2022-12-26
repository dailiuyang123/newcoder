package second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HJ20 {

    /**
     * 验证密码合格程序 https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841?tpId=37&tqId=21243&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * 密码要求：
     * 长度超过八位
     * 包括大小写字母，数字，其他字符，以上四种至少三种
     * 不能有长度大于2的包含公共元素的子串重复
     */


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String s = in.nextLine();
            int length = s.length();
            if (length <= 8) {
                System.out.println("NG");
                continue;
            }
            //
            int tag = 0;
            if (!s.equals(s.replaceAll("[a-z]", ""))) {
                tag++;
            }

            if (!s.equals(s.replaceAll("[A-Z]", ""))) {
                tag++;
            }
            if (!s.equals(s.replaceAll("[0-9]", ""))) {
                tag++;
            }
            if (!s.equals(s.replaceAll("[^0-9A-Za-z]", ""))) {
                tag++;
            }

            if (tag < 3) {
                System.out.println("NG");
                continue;
            }

            boolean issub = false;
            for (int i = 0; i + 3 <= s.length(); i++) {
                String substring = s.substring(i, i + 3);
                String s1 = s.replaceAll(Pattern.quote(substring), "");
                if (length - s1.length() > 3) {
                    issub = true;
                    break;
                }
            }
            if (issub) {
                System.out.println("NG");
            } else {
                System.out.println("OK");
            }

        }


    }


}
