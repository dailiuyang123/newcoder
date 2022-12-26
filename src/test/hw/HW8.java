package test.hw;

import java.util.*;

public class HW8 {
    // 合并表记录
//    数据表记录包含表索引index和数值value（int范围的正整数），
//    请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 输出结果要求有序！
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; ++i) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                map.put(a, map.getOrDefault(a, 0) + b);
            }
        }
        for (Integer i : map.keySet()) {
            System.out.println(i + " " + map.get(i));
        }
    }


}
