package ClassicExam.other;

public class NC144 {


    /**
     * 懂二进制
     * https://www.nowcoder.com/practice/120e406db3fd46f09d55d59093f13dd8?tpId=196&tqId=37560&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&difficulty=2&tags=5074&difficulty=2&judgeStatus=undefined&tags=5074&title=
     */
    public int countBitDiff(int m, int n) {
        int c = m ^ n;
        int count = 0;
        while (c != 0) {
            count += c & 1;
            c = c >> 1;
        }
        return count;
    }

    public static void main(String[] args) {

        NC144 nc144 = new NC144();
        int i = nc144.countBitDiff(16807, 282475249);
        System.out.println(i);

    }


}
