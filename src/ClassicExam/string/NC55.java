package ClassicExam.string;

import java.util.Arrays;
import java.util.Comparator;

public class NC55 {

    /**
     * 最长公共前缀  https://www.nowcoder.com/practice/28eb3175488f4434a4a6207f6f484f47?tpId=117&tqId=37752&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * 给你一个大小为n的字符串数组 str, 其中包含n个字符串 , 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
     */
    public String longestCommonPrefix(String[] strs) {
        // write code here

        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });


        String temp = "";
        int length = strs[0].length();

        for (int i = length; i > 0; i--) {

            String tem = strs[0].substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].indexOf(tem) == -1) {
                    tem = "";
                    break;
                }
            }
            if (!tem.isEmpty()) {
                return tem;
            }
        }

        return temp;
    }

    public static void main(String[] args) {

        NC55 nc55 = new NC55();
        String[] atrs = {"aa", "ab"};
        String s = nc55.longestCommonPrefix(atrs);
        System.out.println(s);

    }


}
