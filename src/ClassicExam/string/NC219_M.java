package ClassicExam.string;

import java.util.Arrays;

public class NC219_M {

    /**
     * 移调k位数字
     * https://www.nowcoder.com/practice/0fe685c8272d40f1b9785fedd2499c1c?tpId=196&tqId=39412&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public String removeKnums(String num, int k) {
        // write code here

        if (num.length() <= k) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int len = num.length() - k;
        int l = 0, r = num.length() - k;

        while (len > 0) {
            // 找一个最小的
            String substring = num.substring(l, num.length() - len + 1);
            char[] chars = substring.toCharArray();
            Arrays.sort(chars);
            sb.append(chars[0]);
            l = substring.indexOf(chars[0]) + l + 1;
            len--;
        }
        // todo 去除前导0
        String string = sb.toString();
        int index = 0;
        while (string.charAt(index) == '0' && index != string.length() - 1) {
            index++;
        }
        return string.substring(index);

    }


    public static void main(String[] args) {

        NC219_M nc219_m = new NC219_M();
        String s = nc219_m.removeKnums("1432219", 3);
//        String s = nc219_m.removeKnums("10", 1);
//        String s = nc219_m.removeKnums("100999", 3);
        System.out.println(s);


    }


}
