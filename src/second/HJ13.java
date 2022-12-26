package second;

import java.util.Scanner;

public class HJ13 {

    /**
     * 句子逆序
     * <p>
     * 讲一个英文语句以单词为单位逆序排放，
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int length = s1.length;
        if (length <= 1) {
            System.out.println(s);
            return;
        }
        for (int i = 0; i < length / 2; i++) {
            String v = s1[i];
            s1[i] = s1[length - i - 1];
            s1[length - i - 1] = v;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(s1[i]).append(" ");
        }
        System.out.println(sb);

    }


}
