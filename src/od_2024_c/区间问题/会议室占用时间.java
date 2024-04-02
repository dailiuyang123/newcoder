package od_2024_c.区间问题;

import java.util.Arrays;
import java.util.Scanner;

public class 会议室占用时间 {
    /**
     * 2024/3/27
     * URL ：https://blog.csdn.net/qfc_128220/article/details/134939442
     * 题目描述：题目描述
     * 现有若干个会议，所有会议共享一个会议室，用数组表示各个会议的开始时间和结束时间，格式为：
     * <p>
     * [[会议1开始时间, 会议1结束时间], [会议2开始时间, 会议2结束时间]]
     * <p>
     * 请计算会议室占用时间段。
     * <p>
     * 输入描述
     * 第一行输入一个整数 n，表示会议数量
     * <p>
     * 之后输入n行，每行两个整数，以空格分隔，分别表示会议开始时间，会议结束时间
     * <p>
     * 输出描述
     * 输出多行，每个两个整数，以空格分隔，分别表示会议室占用时间段开始和结束
     * <p>
     * 备注
     * 会议室个数范围：[1, 100]
     * 会议室时间段：[1, 24]
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
        }

        Arrays.sort(nums, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });


        int l = nums[0][0];
        int r = nums[0][1];
        for (int i = 1; i < n; i++) {

            int t_l = nums[i][0];
            int t_r = nums[i][1];
            if (t_l <= r) {
                r = Math.max(r, t_r);
            } else {
                System.out.println(l + " " + r);
                l = t_l;
                r = t_r;
            }
        }
        System.out.println(l + " " + r);
    }


}
