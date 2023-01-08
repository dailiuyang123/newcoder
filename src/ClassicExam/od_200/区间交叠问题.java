package ClassicExam.od_200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 区间交叠问题 {

    /**
     * 题目描述
     * 给定坐标轴上的一组线段，线段的起点和终点均为整数并且长度不小于1，
     * 请你从中找到最少数量的线段，这些线段可以覆盖柱所有线段。
     * <p>
     * 输入描述
     * 第一行输入为所有线段的数量，不超过10000，后面每行表示一条线段，
     * 格式为"x,y"，x和y分别表示起点和终点，取值范围是[-10^5，10^5]。
     * <p>
     * 输出描述
     * 最少线段数量，为正整数
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Integer n = Integer.valueOf(in.nextLine());

        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] split = s.split("\\,");
            nums[i][0] = Integer.valueOf(split[0]);
            nums[i][1] = Integer.valueOf(split[1]);
        }

        // ToDo 注意自定义排序，起点按照正序排序，起点相同的话，按照终点倒序
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        int end = nums[n - 1][1];
        int count = 1;

        // 采用双指针解法
        int l = nums[0][0];
        int r = nums[0][1];

        int index = 1;
        while (r <= end) {
            if (r == end) {
                break;
            }
            int max = 0;
            for (int i = index; i < n; i++) {
                if (nums[i][0] > l && nums[i][0] <= r && nums[i][1] > r) {
                    if (nums[i][1] > max) {
                        max = nums[i][1];
                        index = i;
                    }
                }
            }

            l = r;
            r = max;
            count++;

        }

        System.out.println(count);

    }


}
