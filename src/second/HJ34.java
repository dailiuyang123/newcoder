package second;

import java.util.Arrays;
import java.util.Scanner;

public class HJ34 {

    /**
     * 图片整理 https://www.nowcoder.com/practice/2de4127fda5e46858aa85d254af43941?tpId=37&tqId=21257&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }

        System.out.println(sb);

    }


}
