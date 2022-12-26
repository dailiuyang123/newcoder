package second;

import java.util.Scanner;

public class HJ97 {

    /**
     * 记负均正 https://www.nowcoder.com/practice/6abde6ffcc354ea1a8333836bd6876b8?tpId=37&tqId=21320&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?difficulty=2&page=1&pageSize=50&search=&tpId=37&type=37&difficulty=2&judgeStatus=undefined&tags=&title=
     * <p>
     * 首先收入要输入的整数个数n，然后输入n个整数。输出为n 个整数中负数的个数，和所有正整数的平均数，结果保留一位小数
     */

    public static void main(String[] args) {
        int a = 5992;
        int b = 30;
        System.out.println((double) (a / b));
        System.out.println((double) a / b);
        System.out.println(String.format("%.2f", (double) (a / b)));
        System.out.println((double) a * 1.0 / b);

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int sum = 0;
            int zheng = 0;
            int zero = 0;
            for (int i = 0; i < n; i++) {
                int nextInt = in.nextInt();
                if (nextInt > 0) {
                    zheng++;
                    sum += nextInt;
                }
                if (nextInt == 0) {
                    zero++;
                }
            }
            String avg = zheng != 0 ? String.format("%.1f", (double) (sum / zheng)) : "0.0";

            System.out.println(n - zheng - zero + " " + avg);
        }
    }


}





