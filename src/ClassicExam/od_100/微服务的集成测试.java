package ClassicExam.od_100;

import java.util.*;

public class 微服务的集成测试 {

    /**
     * 题目描述
     * 现在有n个容器服务，服务的启动可能有一定的依赖性（有些服务启动没有依赖），其次服务自身启动加载会消耗一些时间。
     * 给你一个nxn的二维矩阵useTime，其中useTime[i][i]=10表示服务i自身启动加载需要消耗10s，
     * useTime[i][j] = 1表示服务i启动依赖服务j启动完成，useTime[i][k]=0表示服务i启动不依赖服务k。
     * 其中 0 <= i,j,k < n。
     * <p>
     * 输入描述
     * 第一行输入服务总量 n，
     * 之后的 n 行表示服务启动的依赖关系以及自身启动加载耗时
     * 最后输入 k 表示计算需要等待多少时间后可以对服务 k 进行集成测试
     * <p>
     * 输出描述
     * 最少需要等待多少时间(s)后可以对服务 k 进行集成测试
     * <p>
     * 输入	4
     * 2 0 0 0
     * 0 3 0 0
     * 1 1 4 0
     * 1 1 1 5
     * 4
     * 输出	12
     * 说明	服务3启动依赖服务1和服务2，服务4启动需要依赖服务1，2，3，服务1，2，3自身加载需要消耗2s,3s,4s,5s，所以3+4+5=12s（因为服务1和服务2可以同时启动），要等待12s后可以对服务4进行集成测试。
     * 输入	5
     * 1 0 0 0 0
     * 0 2 0 0 0
     * 1 1 3 0 0
     * 1 1 0 4 0
     * 0 0 1 1 5
     * 5
     * 输出	11
     * 说明	服务3启动依赖服务1和服务2，服务4启动需要依赖服务1，2，服务5启动需要依赖服务3，5，服务1，2，3，4，5自身加载需要消耗1s,2s,3s,4s,5s，所以2+4+5=11s（因为服务1和服务2可以同时启动，服务3和服务4可以同时启动），要等待11s后可以对服务5进行集成测试。
     * <p>
     * <p>
     * 题目解析
     * 本题看上去是用拓扑排序，但其实不用。
     * <p>
     * 我们只需要记录每一个服务启动的直接前提服务，比如用例1中：
     * <p>
     * pre[3]=2，即表示3服务启动，需要前提服务2先启动，
     * <p>
     * pre[2]=1，即表示2服务启动，需要前提服务1先启动。
     * <p>
     * 当我们记录好每一个服务的直接前提服务后，就可以直接找到k服务的所有直接前提服务，然后求其所有直接前提服务中耗时最多的，作为这一层的耗时。
     * <p>
     * 在求解k服务的直接前提服务的最多耗时时，我们需要将每一个前提服务的自身的前提服务再记录下来，作为下一层。就这样一层一层往上找，直到没有前提服务为止。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();

        System.out.println(getResult(matrix, n, k));
    }

    public static int getResult(int[][] matrix, int n, int k) {
        HashMap<Integer, ArrayList<Integer>> pre = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] == 1) {
                    pre.putIfAbsent(i, new ArrayList<>());
                    pre.get(i).add(j);
                }
            }
        }

        k = k - 1;
        int ans = matrix[k][k];

        LinkedList<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(pre.get(k));

        while (queue.size() > 0) {
            ArrayList<Integer> services = queue.removeFirst();

            int max = 0;
            ArrayList<Integer> level = new ArrayList<>();
            for (Integer i : services) {
                max = Math.max(max, matrix[i][i]);
                if (pre.containsKey(i)) {
                    level.addAll(pre.get(i));
                }
            }
            ans += max;
            if (level.size() > 0) {
                queue.add(level);
            }
        }

        return ans;
    }


}
