package ClassicExam.array;

import java.util.Arrays;

public class BM95_分糖果 {


    /**
     * 一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下：
     * <p>
     * 1. 每个孩子不管得分多少，起码分到一个糖果。
     * 2. 任意两个相邻的孩子之间，得分较多的孩子必须拿多一些糖果。(若相同则无此限制)
     * <p>
     * https://www.nowcoder.com/practice/76039109dd0b47e994c08d8319faa352?tpId=295&tqId=1008104&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=295
     */
    public int candy(int[] arr) {
        // write code here

        if (arr.length <= 1) {
            return arr.length;
        }

        int[] candy = new int[arr.length];
        // 先把最低分给糖果
        Arrays.fill(candy, 1);
        //从左到右遍历
        for (int i = 1; i < arr.length; i++) {
            // 如果是：递增
            if (arr[i] > arr[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        // 记录总糖果数
        // 从右向左便利：
        for (int i = arr.length - 2; i >= 0; i--) {
            //如果左边更大但是糖果数更小
            if (arr[i] > arr[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
        }

        int sum = Arrays.stream(candy).sum();
        return sum;

    }


    public static void main(String[] args) {

        BM95_分糖果 bm95_分糖果 = new BM95_分糖果();

//        int[] arr = {1,1,2};
        int[] arr = {10, 4, 10, 10, 4};
        int candy = bm95_分糖果.candy(arr);
        System.out.println(candy);


    }


}
