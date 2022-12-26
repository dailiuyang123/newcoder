package test.day15;

import java.util.Scanner;

public class HJ97 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int f = 0, z = 0, sum = 0;
            for (int i = 0; i < n; i++) {
                int v = in.nextInt();
                if (v > 0) {
                    sum += v;
                    z++;
                }
                if (v < 0) {
                    f++;
                }
            }

            System.out.println(f + " " + String.format("%.1f", (double) sum / z));
        }
    }
}
