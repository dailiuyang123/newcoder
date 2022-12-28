package ClassicExam.other;

import java.util.ArrayList;
import java.util.List;

public class NC256 {

    /**
     * 数组内没有出现的数字
     * <p>
     * https://www.nowcoder.com/practice/aa2a56603fb94b3395ea23ff89d37628?tpId=196&tqId=39707&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?page=4&pageSize=50&search=&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */

    public int[] findDisappearedNumbers(int[] nums) {
        // write code here

        int[] cache = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            cache[nums[i]]++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < cache.length; i++) {
            if (cache[i] == 0) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();

    }





}
