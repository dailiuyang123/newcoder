package ClassicExam.od_100;

import java.util.Scanner;

public class 不含101的数 {


    /**
     * 现给定一个整数区间[l,r],请问这个区间包含了多少个不含101的数字
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int l = in.nextInt();
        int r = in.nextInt();

        int count = 0;
        for (int i = l; i <= r; i++) {
            if (!Integer.toBinaryString(i).contains("101")) {
                count++;
            }
        }

        System.out.println(count);

    }


}
