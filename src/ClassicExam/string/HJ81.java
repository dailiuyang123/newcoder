package ClassicExam.string;

import java.util.Scanner;

public class HJ81 {

    /**
     * 字符串字符匹配
     * <p>
     * https://www.nowcoder.com/practice/22fdeb9610ef426f9505e3ab60164c93?tpId=37&tqId=21304&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?difficulty=2&page=1&pageSize=50&search=&tpId=37&type=37&difficulty=2&judgeStatus=undefined&tags=&title=
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {

            String s = in.nextLine();
            String s2 = in.nextLine();
            String rs = "true";
            for (int i = 0; i < s.length(); i++) {
                if (s2.indexOf(s.charAt(i)) == -1) {
                    rs = "false";
                    break;
                }
            }
            System.out.println(rs);
        }

    }


}
