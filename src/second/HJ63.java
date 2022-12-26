package second;

import java.util.Scanner;

public class HJ63 {
    /**
     * DNA 序列
     * <p>
     * 一个DNA序列由A/C/G/T 四个字母排列组合组成
     * G 和 C 的比例 是序列种 G和C两个字母的总的出现次数除以总的字母数目（序列长度）。
     * 在基因工程中，这个比例非常重要。
     * <p>
     * 给定一个DNA序列，以及限定的子串长度N，请帮助研究人员在给出的DNA序列中
     * 从左往右找出 gc 最高 且长度为 n 的第一个子串
     */

    // 滑动窗口
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int n = in.nextInt();

        double ratio = 0f;
        String substrings = "";
        // 如果截取的字符串长度为全长度，则直接返回
        if (s.length() <= n) {
            System.out.println(s);
            return;
        }
        for (int i = 0; i + n < s.length(); i++) {
            String substring = s.substring(i, i + n);
            String s1 = substring.replaceAll("[G|C]", "");
            double a = (double) (n - s1.length()) / n;
            if (a > ratio) {
                substrings = substring;
                ratio = a;
            }
        }

        System.out.println(substrings);

    }


}
