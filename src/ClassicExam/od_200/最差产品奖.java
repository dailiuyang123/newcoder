package ClassicExam.od_200;

import java.util.Scanner;

public class 最差产品奖 {

    /**
     * 题目描述
     * A公司准备对他下面的N个产品评选最差奖，
     * 评选的方式是首先对每个产品进行评分，然后根据评分区间计算相邻几个产品中最差的产品。
     * 评选的标准是依次找到从当前产品开始前M个产品中最差的产品，请给出最差产品的评分序列。
     * <p>
     * 输入描述
     * 第一行，数字M，表示评分区间的长度，取值范围是0<M<10000
     * 第二行，产品的评分序列，比如[12,3,8,6,5]，产品数量N范围是-10000 < N <10000
     * <p>
     * 输出描述
     * 评分区间内最差产品的评分序列
     * <p>
     * 用例
     * 输入	3
     * 12,3,8,6,5
     * 输出	3,3,5
     * 说明
     * 12,3,8 最差的是3
     * <p>
     * 3,8,6 最差的是3
     * <p>
     * 8,6,5 最差的是5
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int len = Integer.valueOf(s);
        String s2 = in.nextLine();

        String[] split = s2.split("\\,");


        int l = 0;
        int r = len - 1;
        while (r < split.length) {
            int min = Integer.valueOf(split[l]);
            for (int i = l; i <= r; i++) {
                min = Math.min(min, Integer.valueOf(split[i]));
            }
            System.out.print(min);
            if (r != split.length) {
                System.out.print(",");
            }
            l++;
            r++;
        }


    }


}
