package od_2024_c;

import java.util.Scanner;

public class 找座位 {
    /**
     * 2024/1/30
     * URL ：
     * 题目描述：
     **/


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int c = s.length() - s.replaceAll("1", "").length();
        String s1 = s.replaceAll("000", "010");
        int a = s.length() - s1.replaceAll("1", "").length();
        System.out.println(a - c);


    }

}
