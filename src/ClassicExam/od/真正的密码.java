package ClassicExam.od;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 真正的密码 {

    /**
     * 在一行中输入一个字符串数组，如果其中一个字符串所有以索引0开头
     * 的子串在数组中都有，那么这个字符串就是潜在的密码
     * 所有潜在密码中最长的是真正的密码，如果有多个长度相同的真正的密码
     * 那么取字典序最大的为唯一真正的密码，求唯一真正的密码
     * <p>
     * 示例1：
     * 输入：h he hel hell hello o ok n ni nin ninj ninja
     * 潜在密码：hello，ok ninja
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split("\\ ");
        List<String> strings = Arrays.asList(split);

        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    return o2.compareTo(o1);
                }
            }
        });


        for (int i = 0; i < split.length; i++) {
            boolean isMima = true;
            for (int j = 1; j < split[i].length(); j++) {
                String substring = split[i].substring(0, j);
                if (!strings.contains(substring)) {
                    isMima = false;
                    break;
                }
            }

            if (isMima) {
                System.out.println(split[i]);
                return;
            }
        }


    }


}
