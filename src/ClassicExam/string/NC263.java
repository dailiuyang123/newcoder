package ClassicExam.string;

public class NC263 {


    /**
     * 输入一个整数 n ，求 1～n 这 n 个整数的十进制表示中 1 出现的次数
     * 例如， 1~13 中包含 1 的数字有 1 、 10 、 11 、 12 、 13 因此共出现 6 次
     * <p>
     * 注意：11 这种情况算两次
     * https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=196&tqId=39714&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?page=1&pageSize=50&search=&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=5050&title=
     */

    public int NumberOf1Between1AndN_Solution(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        String string = sb.toString();
        String s = string.replaceAll("1", "");

        return string.length() - s.length();

    }


}
