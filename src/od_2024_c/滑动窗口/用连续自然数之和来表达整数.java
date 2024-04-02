package od_2024_c.滑动窗口;

import java.util.Scanner;

public class 用连续自然数之和来表达整数 {
    /**
     * 2024/3/20
     * URL ：https://fcqian.blog.csdn.net/article/details/127341945
     * 题目描述：
     **/
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        System.out.println(n + "=" + n);
        int cnt = 1;

        for (int i = 2; i < n; i++) {
            int avg = n / i;
            for (int j = 1; j <= avg; j++) {
                int r = j + i - 1;
                if (sums(j, r)) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = j; k <= r; k++) {
                        sb.append(k).append("+");
                    }
                    System.out.println(n+"=" + sb.substring(0,sb.length()-1));
                    cnt++;
                    break;
                }
            }
        }

        System.out.println("Result:" + cnt);


    }

    public static boolean sums(int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            res += i;
        }
        return res == n;
    }

}
