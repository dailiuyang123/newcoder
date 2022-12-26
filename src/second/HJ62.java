package second;

import java.util.Scanner;

public class HJ62 {

    /**
     * 查找输入整数二进制中1的个数
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int nextInt = in.nextInt();
            String s = Integer.toBinaryString(nextInt);
            System.out.println(s.replaceAll("0", "").length());
        }

    }


}
