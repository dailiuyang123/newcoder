package ClassicExam.od_200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class 字符串解密 {

    /**
     * 题目描述
     * 给定两个字符串string1和string2。
     * string1是一个被加扰的字符串。
     * <p>
     * string1由小写英文字母（’a’~’z’）和数字字符（’0’~’9’）组成，而加扰字符串由’0’~’9’、’a’~’f’组成。
     * <p>
     * string1里面可能包含0个或多个加扰子串，剩下可能有0个或多个有效子串，这些有效子串被加扰子串隔开。
     * <p>
     * string2是一个参考字符串，仅由小写英文字母（’a’~’z’）组成。
     * <p>
     * 你需要在string1字符串里找到一个有效子串，这个有效子串要同时满足下面两个条件：
     * <p>
     * （1）这个有效子串里不同字母的数量不超过且最接近于string2里不同字母的数量，即小于或等于string2里不同字母的数量的同时且最大。
     * <p>
     * （2）这个有效子串是满足条件（1）里的所有子串（如果有多个的话）里字典序最大的一个。
     * <p>
     * 如果没有找到合适条件的子串的话，请输出”Not Found”
     * <p>
     * 输入描述
     * input_string1
     * input_string2
     * <p>
     * 输出描述
     * output_string
     * <p>
     * 用例
     * 输入	123admyffc79pt
     * ssyy
     * 输出	pt
     * 说明	无
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String s2 = in.nextLine();

        String[] split = s.split("[0-9a-f]+");
        int max = getDistinctCount(s2);

        String[] ans = Arrays.stream(split).filter(o -> !"".equals(0) && getDistinctCount(o) <= max).toArray(String[]::new);

        if (ans.length == 0) {
            System.out.println("Not Found");
            return;
        }


        Arrays.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (getDistinctCount(o1) != getDistinctCount(o2)) {
                    return getDistinctCount(o2) - getDistinctCount(o1);
                } else {
                    return o2.compareTo(o1);
                }
            }
        });


        System.out.println(ans[0]);

    }

    public static int getDistinctCount(String str) {

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set.size();
    }


}
