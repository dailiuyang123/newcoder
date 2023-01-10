package ClassicExam.od_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 最大数字 {

    /**
     *  题目描述
     * 给定一个由纯数字组成以字符串表示的数值，现要求字符串中的每个数字最多只能出现2次，超过的需要进行删除；
     *
     * 删除某个重复的数字后，其它数字相对位置保持不变。
     *
     * 如”34533″，数字3重复超过2次，需要删除其中一个3，删除第一个3后获得最大数值”4533″
     *
     * 请返回经过删除操作后的最大的数值，以字符串表示。
     *
     * 输入描述
     * 第一行为一个纯数字组成的字符串，长度范围：[1,100000]
     *
     * 输出描述
     * 输出经过删除操作后的最大的数值
     *
     * 用例
     * 输入	34533
     * 输出	4533
     *
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(getResult(str));
    }

    public static String getResult(String str) {
        HashMap<Character, Integer> count = new HashMap<>();

        // 统计输入字符串中各字符出现的次数
        for (int i = 0; i < str.length(); i++) {
            Character k = str.charAt(i);
            count.put(k, count.getOrDefault(k, 0) + 1);
        }

        // ans记录题解
        ArrayList<Character> ans = new ArrayList<>();

        // has用于记录ans中各个保留字符已经有了几个
        HashMap<Character, Integer> has = new HashMap<>();

        // 遍历输入字符串的各个字符
        for (int i = 0; i < str.length(); i++) {
            Character cur = str.charAt(i);

            // 如果遍历的字符在输入字符串中总出现次数小于等于2次，则直接保留
            if (count.containsKey(cur) && count.get(cur) <= 2) {
                ans.add(cur);
                continue;
            }

            // 如果遍历的字符在输入字符串中总出现次数大于2次，则需要考虑剔除该字符
            int j = i + 1;
            if (j < str.length()) {
                char next = str.charAt(j);

                has.putIfAbsent(cur, 0);

                int curHas = has.get(cur);
                // 如果当前遍历字符的数值大于下一个字符，且当前遍历字符已保留个数小于2个，则可以保留
                if (cur > next && curHas < 2) {
                    ans.add(cur);
                    has.put(cur, ++curHas);
                } else {
                    // 否则不保留
                    count.put(cur, count.get(cur) - 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character an : ans) {
            sb.append(an);
        }
        return sb.toString();
    }


}
