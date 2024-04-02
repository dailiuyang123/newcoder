package od_2024_c.单双指针;

import java.util.Scanner;

public class 最多购买宝石的数量 {
    /**
     * 2024/3/19
     * URL ：https://fcqian.blog.csdn.net/article/details/134640336
     * 题目描述：
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int v = in.nextInt();


        int res = 0;
        int max = 0;

        int l = 0;
        int r = 0;

        int temp = v;

        while (l <= r && r < n) {
            if (temp - nums[r] >= 0) {
                temp -= nums[r];
                r++;
                res++;
                max = Math.max(max, res);
            } else {
                if (res != 0) {
                    temp += nums[l];
                    res--;
                }
                l++;
                if (r < l) {
                    r = l;
                }
            }
        }
        System.out.println(max);

    }


}
