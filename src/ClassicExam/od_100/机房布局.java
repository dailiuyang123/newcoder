package ClassicExam.od_100;

import java.util.LinkedList;
import java.util.Scanner;

public class 机房布局 {

    /**
     * 题目描述
     * 小明正在规划一个大型数据中心机房，为了使得机柜上的机器都能正常满负荷工作，需要确保在每个机柜边上至少要有一个电箱。
     * 为了简化题目，假设这个机房是一整排，M表示机柜，I表示间隔，请你返回这整排机柜，至少需要多少个电箱。 如果无解请返回 -1 。
     * <p>
     * 输入描述
     * 无
     * <p>
     * 输出描述
     * 无
     * <p>
     * 用例
     * 输入	MIIM
     * 输出	2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(getResult(str));
    }

    public static int getResult(String str) {
        int n = str.length();
        // 声明一个栈，栈内内存放每个M的区间，如果两个M的区间重合，则说明可以
        // 共享一个电源。
        LinkedList<Integer[]> stack = new LinkedList<>();
        boolean stick = false;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'M') {
                // // 如果机柜A两边都是机柜，或者没有间隔，则无法给机柜A放电箱，返回-1
                boolean left = i - 1 < 0 || str.charAt(i - 1) == 'M';
                boolean right = i + 1 >= n || str.charAt(i + 1) == 'M';
                if (left && right) {
                    return -1;
                }

                // 将求解最少电箱问题，转化为区间交集问题
                Integer[] range = {Math.max(0, i - 1), Math.min(n - 1, i + 1)};

                if (stack.size() > 0 && !stick) {
                    int e1 = stack.getLast()[1];
                    int s2 = range[0];

                    if (e1 == s2) {
                        stack.removeLast();
                        stick = true;
                    }
                } else {
                    stick = false;
                }
                stack.addLast(range);
            }
        }

        return stack.size();
    }


}
