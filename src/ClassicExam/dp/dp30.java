package ClassicExam.dp;

import java.util.Scanner;

public class dp30 {

    /**
     * 买卖股票的最好的时机（一）
     * https://www.nowcoder.com/practice/351b87e53d0d44928f4de9b6217d36bb?tpId=230&tqId=2364518&ru=/exam/oj&qru=/ta/dynamic-programming/question-ranking&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=230
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }

        int money = 0;
        // 暴力 -- 双循环 超时！！
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                money = Math.max(money, prices[j] - prices[i]);
//            }
//        }
        int min = prices[0];

        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            money = Math.max(money, prices[i] - min);
        }


        System.out.println(money);


    }


}
