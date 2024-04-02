package od_2024_c.分治递归;

import java.util.Scanner;

public class 分月饼_NO {
    /**
     * 2024/2/19
     * URL ：https://fcqian.blog.csdn.net/article/details/134629018
     * 题目描述：
     * x第0层相当于序号0个员工，该层有多个节点，每个节点的值即为序号0个员工可能分得的月饼数量。
     * <p>
     * 题目说，每个员工至少分得1个月饼，因此序号0个员工分得月饼数至少为1。
     * 为了保证不产生重复方案，因此我们默认当前求解的升序的m个正整数序列，因此序号0个员工分得的月饼数不能超过均值，即 n / m，因为一旦序号0个员工分得的月饼超过均值，则其后面的员工必然会有分得小于均值月饼数的情况。
     * 因此第0个员工分得的月饼数范围是 1 ~ n / m
     * <p>
     * 接下来是第1层，相当于序号1员工，该员工分得的月饼数取决于上一层的员工：
     * <p>
     * 为了保证升序，序号1员工分得的月饼最少数量即序号0员工分得的月饼数量
     * 同时，题目限定相邻员工之间，月饼数差距不能超过3，因此序号1员工最多分得的月饼数量 = 序号0员工分得月饼数量 + 3
     * 另外为了保证后面员工分得月饼数一定不小于序号1员工，因此序号1员工分得的月饼数量不能超过 (剩余月饼数量 ➗ 剩余员工数量) ，其中：
     * 剩余月饼数量 = n - 序号0员工分得的月饼数
     * 剩余员工数量  = m - 1
     * 接下来层数同理，直到第m-1层，即分配到最后一个员工，此时最后一个员工将分得剩余所有月饼，如果最后一个员工和倒数第二个员工月饼数差距bu超过3，即可判断当前递归分支对应的分配方案可行与否
     **/
    static int m;
    static int n;
    static int maxDiff = 3;
    static int res = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();

        if (m == 1) {
            System.out.println(1);
        } else {
            solution(0, 1, n / m, n);
            System.out.println(res);
        }

    }

    public static void solution(int level, int min, int max, int remain) {

        // 说明为最后一名员工，判断是否符合条件
        if (level == m - 1) {

            //最后一个人，与上一个比较，不超过最大值，则成立
            if (remain - min <= maxDiff) {
                res++;
            }
            return;
        }

        for (int i = min; i <= max; i++) {
            remain -= i;
            solution(level + 1, i, Math.min(i + maxDiff, remain / (m - level - 1)), remain);
            remain += i;
        }

    }


}
