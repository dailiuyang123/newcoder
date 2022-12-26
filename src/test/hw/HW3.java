package test.hw;

import java.util.Scanner;

public class HW3 {

//    明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
//
//数据范围： 1 \le n \le 1000 \1≤n≤1000  ，输入的数字大小满足 1 \le val \le 500 \1≤val≤500

    public static void main(String[] args) {
        int[] arr = new int[501];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            arr[v] = v;
        }
        int i = 1;
        while (i < 501) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
            i++;
        }

    }


}
