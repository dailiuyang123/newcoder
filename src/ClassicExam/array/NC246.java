package ClassicExam.array;

import java.util.Arrays;

public class NC246 {

    /**
     * 杨辉三角（二）
     * https://www.nowcoder.com/practice/486a9408fe2d4912843795c25d43acc2?tpId=196&tqId=39664&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public int[] getRow(int num) {
        // write code here
        int initL = 0;
        if (num <= 2) {
            initL = 2;
        } else {
            initL = num;
        }

        // todo  注意 num<3 声明数组的长度
        int[][] cache = new int[initL + 1][initL + 1];
        cache[0] = new int[]{1};
        cache[1] = new int[]{1, 1};
        cache[2] = new int[]{1, 2, 1};

        if (num > 2) {
            for (int i = 3; i <= num; i++) {
                cache[i][0] = 1;
                for (int j = 1; j < i; j++) {
                    cache[i][j] = cache[i - 1][j - 1] + cache[i - 1][j];
                }
                cache[i][i] = 1;
            }
        }
        return cache[num];
    }


    public static void main(String[] args) {

        NC246 nc246 = new NC246();
        int[] row = nc246.getRow(6);
        System.out.println(Arrays.asList(row).toString());


    }


}
