package second;

import java.util.*;

public class HJ59 {

    /**
     * 找出字符串中第一个只出现一次的字符 https://www.nowcoder.com/practice/e896d0f82f1246a3aa7b232ce38029d4?tpId=37&tqId=21282&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?difficulty=3&page=1&pageSize=50&search=&tpId=37&type=37&difficulty=3&judgeStatus=undefined&tags=&title=
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();

        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                return;
            }
        }

        System.out.println(-1);

    }


}
