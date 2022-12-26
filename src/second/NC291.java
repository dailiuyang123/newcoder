package second;

public class NC291 {

    /**
     * 数字序列中的某一位数字 https://www.nowcoder.com/practice/29311ff7404d44e0b07077f4201418f5?tpId=196&tqId=39742&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */

    public int findNthDigit(int n) {
        // write code here
        int length = 0;
        int index = 0;
        while (length <= n) {
            if (length == n) {
                String last = index + "";
                return last.charAt(0)-'0';
            }
            length += (index + "").length();
            index++;
        }
        String last = index + "";
        return last.charAt(last.length() - (length - n)) - '0';

    }


    public static void main(String[] args) {

        NC291 nc291 = new NC291();
        int nthDigit = nc291.findNthDigit(1000000000);
        System.out.println(nthDigit);

    }

}
