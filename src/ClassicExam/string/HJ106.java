package ClassicExam.string;

import java.util.Scanner;

public class HJ106 {

    /**
     * 字符逆序
     * https://www.nowcoder.com/practice/cc57022cb4194697ac30bcb566aeb47b?tpId=37&tqId=21329&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?difficulty=2&page=1&pageSize=50&search=&tpId=37&type=37&difficulty=2&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){

            String s = in.nextLine();
            StringBuilder stringBuilder=new StringBuilder(s);
            System.out.println(stringBuilder.reverse().toString());

        }


    }


}
