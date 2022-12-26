package test.hw_r;

import java.util.Arrays;
import java.util.Scanner;

public class AB33 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        int min = arr[0];
        int count = 0;
        // 滑动窗口做
        for (int i = n; i > 1; i--) {
            // 窗口大小
            for (int l = 0; l + i - 1 < n; l++) {
                if (arr[l + i - 1] - arr[l] <= k) {
                    count = i;
                    System.out.println(count);
                    return;
                }
            }
        }

    }
}
