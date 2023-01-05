package ClassicExam.od_100;

import java.util.Scanner;

public class 最多获得的短信条数 {

    /**
     * 最多获得的短信条数
     * <p>
     * 某云短信厂商，为庆祝国庆，退出充值优惠活动
     * 先给出 客户预算，和优惠售价序列，求最多可获得的短信总条数
     * <p>
     * 输入描述：
     * <p>
     * 第一行客户预算 M 。
     * 第二行为 ：售价表，p1，p2，p3.....
     * Pi 为充值 i 元获得的短信条数
     * <p>
     * 输出：
     * 最多获得的短信条数
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int m = Integer.valueOf(in.nextLine());

        String s = in.nextLine();
        String[] split = s.split("\\ ");
        int count = 0;
        while (m > 0) {
            double max = 0.0;
            int index = 0;
            for (int i = 0; i < (m < split.length ? m : split.length); i++) {
                double avg = Integer.valueOf(split[i]) / (i + 1) * 1.0;
                if (avg > max) {
                    max = avg;
                    index = i;
                }
            }
            //花费
            count += Integer.valueOf(split[index]);
            m -= (index + 1);
        }

        System.out.println(count);

    }


}
