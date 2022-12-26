package ClassicExam.array;

import java.util.Arrays;

public class NC71 {


    /**
     * 旋转数组的最小数字
     * <p>
     * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=196&tqId=37102&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&tags=5058&difficulty=undefined&judgeStatus=undefined&tags=5058&title=
     */
    public int minNumberInRotateArray(int[] array) {
        Arrays.sort(array);
        return array[0];
    }


}
