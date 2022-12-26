package ClassicExam.array;

public class NC200 {

    /**
     * 移动0
     * <p>
     * https://www.nowcoder.com/practice/102586387caa4afcbad6f96affce9780?tpId=196&tqId=39381&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=2&difficulty=2&judgeStatus=undefined&tags=&title=
     */
    public int[] moveZeroes(int[] nums) {
        // write code here
        int[] rs = new int[nums.length];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                rs[index] = nums[i];
                index++;
            }

        }

        return rs;

    }





}
