package second;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HJ94 {

    /**
     * 计票统计
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String next = in.next();
            map.put(next, 0);
        }

        int m = in.nextInt();

        int invalid = 0;
        for (int i = 0; i < m; i++) {
            String next = in.next();
            if (map.containsKey(next)) {
                map.put(next, map.get(next) + 1);
            } else {
                invalid++;
            }
        }

        for (String s : map.keySet()) {
            System.out.println(s+" : "+map.get(s));
        }
        System.out.println("Invalid : "+invalid);
    }

}
