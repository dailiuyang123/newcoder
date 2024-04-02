package od_2024_c.数据结构_二叉树;

import java.util.HashMap;
import java.util.Scanner;

public class 模拟目录管理功能 {
    /**
     * 2024/4/2
     * URL ：https://fcqian.blog.csdn.net/article/details/134387544
     * 题目描述：题目描述
     * 实现一个模拟目录管理功能的软件，输入一个命令序列，输出最后一条命令运行结果。
     * <p>
     * 支持命令：
     * <p>
     * 创建目录命令：mkdir 目录名称，如 mkdir abc 为在当前目录创建abc目录，如果已存在同名目录则不执行任何操作。此命令无输出。
     * 进入目录命令：cd 目录名称，如 cd abc 为进入abc目录，特别地，cd .. 为返回上级目录，如果目录不存在则不执行任何操作。此命令无输出。
     * 查看当前所在路径命令：pwd，输出当前路径字符串。
     * 约束：
     * <p>
     * 目录名称仅支持小写字母；mkdir 和 cd 命令的参数仅支持单个目录，如：mkdir abc 和 cd abc；不支持嵌套路径和绝对路径，如 mkdir abc/efg，cd abc/efg，mkdir /abc/efg，cd /abc/efg 是不支持的。
     * 目录符号为/，根目录/作为初始目录。
     * 任何不符合上述定义的无效命令不做任何处理并且无输出。
     * 输入描述
     * 输入 N 行字符串，每一行字符串是一条命令。
     * <p>
     * 输出描述
     * 输出最后一条命令运行结果字符串。
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String lastCommand = "";

        Tree tree = new Tree();
        while (in.hasNextLine()) {
            String line = in.nextLine();

            if (line.equals("")) break;

            String[] temp = line.split(" ");
            String cmd_key = temp[0];
            if (cmd_key.equals("pwd")) {
                if (temp.length != 1) {
                    continue;
                }
                lastCommand = tree.pwd();
            } else if (cmd_key.equals("cd") || cmd_key.equals("mkdir")) {
                if (temp.length != 2) {
                    continue;
                }
                String val = temp[1];
                if (cmd_key.equals("mkdir")) {
                    tree.mkdir(val);
                    lastCommand = "";
                } else {
                    tree.cd(val);
                    lastCommand = "";
                }
            }
        }

        System.out.println(lastCommand);
    }

    static class TreeNode {
        // todo  treeNode 目录树节点：三个属性: 目录名称，父节点，子节点
        String curDicName;
        TreeNode father;
        HashMap<String, TreeNode> child;


        public TreeNode(String curDicName, TreeNode father) {
            this.curDicName = curDicName;
            this.father = father;
            this.child = new HashMap<>();
        }
    }

    static class Tree {
        TreeNode root;
        TreeNode cur;

        // todo 空构造：初始化 root 根目录，并将当前节点置为根节点
        public Tree() {
            this.root = new TreeNode("/", null);
            this.cur = root;
        }

        public void mkdir(String childDicName) {
            this.cur.child.putIfAbsent(childDicName, new TreeNode(childDicName + "/", this.cur));
        }

        public void cd(String dicName) {
            if (dicName.equals("..")) {
                if (this.cur.father != null) {
                    this.cur = this.cur.father;
                }
            } else {
                if (this.cur.child.containsKey(dicName)) {
                    this.cur = this.cur.child.get(dicName);
                }
            }
        }

        public String pwd() {

            StringBuilder sb = new StringBuilder();
            TreeNode cur = this.cur;

            while (cur != null) {
                sb.insert(0, cur.curDicName);
                cur = cur.father;
            }
            return sb.toString();
        }
    }


}
