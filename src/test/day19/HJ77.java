package test.day19;

import java.util.*;

public class HJ77 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int nums = in.nextInt();
            int[] id = new int[nums];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums; i++) {
                id[i] = in.nextInt();
            }
            List<String> l = new ArrayList<>();
            trainOut(id, 0, stack, "", 0, l);
            //对结果集排序
            Collections.sort(l);
            for (String str : l) {
                System.out.println(str);
            }
        }
        in.close();
    }

    public static void trainOut(int[] id, int i, Stack<Integer> s, String str,
                                int n, List<String> l) {
        if (n == id.length) {
            l.add(str); //如果所有火车均出栈则将当前结果保存
        }

        if (!s.empty()) { //栈非空时出栈
            int temp = s.pop();
            trainOut(id, i, s, str + temp + " ", n + 1, l);
            s.push(temp); //恢复现场
        }

        if (i < id.length) {
            s.push(id[i]);
            trainOut(id, i + 1, s, str, n, l);
            s.pop(); //恢复现场

        }
    }

}
