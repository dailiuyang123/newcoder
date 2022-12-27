package ClassicExam.string;

public class NC17_最长回文子串 {


    /**
     * 最长回文子串
     * https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=117&tqId=37789&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?page=1&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public int getLongestPalindrome(String A) {
        // write code here

        if (A.length() <= 1) {
            return A.length();
        }

        for (int i = A.length(); i > 1; i--) {
            for (int j = 0; j + i <= A.length(); j++) {
                String substring = A.substring(j, j + i);
                StringBuilder sb = new StringBuilder(substring);
                if (sb.reverse().toString().equals(substring)) {
                    return i;
                }
            }
        }

        return 1;

    }


    public static void main(String[] args) {
        NC17_最长回文子串 nc17_最长回文子串 = new NC17_最长回文子串();
        int aba = nc17_最长回文子串.getLongestPalindrome("abc");
        System.out.println(aba);
    }


}
