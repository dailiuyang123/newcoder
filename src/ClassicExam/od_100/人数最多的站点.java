package ClassicExam.od_100;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class 人数最多的站点 {

    /**
     * 题目描述
     * 公园园区提供小火车单向通行，从园区站点编号最小到最大通行如1~2~3~4~1，然后供员工在各个办公园区穿梭，通过对公司N个员工调研统计到每个员工的坐车区间，包含前后站点，请设计一个程序计算出小火车在哪个园区站点时人数最多。
     *
     * 输入描述
     * 第1个行，为调研员工人数
     *
     * 第2行开始，为每个员工的上车站点和下车站点。
     * 使用数字代替每个园区用空格分割，如3 5表示从第3个园区上车，在第5个园区下车
     *
     * 输出描述
     * 人数最多时的园区站点编号，最多人数相同时返回编号最小的园区站点
     *
     * 用例
     * 输入	3
     * 1 3
     * 2 4
     * 1 4
     * 输出	2
     *
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
        }

        int[] peoples = new int[5];

        for (int i = 0; i < nums.length; i++) {
            int add = nums[i][0];
            int remove = nums[i][1];

            for (int j = add; j < remove; j++) {
                    peoples[j] = peoples[j] + 1;
            }
        }

        int max = Arrays.stream(peoples).max().getAsInt();

        for (int i = 1; i < peoples.length; i++) {
            if (peoples[i] == max) {
                System.out.println(i);
            }
        }

    }


}
