package ClassicExam.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AB31_活动安排 {

    /**
     * 活动安排
     * <p>
     * 给定nn个活动，每个活动安排的时间为[a_i,b_i)[a
     * i
     * ​
     * ,b
     * i
     * ​
     * )。求最多可以选择多少个活动，满足选择的活动时间两两之间没有重合。
     *
     * https://www.nowcoder.com/practice/16d971e9e42e4f3b9b1e2b8794796a43?tpId=308&tqId=2373697&ru=/exam/oj&qru=/ta/algorithm-start/question-ranking&sourceUrl=/exam/oj?page=1&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=308
     *
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int count = 1;
        int cur = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (cur <= arr[i][0]) {
                count++;
                cur = arr[i][1];
            }
        }

        System.out.println(count);

    }


}
