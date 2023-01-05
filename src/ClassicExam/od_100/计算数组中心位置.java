package ClassicExam.od_100;

import java.util.Scanner;

public class 计算数组中心位置 {

    /**
     * 给你一个整数数组nums, 请计算数组的中心位置，数组的中心位置是数组的下标
     * 其左侧所有的元素相乘的积。数组第一个元素的左侧积为1，最后一个元素的右侧
     * 积为1.
     * <p>
     * 如果数组有多个中心位置，应该返回最靠近左边的那一个，如果数组不存在中心位置
     * 返回-1
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split("\\ ");

        int[] dump = new int[split.length + 1];
        dump[0] = 1;

        // 前缀和 -> 改版 -> 前缀积
        for (int i = 0; i < split.length; i++) {
            dump[i + 1] = dump[i] * Integer.valueOf(split[i]);
        }

        for (int i = 0; i < split.length; i++) {
            int left = 1;
            int right = 1;

            if (i == 0) { // 最左边
                right = dump[dump.length - 1];
            } else if (i == split.length - 1) { // 最右边
                left = dump[dump.length - 1];
            } else {
                // 中间
                left = dump[i];
                right = dump[dump.length - 1] / dump[i + 1];
            }

            if (left == right) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("-1");

    }


}
