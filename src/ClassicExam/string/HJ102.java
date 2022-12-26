package ClassicExam.string;

import java.util.*;

public class HJ102 {

    /**
     * 字符统计
     * <p>
     * https://www.nowcoder.com/practice/c1f9561de1e240099bdb904765da9ad0?tpId=37&tqId=21325&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?difficulty=2&page=1&pageSize=50&search=&tpId=37&type=37&difficulty=2&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String s = in.nextLine();
            Map<Integer, String> map = new HashMap<>();
            int[] time = new int[128];

            for (int i = 0; i < s.length(); i++) {
                time[s.charAt(i)] += 1;
            }

            for (int i = 0; i < time.length; i++) {
                if (time[i] > 0) {
                    map.put(time[i], map.getOrDefault(time[i], "") + (char) i);
                }
            }

            ArrayList<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(map.get(list.get(i)));
            }
            System.out.println(sb);

        }


    }


}
