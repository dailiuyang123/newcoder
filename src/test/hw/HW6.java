package test.hw;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW6 {

//    功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
//
//
//数据范围： 1 \le n \le 2 \times 10^{9} + 14 \1≤n≤2×10
//9
// +14


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        PriorityQueue<Integer> arr = new PriorityQueue<>();

        for (int i = h / 2; i > 1; i--) {
            if (h % i == 0) {
                arr.add(h / i);
                System.out.print(h/i+" ");
                h = i;
            }
            if (i == 2) {
                arr.add(h);
                System.out.println(h);
            }
        }
        if (arr.size() == 0) {
            arr.add(h);
            System.out.print(h);
        }

//        for (int i = arr.size(); i > 0; i--) {
//            System.out.println(arr.poll());
//        }

    }


    // 判断是否是质数
    public static boolean iszhizi(int s) {
        for (int i = s - 1; i > 1; i--) {
            if (s % i == 0) {
                return false;
            }
        }
        return true;
    }


}
