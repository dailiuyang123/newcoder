package od_2024_c.随机;

import java.util.Scanner;

public class 执行时长 {
    /**
     * 2024/4/22
     * URL ：https://hydro.ac/d/HWOD2023/p/OD219
     * 题目描述：
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int n = in.nextInt();

        int[] jobs = new int[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = in.nextInt();
        }

        int res = 0;
        int index = 0;
        int cost = 0;

        while (res > 0 || index < n) {
            if (index < n) {
                res += jobs[index];
                index++;
            }

            if (res <= x) {
                res = 0;
            } else {
                res -= x;
            }
            cost++;
        }

        System.out.println(cost);
    }

}
