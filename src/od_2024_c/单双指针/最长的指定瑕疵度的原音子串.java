package od_2024_c.单双指针;

import java.util.Scanner;

public class 最长的指定瑕疵度的原音子串 {
    /**
     * 2024/3/19
     * URL ：
     * 题目描述：https://fcqian.blog.csdn.net/article/details/127711201
     **/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        String s = in.next();

        String target = "aeiouAEIOU";
        int res = 0;

        // todo error
        //0
        //o
        //
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (target.indexOf(s.charAt(i)) != -1 && target.indexOf(s.charAt(j)) != -1) {
                    String substring = s.substring(i, j + 1);
                    if ((substring.replaceAll("[aeiouAEIOU]", "").length()) == k) {
                        res = Math.max(res, substring.length());
                    }
                }
            }
        }
        System.out.println(res);
        System.out.println(solution(k, s));

    }


    public static int solution(int k, String s) {
        int res = 0;
        String target = "aeiouAEIOU";
        int l = 0, r = 0;

        while (l <= r && r < s.length()) {
            if (target.indexOf(s.charAt(l)) != -1 && target.indexOf(s.charAt(r)) != -1) {
                String substring = s.substring(l, r + 1);
                int t = substring.replaceAll("[aeiouAEIOU]", "").length();
                if (t <= k || l == r) {
                    if (t == k) {
                        res = Math.max(res, substring.length());
                    }
                    r++;
                } else {
                    l++;
                }
            } else {
                if (target.indexOf(s.charAt(l)) == -1) {
                    l++;
                }
                if (target.indexOf(s.charAt(r)) == -1) {
                    r++;
                }
            }

        }
        return res;
    }


}
