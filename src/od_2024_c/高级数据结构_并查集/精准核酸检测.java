package od_2024_c.高级数据结构_并查集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 精准核酸检测 {
    /**
     * 2024/4/23
     * URL ：https://blog.csdn.net/qfc_128220/article/details/135004914?spm=1001.2014.3001.5501
     * 题目描述：
     **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] map = new int[n][n];
        in.nextLine();
        int[] x = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::valueOf).toArray();
        }
        UninFind uninFind = new UninFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map[i][j] == 1) {
                    uninFind.union(i, j);
                }
            }
        }

        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            counts[uninFind.find(uninFind.fa[i])]++;
        }

        int res = 0;
        // todo 记录已经确认过的集合
        HashSet<Integer> confirm_fa = new HashSet<>();
        for (int i : x) {
            int fa = uninFind.find(i);
            if (!confirm_fa.contains(fa)) {
                res += counts[fa];
                confirm_fa.add(fa);
            }
        }
        System.out.println(res - x.length);
    }

    static class UninFind {

        int[] fa;

        public UninFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            if (fa[x] != x) {
                fa[x] = find(fa[x]);
                return fa[x];
            }
            return x;
        }


        public void union(int x, int y) {
            // todo 获取个门派的掌门
            int f_x = find(x);
            int f_y = find(y);
            if (f_x != f_y) {
                fa[f_y] = f_x;
            }
        }
    }

}
