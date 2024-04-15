package od_2024_c.贪心;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 小朋友来自多少小区 {
    /**
     * 2024/4/12
     * URL ：
     * 题目描述：
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int res = 0;
        for (Integer i : map.keySet()) {
            Integer val = map.get(i);
            res += Math.ceil(val * 1f / (i + 1)) * (i + 1);
        }

        System.out.println(res);
    }

}
