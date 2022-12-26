package ClassicExam.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NC97 {

    /**
     * 字符串出现次数的top k 问题
     * <p>
     * https://www.nowcoder.com/practice/fd711bdfa0e840b381d7e1b82183b3ee?tpId=117&tqId=37809&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?page=1&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */

    public String[][] topKstrings(String[] strings, int k) {
        // write code here

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], map.getOrDefault(strings[i], 0) + 1);
        }

        PriorityQueue<String[]> heap = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (!o1[1].equals(o2[1])) {
                    return Integer.valueOf(o1[1]) - Integer.valueOf(o2[1]);
                } else {
                    return -(o1[0].compareTo(o2[0]));
                }
            }
        });

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {

            String key = stringIntegerEntry.getKey();
            Integer value = stringIntegerEntry.getValue();

            heap.offer(new String[]{key, value + ""});

            if (heap.size() > k) {
                heap.poll();
            }
        }

        String[][] rs = new String[k][];

        for (int i = k - 1; i >= 0; i--) {
            String[] temp = heap.poll();
            rs[i] = temp;
        }

        return rs;

    }

    public static void main(String[] args) {

        NC97 nc97 = new NC97();
//        String[] strings = {"a", "b", "c", "b"};
        String[] strings = {"123","123","231","32"};
        String[][] strings1 = nc97.topKstrings(strings, 2);
        System.out.println(strings1);


    }


}
