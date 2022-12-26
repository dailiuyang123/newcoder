package ClassicExam.string;

import java.util.*;

public class NC294 {

    /**
     * 字母异位词分组
     * https://www.nowcoder.com/practice/68bda87f91664623a4213abb00e41a5a?tpId=196&tqId=39745&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&tags=579&difficulty=undefined&judgeStatus=undefined&tags=579&title=
     */
    public String[][] groupAnagrams(String[] strs) {
        // write code here

        if (strs.length <= 1) {
            return new String[][]{strs};
        }

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(strs[i]);
            map.put(key, orDefault);
        }

        Set<String> strings = map.keySet();
        String[][] rs = new String[strings.size()][];
        int index = 0;
        for (String string : strings) {
            List<String> strings1 = map.get(string);
            String[] temp = new String[strings1.size()];
            for (int i = 0; i < strings1.size(); i++) {
                temp[i] = strings1.get(i);
            }
            rs[index] = temp;
            index++;
        }
        return rs;
    }


    public static void main(String[] args) {

        NC294 nc294 = new NC294();
        String[] strs = {"eat", "tea", "ate", "but", "nowcoder", "codernow"};
        String[][] strings = nc294.groupAnagrams(strs);
        System.out.println(strings);

    }


}
