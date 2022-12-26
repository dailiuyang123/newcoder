package second;

import java.util.Scanner;

public class NC101 {

    /**
     * 字符串压缩
     *
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        char curr = 0;
        int size = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == curr) {
                size++;
            } else {
                if (size > 1) {
                    sb.append(size).append(s.charAt(i));
                    curr = s.charAt(i);
                    size = 1;
                } else {
                    curr = s.charAt(i);
                    sb.append(s.charAt(i));
                }
                //
            }
        }
        if (size > 1) {
            sb.append(size);
            size = 1;
        }
        System.out.println(sb);

    }


}
