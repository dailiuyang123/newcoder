package ClassicExam.od;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 最长的密码 {

    /**
     * 在一个密码本中，每一页都有一个由26个小写字母组成的若干位密码，密码获得的条件如下
     * 每一页的密码不同，需要从这个密码本中寻找这样一个最长的密码
     * <p>
     * 从它的末尾开始依次去掉一位得到的新密码也在密码本中存在。
     * 请输出符合要求的密码，如果有多个符合要求的密码，则返回字典序最大的密码
     *
     * 示例1：
     * h he hel hell hello
     * 返回：
     * hello
     *
     * 示例2：
     * b ereddred bw bww bwwl bwwlm bwwln
     * 返回：
     * bwwln
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split("\\ ");
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

        List<String> strings = Arrays.asList(split);

        for (int i = 0; i < strings.size(); i++) {

            String temp = strings.get(i);
            boolean isTrue = true;
            for (int j = temp.length() - 1; j > 0; j--) {
                if (!strings.contains(temp.substring(0, j))) {
                    isTrue = false;
                }
            }
            if (isTrue) {
                System.out.println(temp);
                return;
            }
        }

        System.out.println("");

    }


}
