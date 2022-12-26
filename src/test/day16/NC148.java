package test.day16;

public class NC148 {


// NC148 几步可以从头跳到尾

//    给你一个长度为 n 的数组 a。
//    ai 表示从 i 这个位置开始最多能往后跳多少格。
//    求从 1 开始最少需要跳几次就能到达第 n 个格子。

//    输入：3,[2,3,1]
//    返回值：1
//
//    说明：从1号格子只需要跳一次就能直接抵达3号格子

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 最少需要跳跃几次能跳到末尾
     *
     * @param n int整型 数组A的长度
     * @param A int整型一维数组 数组A
     * @return int整型
     */
    public int jump(int n, int[] A) {
        // 从尾到头找,找到走一步， 距离尾部最远的位置，以此类推
        int pos = n;
        int step = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 能否一步能到达
            if (i == 0) {
                step=1;
                break;
            }
            if ((A[i] >= (pos - i) && A[i - 1] < (pos - (i - 1)))) {
                n = n - i + 1;
                step = 1 + jump(n, A);
            }
        }
        return step;
    }


    public static void main(String[] args) {
        NC148 nc148 = new NC148();
        int jump = nc148.jump(3, new int[]{3, 3, 2, 1});
        System.out.println(jump);
    }


}
