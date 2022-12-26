package test.hw;

import java.util.Scanner;

public class Hw15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int i = in.nextInt();
        int c = 0;
        if (i == 1) {
            c = 1;
        } else {
            while (i > 2) { // 注意 while 处理多个 case
                if (i % 2 != 0) {
                    i = i - (i % 2);
                    c++;
                }
                i = i / 2;
            }
            c++;
        }
        System.out.println(c);
    }
}
