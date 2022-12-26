package ClassicExam.hashtable;

import java.util.HashMap;
import java.util.Map;

public class NC391 {

    /**
     * 快乐数
     * <p>
     * https://www.nowcoder.com/practice/293b9ddd48444fa493dd17da0feb192d?tpId=196&tqId=40522&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * <p>
     * 给定一个正整数，请你判断这个数是不是快乐数。
     * 快乐数：对于一个正整数，每次把他替换为他每个位置上的数字的平方和，如果这个数能变为 1 则是快乐数，如果不可能变成 1 则不是快乐数。
     * 例如：正整数 19
     * 转换过程为 1*1+9*9=82 , 8*8+2*2=68，6*6+8*8=100，1*1+0*0+0*0=1 ，所以他是快乐数。
     */

    public boolean happynum(int n) {
        // write code here
        String s = n + "";

        Map<Integer, Integer> map = new HashMap<>();
        map.put(n, 1);

        while (n != 1) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int a = (s.charAt(i) - '0');
                sum += (int) Math.pow(a, 2);
            }
            if (map.containsKey(sum)) {
                break;
            }
            map.put(sum, 1);
            n = sum;
            s = sum + "";
        }

        return n == 1;
    }


    public static void main(String[] args) {

        NC391 nc391 = new NC391();
        boolean happynum = nc391.happynum(11);
        System.out.println(happynum);

    }


}
