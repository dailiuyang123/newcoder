package ClassicExam.array;

import java.util.Scanner;

public class 矩阵最大值 {

    /**
     * 给定一个仅包含0和1的n*n二维矩阵，请计算二维矩阵的最大值
     * 计算规则如下：
     * <p>
     * 每行元素按下标顺序组成一个二进制数(下标越大约排在低位)，二进制数的值就是该行的值，矩阵各行之和为矩阵的值。允许通过向左或向右整体循环移动每个元素来改变元素在行中的位置。
     * <p>
     * 比如：
     * [1,0,1,1,1] 向右整体循环移动两位 [1,1,1,0,1]，二进制数为11101 值为29
     * [1,0,1,1,1] 向左整体循环移动两位 [1,1,1,1,0]，二进制数为11110 值为30
     * <p>
     * 输入描述：
     * 数据的第一行为正整数，记录了N的大小，0
     * <p>
     * 输入的第2到n+1行为二维矩阵信息
     * <p>
     * 行内元素边角逗号分割
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int nextInt = in.nextInt();
        int max = 0;
        for (int i = 0; i < nextInt; i++) {
            // todo 注意 next() 与 nextLine()的区别
            String s = in.next();
            int maxtemp = 0;
            s = s.replaceAll("\\,", "");
            // 单行最大值？
            for (int j = 1; j < s.length(); j++) {
                String left = s.substring(0, j);
                String right = s.substring(j);
                maxtemp = Math.max(maxtemp, Integer.parseInt(right + left, 2));
            }
            max += maxtemp;
        }

        System.out.println(max);

    }


}
