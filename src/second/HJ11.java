package second;

import java.util.Scanner;

public class HJ11 {

    /**
     * 数字颠倒 https://www.nowcoder.com/practice/ae809795fca34687a48b172186e3dafe?tpId=37&tqId=21234&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     *
     *
     *
     */

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);

        int nextInt = in.nextInt();
        StringBuffer sb=new StringBuffer(nextInt+"");
        System.out.println(sb.reverse().toString());

    }


}
