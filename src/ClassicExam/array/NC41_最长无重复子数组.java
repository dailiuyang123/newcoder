package ClassicExam.array;

import java.util.HashMap;

public class NC41_最长无重复子数组 {


    /**
     * 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
     * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
     * <p>
     * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=117&tqId=37816&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */


    // 双指针+ hashMap 优雅解法
    public int maxLength(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < arr.length; ++i) {
            if (map.containsKey(arr[i])) {
                j = Math.max(j, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }


}
