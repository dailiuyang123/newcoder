package ClassicExam.hashtable;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 电话号码的字母组合
 */

public class LC17 {


    String[] map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 使用 深度优先，dfs
     */
    public List<String> letterCombinations_dfs(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs(digits, new StringBuilder(), 0, res);
        return res;
    }


//    void dfs(String digits, StringBuilder curStr, int index, List<String> res) {
//
//        // 判断条件是否满足。如果满足，跳出递归
//        if (index == digits.length()) {
//            res.add(curStr.toString());
//            return;
//        }
//        char c = digits.charAt(index);
//        int pos = c - '0';
//        String map_string = map[pos];
//        for (int i = 0; i < map_string.length(); i++) {
//            curStr.append(map_string.charAt(i));
//            dfs(digits, curStr, index + 1, res);
//            curStr.deleteCharAt(curStr.length() - 1);
//        }
//    }


    /**
     * 暴力解法
     * 已知字符串长度 <= 4
     * 采用for 循环，遍历所有可能性
     */
    public List<String> letterCombinations(String digits) {

        HashMap<Integer, String[]> map = new HashMap<>();
        map.put(2, new String[]{"a", "b", "c"});
        map.put(3, new String[]{"d", "e", "f"});
        map.put(4, new String[]{"g", "h", "i"});
        map.put(5, new String[]{"j", "k", "l"});
        map.put(6, new String[]{"m", "n", "o"});
        map.put(7, new String[]{"p", "q", "r", "s"});
        map.put(8, new String[]{"t", "u", "v"});
        map.put(9, new String[]{"w", "x", "y", "z"});

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        // bfs /dfs

        for (int i = 0; i < map.get(Integer.valueOf(digits.substring(0, 1))).length; i++) {
            String s = map.get(Integer.valueOf(digits.substring(0, 1)))[i];
            if (digits.length() >= 2) {
                for (int j = 0; j < map.get(Integer.valueOf(digits.substring(1, 2))).length; j++) {
                    String t = s + map.get(Integer.valueOf(digits.substring(1, 2)))[j];
                    if (digits.length() >= 3) {
                        for (int k = 0; k < map.get(Integer.valueOf(digits.substring(2, 3))).length; k++) {
                            String m = t + map.get(Integer.valueOf(digits.substring(2, 3)))[k];
                            if (digits.length() == 4) {
                                for (int l = 0; l < map.get(Integer.valueOf(digits.substring(3))).length; l++) {
                                    String n = m + map.get(Integer.valueOf(digits.substring(3)))[l];
                                    result.add(n);
                                }
                            } else {
                                result.add(m);
                            }
                        }
                    } else {
                        result.add(t);
                    }
                }
            } else {
                result.add(s);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LC17 lc17 = new LC17();
//        List<String> strings = lc17.letterCombinations("5678");
        List<String> strings = lc17.letterCombinations_dfs("5678");
        System.out.println(strings.toString());
        System.out.println(strings.size());

    }


    /**
     *
     * Description : 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回
     *
     * 【DFS -- 回溯解法】
     *
     * @Param  【非必传】 String[] map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
     * @Param String digits 待处理的组合
     * @Param StringBuilder cur_entity 当前排列组合
     * @Param int index digits的下标
     * @Param List<String> res 所有符合条件的结果 集合
     *
     */
    void dfs(String digits, StringBuilder cur_entity, int index, List<String> res) {

        // 判断条件，digits.length == cur_entity.length,如果满足条件，添加到集合res内，跳出递归
        if (cur_entity.length() == digits.length()) {
            res.add(cur_entity.toString());
            return;
        }

        // 当前要，需要排列组合的集合
        int char_index = digits.charAt(index) - '0';
        String s = map[char_index];

        // 遍历集合
        for (int i = 0; i < s.length(); i++) {
            // 当前 元素entity 处理
            cur_entity.append(s.charAt(i));
            // 递归调用
            dfs(digits, cur_entity, index + 1, res);
            // 回退  -- 注意！！！！！
            cur_entity.deleteCharAt(cur_entity.length() - 1);
        }

    }


}
