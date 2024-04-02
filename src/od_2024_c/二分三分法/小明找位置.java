package od_2024_c.二分三分法;

import java.util.Arrays;
import java.util.Scanner;

public class 小明找位置 {
    /**
     * 2024/3/25
     * URL ：https://blog.csdn.net/qfc_128220/article/details/134640116
     * 题目描述：题目描述
     * 小朋友出操，按学号从小到大排成一列；
     * <p>
     * 小明来迟了，请你给小明出个主意，让他尽快找到他应该排的位置。
     * <p>
     * 算法复杂度要求不高于nLog(n)；学号为整数类型，队列规模 ≤ 10000；
     * <p>
     * 输入描述
     * 第一行：输入已排成队列的小朋友的学号（正整数），以","隔开；例如：
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] arrays = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::valueOf).toArray();

        int target = in.nextInt();

        int l = 0, r = arrays.length - 1;
        int index = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arrays[mid] < target && (mid + 1) < arrays.length && arrays[mid + 1] > target) {
                index = mid + 2;
                break;
            } else {
                if (arrays[mid] > target) {
                    r = mid - 1;
                }
                if ((mid + 1) < arrays.length && arrays[mid + 1] < target) {
                    l = mid + 1;
                }
            }

        }
        System.out.println(index);

    }


}
