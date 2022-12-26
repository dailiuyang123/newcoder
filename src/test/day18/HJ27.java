package test.day18;

import java.util.*;

public class HJ27 {

    // 查找兄弟单词

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String next = in.next();
            arr[i] = next;
        }
        String s = in.next();
        int m = in.nextInt();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int length = chars.length;

        int begin = 0;
        Deque<Character> path = new ArrayDeque<>();
        int index = 0;
        boolean[] used = new boolean[n];
        List<String> res = new ArrayList<>();
        dfs(chars, length, begin, path, index, used, res, m);
        Collections.sort(res);
        System.out.println(res);
    }


    private static void dfs(char[] chars, int length, int begin, Deque<Character> path, int index, boolean[] used, List<String> res, int m) {
        if (path.size() == length) {
            if (index == m) {
                System.out.println(path);
            }
            ArrayList<Character> characters = new ArrayList<>(path);
            res.add(characters.toString());
            index++;
            return;
        }

        for (int i = begin; i < length; i++) {
            if (used[i]) {
                continue;
            }
            path.push(chars[i]);
            used[i] = true;
            dfs(chars, length, begin, path, index, used, res, m);
            //回溯
            path.pop();
            used[i] = false;
        }


    }


}
