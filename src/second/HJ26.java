package second;

import java.util.Arrays;
import java.util.Scanner;

public class HJ26 {
    /**
     * 字符串排序
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String temp = s.replaceAll("[a-zA-Z]", "a");

        String[] arr = new String[36];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 字母
            if (Character.isLetter(c)) {

                //大写
                if (Character.isUpperCase(c)) {
                    if (arr[c - 'A'] == null) {
                        arr[c - 'A'] = "" + c;
                    } else {
                        arr[c - 'A'] += c;
                    }
                } else {
                    if (arr[c - 'a'] == null) {
                        arr[c - 'a'] = "" + c;
                    } else {
                        arr[c - 'a'] += c;
                    }
                }
            }
        }
        String rs = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            rs += arr[i];
        }

        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != 'a') {
                continue;
            }
            String substring = rs.substring(0, 1);
            rs = rs.substring(1);
            String left = temp.substring(0, i);
            String right = temp.substring(i + 1);
            temp = left + substring + right;
        }

        System.out.println(temp);

    }


}
