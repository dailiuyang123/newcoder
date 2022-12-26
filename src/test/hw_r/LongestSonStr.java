package test.hw_r;

import java.util.HashSet;
import java.util.Set;

public class LongestSonStr {

    // 给出一个字符串 s ,求此字符串无重复最长子串 的长度

    public static void main(String[] args) {

        String s = "pwwkew";

        int n = s.length();
        int count = 0;
        Set<Character> set = new HashSet<>();

        int l = 0, r = 0;
        while (l < n && r < n) {
            char c = s.charAt(r);
            if (!set.contains(c)) {
                set.add(c);
                r++;
                count = Math.max(count, r - l);
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }

        System.out.println(count);

    }


}
