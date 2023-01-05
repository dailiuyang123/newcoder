package ClassicExam.od_100;

import java.util.Arrays;
import java.util.Scanner;

public class 最短木板长度 {

    /**
     * 贪心思想
     *
     * 给定一个数组 nums, 和一个 数字 n,
     * 将 n 拆分到nums数组上，怎么查分使得 数组最小值最大，并打印最小值;
     * <p>
     * 用例1：
     * 5 3
     * 4 5 3 5 5
     *
     * 输出：
     * 5
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        while (m > 0) {
            Arrays.sort(nums);
            nums[0] = nums[0] + 1;
            m--;
        }

        Arrays.sort(nums);
        System.out.println(nums[0]);
    }


}
