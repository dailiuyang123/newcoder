package second;

import java.util.Scanner;

public class HJ35 {

    /**
     * 蛇形矩阵
     * <p>
     * 输入：
     * 4
     * <p>
     * 输出：
     * 1 3 6 10
     * 2 5 9
     * 4 8
     * 7
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] s = new int[n][n];
        int max = (1 + n) * n / 2;
        // 下标
        int h = 0;
        int k = 1;
        int i = n - 1;
        while (i >= 0) {
//            System.out.println(h + ":" + i);
            s[h][i] = max;
            max--;
            // 终止赋值
            if (max <= 0) {
                break;
            }

            i--;
            // 给二维数组的 高，宽 进行赋值。当出现最边界时，进行特殊处理，使之能够往复运动。
            if (h == n - k) {
                h = 0;
                k++;
                i = (n - k);
            } else {
                h = h + 1;
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n - y; x++) {
                System.out.print(s[y][x] + " ");
            }
            System.out.println();
        }

    }


}
