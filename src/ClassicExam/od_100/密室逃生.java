package ClassicExam.od_100;

import java.util.Arrays;
import java.util.Scanner;

public class 密室逃生 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String key = in.nextLine();
        String s2 = in.nextLine();

        String[] split = s2.split("\\,");

        for (int i = 0; i < split.length; i++) {
            if (key.length() > split[i].length()) {
                continue;
            }
            char[] chars = split[i].toLowerCase().toCharArray();
            Arrays.sort(chars);

            int sa = 0;
            for (int j = 0; j < chars.length; j++) {
                if (key.indexOf(chars[j]) != -1) {
                    sa++;
                }
            }
            if (sa == key.length()) {
                System.out.println(i+1);
                return;
            }
        }

        System.out.println(-1);

    }

}
