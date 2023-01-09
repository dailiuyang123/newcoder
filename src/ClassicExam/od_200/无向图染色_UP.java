package ClassicExam.od_200;

import java.util.ArrayList;
import java.util.Scanner;

public class 无向图染色_UP {


    /**
     * 题目描述
     * 给一个无向图染色，可以填红黑两种颜色，必须保证相邻两个节点不能同时为红色，输出有多少种不同的染色方案？
     * <p>
     * 输入描述
     * 第一行输入M(图中节点数) N(边数)
     * <p>
     * 后续N行格式为：V1 V2表示一个V1到V2的边。
     * <p>
     * 数据范围：1 <= M <= 15,0 <= N <= M * 3，不能保证所有节点都是连通的。
     * <p>
     * 输出描述
     * 输出一个数字表示染色方案的个数。
     * <p>
     * 用例
     * 输入	4 4
     * 1 2
     * 2 4
     * 3 4
     * 1 3
     * 输出	7
     * 说明
     * 4个节点，4条边，1号节点和2号节点相连，
     * <p>
     * 2号节点和4号节点相连，3号节点和4号节点相连，
     * <p>
     * 1号节点和3号节点相连，
     * <p>
     * 若想必须保证相邻两个节点不能同时为红色，总共7种方案。
     * <p>
     * 方案[1,2,3,4,  1-4 , 2-3   1-2-3-4 都为黑  ]
     * <p>
     * 数据范围比较小：可以考虑暴力解法
     * 图
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[][] map = new int[m][2];
        for (int i = 0; i < m; i++) {
            map[i][0] = in.nextInt();
            map[i][1] = in.nextInt();
        }

        int count = 0;

        // 遍历所有可能的组合 举例：10001 -> i 的二进制表达
        for (int i = 0; i < (1 << m); i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                // 检测所有的边相等的是否同为红颜色
                if (((i >> (m - map[j][0])) & 1) == 1 && ((i >> (m - map[j][1])) & 1) == 1) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }


    public static void main2(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String param_str = in.nextLine();
        String[] param_list = param_str.split(" ");
        int m = Integer.valueOf(param_list[0]);
        int n = Integer.valueOf(param_list[1]);

        //构造输入数据结构
        ArrayList<ArrayList<Integer>> edgeArrayList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            String edge_str = in.nextLine();
            String[] edge_point = edge_str.split(" ");
            ArrayList<Integer> singleEdge = new ArrayList<Integer>();
            singleEdge.add(Integer.valueOf(edge_point[0]));
            singleEdge.add(Integer.valueOf(edge_point[1]));
            edgeArrayList.add(singleEdge);
        }

        int count = 0;
        //遍历所有可能的组合 举例： 10001 -> i 的二进制表达
        for (int i = 0; i < (1 << m); i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                // 检测所有的边相连的是否同为红颜色
                if (((i >> (m - edgeArrayList.get(j).get(0))) & 1) == 1 && ((i >> (m - edgeArrayList.get(j).get(1))) & 1) == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);

    }

}
