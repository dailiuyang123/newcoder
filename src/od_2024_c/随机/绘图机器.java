package od_2024_c.随机;

import java.util.Scanner;

public class 绘图机器 {
    /**
     * 2024/4/22
     * URL ：https://fcqian.blog.csdn.net/article/details/127240714
     * 题目描述：
     **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();

        int[][] cmds = new int[n][2];

        for (int i = 0; i < n; i++) {
            cmds[i][0] = in.nextInt();
            cmds[i][1] = in.nextInt();
        }

        int area = 0;
        int l = cmds[0][0];
        int high = cmds[0][1];
        // todo 遍历指令
        for (int i = 1; i < n; i++) {
            // todo 求取面积
            area += (cmds[i][0] - l) * Math.abs(high);
            high += cmds[i][1];
            l = cmds[i][0];
        }
        // todo 计算 尾部值
        area += (e - l) * Math.abs(high);
        System.out.println(area);
    }

}
