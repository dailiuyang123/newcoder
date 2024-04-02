package od_2024_c.数据结构_二叉树;

import java.util.Scanner;

public class 计算三叉搜索树的高度_classic {
    /**
     * 2024/4/1
     * URL ：https://fcqian.blog.csdn.net/article/details/134709517
     * 题目描述：描述
     * 定义构造三叉搜索树规则如下：
     * <p>
     * 每个节点都存有一个数，当插入一个新的数时，从根节点向下寻找，直到找到一个合适的空节点插入。查找的规则是：
     * <p>
     * 如果数小于节点的数减去500，则将数插入节点的左子树
     * 如果数大于节点的数加上500，则将数插入节点的右子树
     * 否则，将数插入节点的中子树
     * 给你一系列数，请按以上规则，按顺序将数插入树中，构建出一棵三叉搜索树，最后输出树的高度。
     * <p>
     * 输入描述
     * 第一行为一个数 N，表示有 N 个数，1 ≤ N ≤ 10000
     * <p>
     * 第二行为 N 个空格分隔的整数，每个数的范围为[1,10000]
     * <p>
     * 输出描述
     * 输出树的高度（根节点的高度为1）
     **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            tree.add(t);
        }

        System.out.println(tree.height);

    }

    static class TreeNode {
        int val;
        int height;
        TreeNode left;
        TreeNode mid;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Tree {
        TreeNode root;
        int height;

        public void add(int val) {
            TreeNode node = new TreeNode(val);
            if (root == null) {
                node.height = 1;
                root = node;
                height = 1;
            } else {
                TreeNode cur = root;

                while (true) {
                    node.height = cur.height + 1;
                    // todo 更新深度
                    height = Math.max(node.height, height);
                    if (val < cur.val - 500) {  // todo 左节点

                        if (cur.left == null) {
                            cur.left = node;
                            break;
                        } else {
                            cur = cur.left;
                        }
                    } else if (val > cur.val + 500) {     // todo 右节点
                        if (cur.right == null) {
                            cur.right = node;
                            break;
                        } else {
                            cur = cur.right;
                        }
                    } else {      // 中间节点
                        if (cur.mid == null) {
                            cur.mid = node;
                            break;
                        } else {
                            cur = cur.mid;
                        }
                    }
                }
            }
        }
    }


}
