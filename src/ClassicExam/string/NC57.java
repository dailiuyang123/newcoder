package ClassicExam.string;

public class NC57 {

    /**
     * 反转数字
     * https://www.nowcoder.com/practice/1a3de8b83d12437aa05694b90e02f47a?tpId=117&tqId=37755&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?page=2&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public int reverse(int x) {
        // write code here
        int res = 0;

        while (x != 0) {

            int t = x % 10;
            int newRes = res * 10 + t;
            // todo 判断是否已经超过极限值
            if ((newRes - t) / 10 != res) {
                return 0;
            }
            res = newRes;
            x = x / 10;
        }

        return res;

    }


}
