package od_2024_c.滑动窗口;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static od_2024_c.滑动窗口.用连续自然数之和来表达整数.n;

public class 最小矩阵宽度 {
    /**
     * 2024/3/20
     * URL ：
     * 题目描述：
     **/
    static int[][] map;

    static Map<Integer, Integer> nums;

    static int n;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }

        int k = in.nextInt();
        nums = new HashMap();

        for (int i = 0; i < k; i++) {
            int v = in.nextInt();
            nums.put(v, nums.getOrDefault(v, 0) + 1);
        }


        int l = 0;
        int r = 0;

        int min = Integer.MAX_VALUE;

        boolean isright = true;
        while (l <= r && r < m) {
            if (isright) {
                // 如果包含数组
                if (iscover(l, r)) {
                    isright = false;
                    min = Math.min(min, r - l + 1);
                    l++;
                } else {
                    r++;
                }
            } else {
                if (iscover(l, r)) {
                    min = Math.min(min, r - l + 1);
                    l++;
                } else {
                    isright = true;
                    r++;
                }

            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }


    public static boolean iscover(int l, int r) {
        boolean flag = true;

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = l; j <= r; j++) {
                map1.put(map[i][j], map1.getOrDefault(map[i][j], 0) + 1);
            }
        }

        for (Integer integer : nums.keySet()) {
            if (!map1.containsKey(integer) || map1.get(integer) < nums.get(integer)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
