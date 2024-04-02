package ClassicExam.od_200;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class 最大化控制资源成本 {

    /**
     * 题目描述
     * 公司创新实验室正在研究如何最小化资源成本，最大化资源利用率，请你设计算法帮他们解决一个任务混部问题：
     * <p>
     * 有taskNum项任务，每个任务有开始时间（startTime），结束时间（endTime），并行度（parallelism）三个属性，
     * <p>
     * 并行度是指这个任务运行时将会占用的服务器数量，一个服务器在每个时刻可以被任意任务使用但最多被一个任务占用，任务运行完成立即释放（结束时刻不占用）。
     * <p>
     * 任务混部问题是指给定一批任务，让这批任务由同一批服务器承载运行，
     * <p>
     * 请你计算完成这批任务混部最少需要多少服务器，从而最大化控制资源成本。
     * <p>
     * 输入描述
     * 第一行输入为taskNum，表示有taskNum项任务
     * 接下来taskNum行，每行三个整数，表示每个任务的
     * <p>
     * 开始时间（startTime ），结束时间（endTime ），并行度（parallelism）
     * <p>
     * <p>
     * 备注
     * 1 <= taskNum <= 100000
     * 0 <= startTime < endTime <= 50000
     * 1 <= parallelism <= 100
     * <p>
     * 【思路】 利用差分解决
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] tasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            // 开始时间
            tasks[i][0] = in.nextInt();
            // 结束时间
            tasks[i][1] = in.nextInt();
            // 并行度
            tasks[i][2] = in.nextInt();
        }


        // 创建一个 差分数组

        int[] times = new int[50001];

        for (int i = 0; i < n; i++) {

            int l = tasks[i][0];
            int r = tasks[i][1];

            for (int j = l; j < r; j++) {
                times[j] += tasks[i][2];
            }
        }

        int max = Arrays.stream(times).max().getAsInt();
        System.out.println(max);
    }


}
