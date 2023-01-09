package ClassicExam.od_200;

import java.util.Scanner;

public class 二进制差异数_位运算 {

    /**
     * 题目描述
     * 对于任意两个正整数A和B，定义它们之间的差异值和相似值：
     * 差异值：A、B转换成二进制后，对于二进制的每一位，对应位置的bit值不相同则为1，否则为0；
     * 相似值：A、B转换成二进制后，对于二进制的每一位，对应位置的bit值都为1则为1，否则为0；
     * 现在有n个正整数A0到A（n-1），问有多少(i, j) (0<=i<j<n），Ai和Aj的差异值大于相似值。
     * 假设A=5，B=3；则A的二进制表示101；B的二进制表示011；
     * 则A与B的差异值二进制为110；相似值二进制为001；
     * A与B的差异值十进制等于6，相似值十进制等于1，满足条件。
     * <p>
     * 输入描述
     * 一个n接下来n个正整数
     * <p>
     * 数据范围：1<=n<=10^5，1<=A[i]<2^30
     * <p>
     * 输出描述
     * 满足差异值大于相似值的对数
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int A = nums[i];
                int B = nums[j];
                // 对于二进制的每一位，对应位置的bit值不相同则为1，否则为0；
                int cha = A ^ B;
                // 对于二进制的每一位，对应位置的bit值都为1则为1，否则为0；
                int like = A & B;
                if (cha > like) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }


}
