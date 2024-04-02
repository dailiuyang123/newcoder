package od_2024_c.二分三分法;

import java.util.Arrays;
import java.util.Scanner;

public class 机器人搬砖 {
    /**
     * 2024/3/25
     * URL ：https://blog.csdn.net/qfc_128220/article/details/134454058
     * 题目描述：题目描述
     * 机器人搬砖，一共有 N 堆砖存放在 N 个不同的仓库中，第 i 堆砖中有 bricks[i] 块砖头，要求在 8 小时内搬完。
     * <p>
     * 机器人每小时能搬砖的数量取决于有多少能量格，机器人一个小时中只能在一个仓库中搬砖，机器人的能量格只在这一个小时有效，为使得机器人损耗最小化，应尽量减小每次补充的能量格数。
     * <p>
     * 为了保障在 8 小时内能完成搬砖任务，请计算每小时给机器人充能的最小能量格数。
     * <p>
     * 无需考虑机器人补充能力格的耗时；
     * 无需考虑机器人搬砖的耗时；
     * 机器人每小时补充能量格只在这一个小时中有效；
     * 输入描述
     * 第一行为一行数字，空格分隔
     * <p>
     * 输出描述
     * 机器人每小时最少需要充的能量格，若无法完成任务，输出 -1
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Arrays.sort(array);
        if (array.length > 8) {
            System.out.println(-1);
            return;
        }

        int min = Integer.MAX_VALUE;

        int l = 0, r = array[array.length - 1];

        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (solution(mid, array)) {
                min = Math.min(mid, min);
                r = mid - 1;
             } else {
                l = mid + 1;
            }
        }
        System.out.println(min);
    }

    public static boolean solution(int res, int[] array) {
        int cost = 0;
        for (int i : array) {
            cost += i / res + (i % res == 0 ? 0 : 1);
        }
        return cost <= 8;
    }


}
