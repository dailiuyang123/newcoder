package test.day17;

import java.util.Scanner;

public class HJ29 {

    // 字符串加解密

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String s1 = in.nextLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        // 加密

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int t = (c - '0') + 1 == 10 ? (c - '0') + 1 - 10 : (c - '0') + 1;
                sb.append(t);
            } else {
                if (c == 'z') {
                    sb.append('a');
                } else if (c == 'Z') {
                    sb.append('A');
                } else {
                    char t = (char) ((int) c + 1);
                    if (Character.isUpperCase(t)) {
                        t = Character.toLowerCase(t);
                    } else {
                        t = Character.toUpperCase(t);
                    }
                    sb.append(t);
                }
            }
        }

        // 解密
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (Character.isDigit(c)) {
                int t = (c - '0') == 0 ? 9 : (c - '0') - 1;
                sb1.append(t);
            } else {
                if (c == 'a') {
                    sb1.append('Z');
                } else if (c == 'A') {
                    sb1.append('z');
                } else {
                    char t = (char) ((int) c - 1);
                    if (Character.isUpperCase(t)) {
                        t = Character.toLowerCase(t);
                    } else {
                        t = Character.toUpperCase(t);
                    }
                    sb1.append(t);
                }
            }
        }

        System.out.println(sb.toString());
        System.out.println(sb1.toString());
    }
}
