package second;

import java.util.*;

public class HJ80 {

    /**
     * 整形数组合并
     * <p>
     * 将两个整型数组按照升序合并，并且过滤掉重复数组元素
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Integer nextInt = in.nextInt();
            if (!integers.contains(nextInt)) {
                integers.add(nextInt);
            }
        }

        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            Integer nextInt = in.nextInt();
            if (!integers.contains(nextInt)) {
                integers.add(nextInt);
            }
        }

        Collections.sort(integers);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < integers.size(); i++) {
            sb.append(integers.get(i));
        }
        System.out.println(sb);


    }


}
