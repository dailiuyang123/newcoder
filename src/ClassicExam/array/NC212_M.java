package ClassicExam.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NC212_M {

    // TODO: 2022/12/21  颜色分类 双指针解法参考 
    /**
     * 颜色分类
     * https://www.nowcoder.com/practice/52e04ddb7b5640a8869c2d3da2ad3344?tpId=196&tqId=39405&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public int[] sortColor(int[] colors) {
        // write code here
        int n = colors.length;
        int l = 0, r = n - 1;
        for (int i = 0; i <= r; i++) {

            // 等于2时，放到最右边
            while (i <= r && colors[i] == 2) {
                int temp = colors[i];
                colors[i] = colors[r];
                colors[r] = temp;
                r--;
            }

            // 等于0时 放左边
            if (colors[i] == 0) {
                int temp = colors[i];
                colors[i] = colors[l];
                colors[l] = temp;
                l++;

            }
        }
        return colors;
    }


    public static void main(String[] args) {

        NC212_M nc212_m = new NC212_M();
        int[] nums = {0, 0, 2, 1};
        int[] ints = nc212_m.sortColor(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }


}
