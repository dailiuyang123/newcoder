package ClassicExam.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NC220_重复的DNA序列 {

    /**
     * 所有的 DNA 序列都是由 'A' , ‘C’ , 'G' , 'T' 字符串组成的，例如 'ACTGGGC' 。
     * 请你实现一个函数找出所有的目标子串，目标子串的定义是，长度等于 10 ，且在 DNA 序列中出现次数超过 1 次的子串（允许两个子串有重合的部分，如下面的示例2所示）。
     * （注：返回的所有目标子串的顺序必须与原DNA序列的顺序一致，如下面的示例1所示）
     * <p>
     * https://www.nowcoder.com/practice/fe9099e5308042a8af2f7aabdb3719fe?tpId=117&tqId=39424&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?page=3&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public String[] repeatedDNA(String DNA) {
        // write code here
        List<String> ans = new ArrayList<>();
        if (DNA.length() <= 10) {
            return ans.toArray(new String[0]);
        }

        for (int i = 0; i + 10 <= DNA.length(); i++) {
            String substring = DNA.substring(i, i + 10);
            if (DNA.indexOf(substring, i + 1) != -1) {
                if (!ans.contains(substring)) {
                    ans.add(substring);
                }
            }
        }

        return ans.toArray(new String[ans.size()]);

    }


    public static void main(String[] args) {
        NC220_重复的DNA序列 nc220_重复的DNA序列 = new NC220_重复的DNA序列();
        String[] strings = nc220_重复的DNA序列.repeatedDNA("AAAAAAAAAAA");
        for (String string : strings) {
            System.out.println(string);
        }
    }


}
