package ClassicExam.other;

import java.util.HashMap;
import java.util.Map;

public class NC112 {

    /**
     * 进制转换
     * https://www.nowcoder.com/practice/2cc32b88fff94d7e8fd458b8c7b25ec1?tpId=196&tqId=37170&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public String solve(int M, int N) {
        // write code here
        StringBuilder sb = new StringBuilder();

        // todo 注意测试用例：为负的场景 （-4，3）！！！！
        boolean isfu = false;
        if (M < 0) {
            M = 0 - M;
            isfu = true;
        }
        Map<Integer, Character> map = new HashMap<>();
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');

        while (M >= N) {
            int y = M % N;
            if (y < 10) {
                sb.append(y);
            } else {
                sb.append(map.get(y));
            }
            M = M / N;
        }

        if (M != 0) {
            if (M < 10) {
                sb.append(M);
            } else {
                sb.append(map.get(M));
            }
        }
        String string = sb.reverse().toString();
        return isfu ? "-" + string : string;
    }


    public static void main(String[] args) {

        NC112 nc112 = new NC112();
        String solve = nc112.solve(-4, 3);
        System.out.println(solve);

    }


}
