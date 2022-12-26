package second;

import java.util.Scanner;

public class HJ4 {

    /**
     * 字符串分割  https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?difficulty=2&page=1&pageSize=50&search=&tpId=37&type=37&difficulty=2&judgeStatus=undefined&tags=&title=
     * <p>
     * 输入一个字符串，请安长度为8拆分每个输入字符串并进行输出
     */


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String s = in.nextLine();

            int length = s.length();
            if (length == 0) {
                continue;
            }

            int add = length > 8 ? (8 - length % 8) : 8 - length;

            if (add < 8) {
                for (int i = 0; i < add; i++) {
                    s += "0";
                }
            }

            int times = s.length() / 8;
            for (int i = 0; i < times; i++) {
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }


    }


}
