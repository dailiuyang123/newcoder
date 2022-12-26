package second;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HJ45 {

    /**
     * 名字的漂亮度  https://www.nowcoder.com/practice/02cb8d3597cf416d9f6ae1b9ddc4fde3?tpId=37&tqId=21268&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * <p>
     * 给出一个字符串 ，该字符串仅由小写字母组成，定义这个字符串的漂亮度是其
     * 所有字母漂亮度的总和
     * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
     * <p>
     * 给出多个字符串，计算每个字符串最大可能的“漂亮度”。
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int nextInt = in.nextInt();
            for (int i = 0; i < nextInt; i++) {
                String s = in.next();
                HashMap<Character, Integer> map = new HashMap<>();
                for (int j = 0; j < s.length(); j++) {
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                }

                List<Integer> collect = map.values().stream().sorted((a, b) -> b - a).collect(Collectors.toList());
                int max = 0;
                for (int j = 0; j < collect.size(); j++) {
                    max += (26 - j) * collect.get(j);
                }
                System.out.println(max);
            }
        }
    }


}
