package ClassicExam.array;

import java.util.*;

public class NC236 {

    /**
     * 最大差值：https://www.nowcoder.com/practice/a01abbdc52ba4d5f8777fb5dae91b204?tpId=117&tqId=39473&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * <p>
     * 有一个长为 n 的数组 A ，求满足 0 ≤ a ≤ b < n 的 A[b] - A[a] 的最大值。
     * <p>
     * 给定数组 A 及它的大小 n ，请返回最大差值。
     * <p>
     * <p>
     * 数据范围： 2 < n \le 2*10^5\2<n≤2∗10
     * 5
     * ，数组中的值满足 0 \le |val| \le 5*10^8 \0≤∣val∣≤5∗10
     * 8
     */

    public int getDis(int[] A, int n) {
        // write code here
        int max = 0; // 结果最小为0
        int min = A[0]; // 默认最小为第一位
        for(int i = 1 ; i < n; i ++){
            min = Math.min(A[i], min); // 第一位与遍历的比较, 取小的
            max = Math.max(A[i] - min, max); // A[i]减去之前最小的A[i], 取最小的
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {260, 9254, 5425};
        NC236 nc236 = new NC236();
        int dis = nc236.getDis(nums, 3);
        System.out.println(dis);
    }


}
