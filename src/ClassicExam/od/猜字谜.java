package ClassicExam.od;

import java.util.*;

public class 猜字谜 {

    /**
     * 猜字谜
     * 小王设计了一个简单的猜字谜游戏，游戏的谜面是一个错误的单词：
     * 比如：nesw, 玩家需要猜出谜底库中正确的单词。
     * <p>
     * 猜中要求如下：
     * 对于谜面和谜底单词，满足下边任一条件都表示猜中：
     * 1. 变换顺序后一样的，比如通过变换w 和 e 的顺序，nwes 和 news 是完全可以对应的
     * 2. 字母去重后一样的，比如：woood 和 wood 是一样的，去重后都是 wod
     * 请你写出一个程序，帮忙找到正确的谜底。谜面是多个单词，都需要找到对应的谜底
     * 如果找不到的话，返回 not found
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String strings = in.nextLine();

        String[] split = strings.split("\\,");

        // 换顺序
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        String abs = String.valueOf(charArray);


        // 去重
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                list.add(s.charAt(i));
            }
        }
        String abs2 = String.valueOf(list);

        for (int i = 0; i < split.length; i++) {

            String temp = split[i];
            if (temp.length() == s.length()) {
                char[] chars = temp.toCharArray();
                Arrays.sort(chars);
                if (abs.equals(String.valueOf(chars))) {
                    System.out.println(temp);
                    return;
                }
            } else {
                List<Character> temps = new ArrayList<>();
                temps.add(temp.charAt(0));
                for (int j = 1; j < temp.length(); j++) {
                    if (temp.charAt(j) != temp.charAt(j - 1)) {
                        temps.add(temp.charAt(j));
                    }
                }

                if (abs2.equals(String.valueOf(temps))) {
                    System.out.println(temp);
                    return;
                }
            }
        }

        System.out.println("not found");


    }


}
