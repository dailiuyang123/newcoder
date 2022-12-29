package ClassicExam.string;

import java.util.ArrayList;
import java.util.List;

public class NC31 {


    /**
     * 第一个只出现一次的字符
     * 在一个长为 字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     * <p>
     * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=196&tqId=37558&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?page=1&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public int FirstNotRepeatingChar(String str) {

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            // todo 注意：这里要转换为包装类，即对象。防止转换为int
            Character c = str.charAt(i);

            if (!list.contains(c)) {
                list.add(c);
            } else {
                list.remove(c);
            }
        }
        if (list.size() == 0) {
            return -1;
        }
        return str.indexOf(list.get(0));
    }


    public static void main(String[] args) {
        NC31 nc31 = new NC31();
        int i = nc31.FirstNotRepeatingChar("aa");
        System.out.println(i);
    }


}
