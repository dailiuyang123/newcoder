package second;

import java.util.Arrays;

public class NC283 {

    /**
     * 数组中重复的数字 https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=196&tqId=39734&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * 在一个长度为n 的数组里的所有数组
     *
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate(int[] numbers) {
        // write code here
        if (numbers.length < 1) {
            return -1;
        }

        Arrays.sort(numbers);

        for (int i = 0; i + 1 < numbers.length; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return numbers[i];
            }
        }

        return -1;

    }


    public static void main(String[] args) {


        NC283 nc283 = new NC283();
        int[] a = {2, 3, 1, 0, 2, 5, 3};
        int duplicate = nc283.duplicate(a);
        System.out.println(duplicate);

    }


}
