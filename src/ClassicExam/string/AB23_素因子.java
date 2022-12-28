package ClassicExam.string;

import java.util.Scanner;

public class AB23_素因子 {


    /**
     * kotori拿到了一些正整数。她决定从每个正整数取出一个素因子。但是，kotori有强迫症，她不允许两个不同的正整数取出相同的素因子。
     * <p>
     * 她想知道，最终所有取出的数的和的最小值是多少？
     * <p>
     * 注：若 a\bmod k== 0amodk==0，则称 kk 是 aa 的因子。若一个数有且仅有两个因子，则称其是素数。显然1只有一个因子，不是素数。
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }





    }


}
