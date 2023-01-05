package ClassicExam.od_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 对称美学 {

    /**
     * 对称就是最大的美学，现有一道关于对称字符串的美学。已知：
     * <p>
     * 第1个字符串 ：R
     * 第2个字符串 ：BR
     * 第3个字符串 ：PBBR
     * 第4个字符串 ：BRRBRBBR
     * 第5个字符串 ：RBBRBRRBBRRBRBBR
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        Map<Character, Character> map = new HashMap<>();
        map.put('R', 'B');
        map.put('B', 'R');

        String[] cache = new String[21];

        cache[0] = "R";
        for (int i = 1; i < cache.length; i++) {
            StringBuilder sb = new StringBuilder(cache[i - 1]);
            cache[i] = sb.reverse().append(sb).toString();
        }

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            char c = cache[n - 1].charAt(k);
            if (c == 'R') {
                System.out.println("red");
            } else {
                System.out.println("blue");
            }
        }

    }

    public static void main2(String[] args) {


        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {

            int n = in.nextInt();
            int k = in.nextInt();
            int count = (int) Math.pow(2, n - 1);
            int half = count / 2;

            while (n > 1) {
                n--;
                half = half / 2;
                if ((k + 1) > half) {
                    k = k - half;
                } else {

                }
            }


        }


    }

}
