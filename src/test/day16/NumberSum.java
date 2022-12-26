package test.day16;

import java.util.Scanner;

public class NumberSum {

//整数拆分为连续自然数之和


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(n + "=" + n);
        for (int i = 2; i <= n / 2; i++) {
            // 必然是奇数个
            if (n % i == 0 && i % 2 == 1) {
                String str = n + "=";
                int avg = n / i;
                for (int j = avg - (i - 1) / 2; j <= avg + (i - 1) / 2; j++) {
                    str += j + "+";
                }
                System.out.println(str.substring(0, str.length() - 1));
            }
            if (i % 2 == 0) {
                String str = n + "=";
                int min_avg = (n - n % i) / i;
                int max_avg = min_avg + 1;
                if ((min_avg + max_avg) * i / 2 == n) {
                    for (int j = min_avg - i / 2 + 1; j <= min_avg + i / 2; j++) {
                        str += j + "+";
                    }
                    System.out.println(str.substring(0, str.length() - 1));
                }
            }
        }

    }

}
