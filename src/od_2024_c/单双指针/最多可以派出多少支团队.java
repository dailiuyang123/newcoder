package od_2024_c.单双指针;

import java.util.Arrays;
import java.util.Scanner;

public class 最多可以派出多少支团队 {
    /**
     * 2024/3/20
     * URL ：
     * 题目描述：
     **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int k = in.nextInt();

        int[] mins = Arrays.stream(nums).filter(o -> o < k).toArray();
        int res = n - mins.length;

        Arrays.sort(mins);

        int l = 0;
        int r = mins.length-1;

        while (l < r) {
            if (mins[l] + mins[r] >= k) {
                l++;
                r--;
                res++;
            } else {
                l++;
            }
        }

        System.out.println(res);

    }


}
