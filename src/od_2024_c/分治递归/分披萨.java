package od_2024_c.分治递归;

import java.util.Scanner;

public class 分披萨 {
    /**
     * 2024/2/18
     * URL ：https://fcqian.blog.csdn.net/article/details/134793989?spm=1001.2014.3001.5502
     * 题目描述：
     **/
    static int[] nums;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solution(check(i - 1), check(i + 1), nums) + nums[i]);
        }

        System.out.println(ans);
    }


    public static long solution(int l, int r, int[] nums) {

        if (nums[l] > nums[r]) {
            l = check(l - 1);
        } else {
            r = check(r + 1);
        }

        if (l == r) {
            return nums[l];
        } else {
            // todo 此时说明还可以选多伦，所以有左右两种选择，取最大值
            return Math.max(solution(check(l - 1), r, nums) + nums[l], solution(l, check(r + 1), nums) + nums[r]);
        }


    }

    public static int check(int index) {

        if (index < 0) {
            index += nums.length;
        } else if (index >= nums.length) {
            index = 0;
        }
        return index;
    }


}
