package test.day17;

import java.util.*;

public class HJ61 {

    // 分苹果
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m = in.nextInt();
            int n = in.nextInt();
            int[] nums = new int[m + 1];
            for (int i = 0; i <nums.length; i++) {
                nums[i] = i;
            }
            int l = nums.length;
            Deque<Integer> path = new ArrayDeque();
            Set<String> res = new HashSet<>();

            dfs(nums,l,path,0,res,n,m,0);
            System.out.println(res);
        }
    }

    private static void dfs(int[] nums, int l, Deque<Integer> path, int begin, Set<String> res, int n, int m, int tmp) {

        if (path.size() == n && tmp == m) {
            ArrayList<Integer> integers = new ArrayList<>(path);
            Collections.sort(integers);
            res.add(integers.toString());
            return;
        }
        if (tmp > m || path.size() > n) {
            return;
        }

        for (int i = begin; i < l; i++) {
            path.push(nums[i]);
            tmp += nums[i];
            dfs(nums, l, path, begin , res, n, m, tmp);
            //回溯
            path.pop();
            tmp -= nums[i];
        }

    }


}
