package ClassicExam.od_100;

import java.util.Arrays;
import java.util.Scanner;

public class 新学校选址问题 {

    /**
     * 题目描述
     * 为了解新学期学生暴涨的问题,小乐村要建立所新学校，
     * 考虑到学生上学安全问题,需要所有学生家到学校的距离最短。
     * 假设学校和所有学生家都走在一条直线之上,请问学校建立在什么位置，
     * 能使得到学校到各个学生家的距离和最短。
     * <p>
     * 输入描述
     * 第一行: 整数 n 取值范围 [1 ,1000 ],表示有 n户家庭。
     * 第二行: 一组整数 m 取值范围 [0, 10000 ] ，表示每户家庭的位置，所有家庭的位置都不相同。
     * <p>
     * 输出描述
     * 一个整数，确定的学校的位置。
     * 如果有多个位置，则输出最小的。
     * <p>
     * 用例
     * 输入	5
     * 0 20 40 10 30
     * 输出	20
     * 说明	20到各个家庭的距离分别为20 0 20 10 10，总和为60，最小
     * 输入	1
     * 20
     * 输出	20
     * 说明	只有一组数据，20到20距离最小，为0
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        Arrays.sort(nums);
        int length = nums.length;
        if ((length & 1) == 0) {
            System.out.println(nums[length / 2 - 1]);
        }else {
            System.out.println(nums[length/2]);
        }


    }


}
