package ClassicExam.string;

public class NC371 {

    /**
     * 验证回文字符串 （二） https://www.nowcoder.com/practice/130e1a9eb88942239b66e53ec6e53f51?tpId=196&tqId=40502&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * <p>
     * 给定一个字符串，请问最多删除一个的情况下，能否组成一个回文字符串。
     * <p>
     * 回文字符串：正着读和反着读是一样的字符串。
     */
    public boolean palindrome(String str) {
        // write code here

        if (str.length() <= 1) {
            return true;
        }

        StringBuilder sb = new StringBuilder(str);

        String s = sb.reverse().toString();

        if (s.equals(str)) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != s.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }


}
