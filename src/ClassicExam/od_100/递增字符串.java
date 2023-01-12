package ClassicExam.od_100;

import java.util.Map;
import java.util.Scanner;

public class 递增字符串 {

    /**
     * 题目描述
     * 定义字符串完全由 ‘A’ 和 ‘B’组成，当然也可以全是’A’或全是’B’。如果字符串从前往后都是以字典序排列的，那么我们称之为严格递增字符串。
     * 给出一个字符串s，允许修改字符串中的任意字符，即可以将任何的’A’修改成’B’，也可以将任何的’B’修改成’A’，
     * 求可以使s满足严格递增的最小修改次数。
     * <p>
     * 0 < s的长度 < 100000。
     * <p>
     * 输入描述
     * 输入一个字符串： “AABBA”
     * <p>
     * 输出描述
     * 输出：1
     * <p>
     * 用例
     * 输入	AABBA
     * 输出	1
     * 说明	修改最后一位得到AABBB。
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        if (s.length() == 1) {
            System.out.println(0);
            return;
        }

        // 第一个B 后边的 A 修改为B
        int B = s.indexOf("B");
        // 最后一个 A 前边的B 改为 A
        int A = s.lastIndexOf("A");

        int b = s.substring(B + 1).replaceAll("B", "").length();
        int a = s.substring(0, A).replaceAll("A", "").length();

        System.out.println(Math.min(b, a));

    }


}
