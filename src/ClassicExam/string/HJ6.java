package ClassicExam.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ6 {

    /**
     * 质数因子
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int nextInt = in.nextInt();

        int sqrt = (int) Math.sqrt(nextInt);

        for (int i = 2; i <= sqrt; i++) {

            while (nextInt % i == 0) {
                System.out.println(i+" ");
                nextInt=nextInt/i;
            }
        }

        System.out.println(nextInt==1?"":nextInt+" ");

    }


}
