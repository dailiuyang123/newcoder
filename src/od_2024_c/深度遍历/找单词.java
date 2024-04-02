package od_2024_c.深度遍历;

import java.util.*;

public class 找单词 {
    /**
     * 2024/3/4
     * URL ：https://fcqian.blog.csdn.net/article/details/127711515
     * 题目描述：
     **/

    static char[][] chars;

    static String target;

    static int[] x_arr = {1, -1, 0, 0};
    static int[] y_arr = {0, 0, 1, -1};

    static int n;

    static List<List<int[]>> res = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = in.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                chars[i][j] = split[j].charAt(0);
            }
        }
        target = in.nextLine();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == target.charAt(0)) {
                    LinkedList<int[]> path = new LinkedList<>();
                    path.add(new int[]{i, j});
                    dfs(i, j, new boolean[n][n], path);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        List<int[]> list = res.get(0);
        for (int i=list.size()-1; i>=0;i--) {

            sb.append(list.get(i)[0]).append(",").append(list.get(i)[1]).append(",");
        }
        System.out.println(sb.toString());


    }

    public static void dfs(int y, int x, boolean[][] used, LinkedList<int[]> path) {


        if (path.size() == target.length()) {
            res.add(new ArrayList<int[]>(path));
            return;
        }

        for (int i = 0; i < x_arr.length; i++) {

            int t_x = x + x_arr[i];
            int t_y = y + y_arr[i];

            if (t_x >= 0 && t_x < n && t_y >= 0 && t_y < n && !used[t_y][t_x] && chars[t_y][t_x] == target.charAt(path.size())) {
                used[t_y][t_x] = true;
                path.push(new int[]{t_y, t_x});
                dfs(t_y, t_x, used, path);
                used[t_y][t_x] = false;
                path.pop();
            }

        }


    }


}
