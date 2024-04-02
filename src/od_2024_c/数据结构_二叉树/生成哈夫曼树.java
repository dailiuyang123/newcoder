package od_2024_c.数据结构_二叉树;

import java.util.Scanner;

public class 生成哈夫曼树 {
    /**
     * 2024/4/1
     * URL ：
     * 题目描述：题目描述
     * 给定长度为 n 的无序的数字数组，每个数字代表二叉树的叶子节点的权值，数字数组的值均大于等于1。
     * <p>
     * 请完成一个函数，根据输入的数字数组，生成哈夫曼树，并将哈夫曼树按照中序遍历输出。
     * <p>
     * 为了保证输出的二叉树中序遍历结果统一，增加以下限制：
     * <p>
     * 二叉树节点中，左节点权值小于右节点权值，根节点权值为左右节点权值之和。当左右节点权值相同时，左子树高度小于等于右子树高度。
     * <p>
     * 注意：
     * <p>
     * 所有用例保证有效，并能生成哈夫曼树。
     * <p>
     * 提醒：
     * <p>
     * 哈夫曼树又称为最优二叉树，是一种带权路径长度最短的二叉树。
     * <p>
     * 所谓树的带权路径长度，就是树中所有的叶节点的权值乘上其到根节点的路径长度（若根节点为 0 层，叶节点到根节点的路径长度为叶节点的层数）
     **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) nums[i] = in.nextInt();

        int cnt = 0;
        // todo 双层for循环，外层，遍历中间节点
        // todo res= bigL * smallR + smallL * bigR;
        for (int i = 1; i < n - 1; i++) {

            int mid = nums[i];
            int smallLeft = 0;
            int bigLeft = 0;

            for (int j = 0; j < i; j++) {
                if (mid > nums[j]) {
                    smallLeft++;
                } else {
                    bigLeft++;
                }
            }

            int smallR = 0;
            int bigR = 0;
            for (int k = i + 1; k < n; k++) {
                if (mid > nums[k]) {
                    smallR++;
                } else {
                    bigR++;
                }
            }
            cnt += bigLeft * smallR + smallLeft * bigR;
        }

        System.out.println(cnt);

    }
}
