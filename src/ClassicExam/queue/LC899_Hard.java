package ClassicExam.queue;

import java.util.Arrays;

public class LC899_Hard {

    /**
     * 有序队列 https://leetcode.cn/problems/orderly-queue/
     * <p>
     * 给定一个字符串s，和一个整数 K，你可以从s的前k个字母选择一个
     * 并把它加到字符串的末尾。
     * <p>
     * 返回：在应用上述步骤的任意数量的移动后，字典上最小的字符串
     */

    public String orderlyQueue(String s, int k) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        // 划分为两个逻辑：
        // 1. 当k > 1时，无限次移动后，能够得到任意组合。 直接找出其最优解即可
        // 2. 当k = 1时，进行循环，找到最优解即可。
        if (k > 1) {
            return String.valueOf(chars);
        }

        String pretty = s;
        if (k == 1) {
            for (int i = 0; i < s.length() - 1; i++) {
                s = s.substring(1, s.length()) + s.charAt(0);
                // String.compareTo() 长度相等，返回负数，说明参数字符串比较，字典顺序，s更小更靠前。
                if (s.compareTo(pretty) < 0) {
                    pretty = s;
                }
            }
        }
        return pretty;

    }


    public static void main(String[] args) {

        LC899_Hard lc899_hard = new LC899_Hard();
        String cba = lc899_hard.orderlyQueue("cba", 1);
        System.out.println(cba);
        String a="abc";
        String b="cba";
        String c="cab";
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println(b.compareTo(c));
    }

}
