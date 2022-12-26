package ClassicExam.string;

public class NC179 {

    /**
     * 长度为k 的重复字符子串
     * <p>
     * https://www.nowcoder.com/practice/eced9a8a4b6c42b79c95ae5625e1d5fd?tpId=196&tqId=39337&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&difficulty=2&tags=579&difficulty=2&judgeStatus=undefined&tags=579&title=
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


}
