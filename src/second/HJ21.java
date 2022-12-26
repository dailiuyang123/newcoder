package second;

import java.util.Scanner;

public class HJ21 {
    /**
     * 简单密码
     */


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'z' <= 0) {
                int index = s.charAt(i) - 'a';
                if (index <= 14) {
                    sb.append((index + 1) % 3 == 0 ? (index + 1) / 3 + 1 : (index + 1) / 3 + 2);
                } else if (index <= 18) {
                    sb.append(7);
                } else if (index <= 21) {
                    sb.append(8);
                } else {
                    sb.append(9);
                }
            } else if (s.charAt(i) - 'A' >= 0 && s.charAt(i) - 'Z' <= 0) {
                if (s.charAt(i) == 'Z') {
                    sb.append('a');
                } else {
                    char c = (char) (s.charAt(i) + 1);
                    sb.append(c);
                }
            } else {
                sb.append(s.charAt(i));
            }

        }

        System.out.println(sb.toString().toLowerCase());
    }


}
