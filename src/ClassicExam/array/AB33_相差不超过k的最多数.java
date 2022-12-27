package ClassicExam.array;

import java.util.Arrays;
import java.util.Scanner;

public class AB33_相差不超过k的最多数 {

    /**
     * 给定一个数组，选择一些数，要求选择的数中任意两数差的绝对值不超过 kk 。问最多能选择多少个数？
     * 输入描述：
     * 第一行输入两个正整数 nn和kk。
     * 第二行输入 nn 个正整数a_ia
     * i
     * ​
     * ，用空格隔开，表示这个数组。
     *
     * https://www.nowcoder.com/practice/562630ca90ac40ce89443c91060574c6?tpId=308&tqId=2403293&ru=/exam/oj&qru=/ta/algorithm-start/question-ranking&sourceUrl=/exam/oj?page=1&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=308
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int max = 0;

        // todo 双指针解法
        int l = 0, r = 0;
        while (r < n) {
            // 左指针移动
            if (arr[r] - arr[l] > k) {
                l++;
            }

            max = Math.max(max, r - l + 1);

            r++;
        }

        System.out.println(max);

    }


}
