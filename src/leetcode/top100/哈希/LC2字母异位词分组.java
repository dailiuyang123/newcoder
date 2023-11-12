package leetcode.top100.哈希;

import java.util.*;

public class LC2字母异位词分组 {
    /**
     * 2023/11/11
     * URL ：https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
     * 题目描述：给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表
     **/
    public static void main(String[] args) {

        LC2字母异位词分组 lc2字母异位词分组 = new LC2字母异位词分组();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {""};
        List<List<String>> list = lc2字母异位词分组.groupAnagrams(strs2);
        System.out.println(list.toString());

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key, orDefault);
        }
        List<List<String>> list = new ArrayList<>();
        for (List<String> value : map.values()) {
            list.add(value);
        }
        return list;

    }

}
