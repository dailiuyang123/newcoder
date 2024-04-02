package od_2024_c.二分三分法;

import java.util.Scanner;

public class 员工派遣_classic {
    /**
     * 2024/3/27
     * URL ：https://blog.csdn.net/qfc_128220/article/details/135050312
     * 题目描述：题目描述
     * 某公司部门需要派遣员工去国外做项目。
     * <p>
     * 现在，代号为 x 的国家和代号为 y 的国家分别需要 cntx 名和 cnty 名员工。
     * <p>
     * 部门每个员工有一个员工号（1,2,3,......），工号连续，从1开始。
     * <p>
     * 部长派遣员工的规则：
     * <p>
     * 规则1：从 [1, k] 中选择员工派遣出去
     * 规则2：编号为 x 的倍数的员工不能去 x 国，编号为 y 的倍数的员工不能去 y 国。
     * 问题：
     * <p>
     * 找到最小的 k，使得可以将编号在 [1, k] 中的员工分配给 x 国和 y 国，且满足 x 国和 y 国的需求。
     * <p>
     * 输入描述
     * 四个整数 x，y，cntx，cnty。
     * <p>
     * 2 ≤ x < y ≤ 30000
     * x 和 y 一定是质数
     * 1 ≤ cntx, cnty < 10^9
     * cntx + cnty ≤ 10^9
     * 输出描述
     * 满足条件的最小的k
     **/
    static long x;
    static long y;
    static long cntx;
    static long cnty;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        cntx = in.nextInt();
        cnty = in.nextInt();


        long l = cntx + cnty;
        long r = 1000000000L;

        long res = 0;
        while (l <= r) {

            long mid = l + (r - l) / 2;
            if (check(mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(res);
    }


    public static boolean check(long k) {
        long a = k / x;
        long b = k / y;
        long c = k / (x * y);

        return Math.max(0, cntx - (b - c)) + Math.max(0, cnty - (a - c)) <= k - a - b + c;
    }

}
