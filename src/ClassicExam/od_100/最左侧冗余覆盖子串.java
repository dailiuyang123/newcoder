package ClassicExam.od_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 最左侧冗余覆盖子串 {

    /**
     * 给定两个字符串 s1 和 s2 和正整数k,其中s1长度为n1,s2的长度为n2
     * 在s2中选一个子串，满足：
     * <p>
     * 1. 该子串的长度为 n1+k
     * 2. 该子串中包含s1中全部字母
     * 3. 该子串每个字母出现的次数不小于s1中对应的字母
     * <p>
     * 我们称s2 以长度k冗余覆盖s1，
     * 给定s1，s2, k
     * 求最左侧的s2 以长度k 冗余覆盖s1的子串的首个元素的下标
     * <p>
     * 输入为三行
     * <p>
     * 第1行  s1
     * 第2行  s2
     * 第3行  k
     * s1,s2都只包含小写字母
     * <p>
     * 输出：
     * <p>
     * 最左侧的s2以长度为k冗余覆盖s1的子串的首个元素下标，若不存在，返回-1
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        int k = in.nextInt();

        int length = s1.length() + k;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        for (int i = 0; i + length <= s2.length(); i++) {

            String substring = s2.substring(i, i + length);

            Map<Character, Integer> temp = new HashMap<>();

            for (int j = 0; j < substring.length(); j++) {
                char c = substring.charAt(j);
                temp.put(c, temp.getOrDefault(c, 0) + 1);
            }

            boolean istrue = true;
            // 判断条件
            for (Character character : map.keySet()) {

                // 包含全部字母
                if (!temp.containsKey(character)) {
                    istrue = false;
                    break;
                }
                // 次数不小于s1
                if (temp.get(character) < map.get(character)) {
                    istrue = false;
                    break;
                }
            }

            if (istrue) {
                System.out.println(i);
                return;
            }

        }


        System.out.println("-1");

    }


}
