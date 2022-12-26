package second;

import java.util.Scanner;

public class HJ9 {

    /**
     * 提取不重复的整数 https://www.nowcoder.com/practice/253986e66d114d378ae8de2e6c4577c1?tpId=37&tqId=21232&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?tpId=37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * <p>
     * 输入一个int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = n + "";
        int[] arr = new int[10];
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (arr[s.charAt(i) - '0'] == 0) {
                sb.append(s.charAt(i));
                arr[s.charAt(i) - '0'] = 1;
            }
        }
        System.out.println(sb.toString());

    }


}
