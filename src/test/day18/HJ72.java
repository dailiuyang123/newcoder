package test.day18;

import java.util.Scanner;

public class HJ72 {

    // 百钱买百鸡

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i <= 20; i++) {
            for (int m = 0; m <= 100 - i; m++) {
                int x = 100 - i - m;
                int sum = 5 * i + 3 * m + x * 1 / 3;
                if (sum == 100 && x%3==0) {
                    System.out.println(i + " " + m + " " + x);
                }
            }
        }

    }

}
