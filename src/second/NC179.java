package second;

public class NC179 {

    /**
     * 长度为k 的 重复字符字串 https://www.nowcoder.com/practice/eced9a8a4b6c42b79c95ae5625e1d5fd?tpId=196&tqId=39337&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * 给你一个由小写字母组成的长度为n的字符串s，找出所有长度为k且包含重复字符的字串，请你
     * 返回全部满足要求的子串的数目。
     *
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @param k int整型
     * @return int整型
     */
    public int numKLenSubstrRepeats(String s, int k) {
        // write code here

        int count = 0;
        for (int i = 0; i + k <= s.length(); i++) {
            String substring = s.substring(i, i + k);
            if (isrepeat(substring)) {
                count++;
            }
        }

        return count;
    }


    public boolean isrepeat(String s) {
        int[] arr = new int[36];
        for (int i = 0; i < s.length(); i++) {

            int index = s.charAt(i) - 'a';
            if (arr[index] >= 1) {
                return true;
            } else {
                arr[index] = 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        NC179 nc179 = new NC179();
        int createfunonyoka = nc179.numKLenSubstrRepeats("yokagames", 3);

        System.out.println(createfunonyoka);

    }
}
