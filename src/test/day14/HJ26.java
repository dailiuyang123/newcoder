package test.day14;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ26 {

    // 字符串排序

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        ArrayList<Character>[] list = new ArrayList[26];
        for (int i = 0; i < s.length(); i++) {
            // A-Z
            if (Character.isUpperCase(s.charAt(i))) {
                // 获取下标
                int i1 = s.charAt(i) - 'A';
                if (list[i1] == null) {
                    list[i1] = new ArrayList<Character>();
                }
                list[i1].add(s.charAt(i));
            } else if (Character.isLowerCase(s.charAt(i))) {
                int i1 = s.charAt(i) - 'a';
                if (list[i1] == null) {
                    list[i1] = new ArrayList<Character>();
                }
                list[i1].add(s.charAt(i));
            }

        }


        String s1 = "";
        for (int i = 0; i < list.length; i++) {
            List<Character> characters = list[i];
            if (characters != null) {
                for (int j = 0; j < characters.size(); j++) {
                    s1 += characters.get(j);
                }
            }
        }
        String s2 = "";

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                s2 += s1.charAt(j);
                j++;
            } else {
                s2 += s.charAt(i);
            }

        }
        System.out.println(s2);
    }


}
