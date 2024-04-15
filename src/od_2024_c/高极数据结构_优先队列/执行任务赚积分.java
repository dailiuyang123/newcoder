package od_2024_c.高极数据结构_优先队列;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 执行任务赚积分 {
    /**
     * 2024/4/8
     * URL ：https://fcqian.blog.csdn.net/article/details/134719131
     * 题目描述：题目描述
     * 现有N个任务需要处理，同一时间只能处理一个任务，处理每个任务所需要的时间固定为1。
     * <p>
     * 每个任务都有最晚处理时间限制和积分值，在最晚处理时间点之前处理完成任务才可获得对应的积分奖励。
     * <p>
     * 可用于处理任务的时间有限，请问在有限的时间内，可获得的最多积分。
     * <p>
     * 输入描述
     * 第一行为一个数 N，表示有 N 个任务
     * <p>
     * 1 ≤ N ≤ 100
     * 第二行为一个数 T，表示可用于处理任务的时间
     * <p>
     * 1 ≤ T ≤ 100
     * 接下来 N 行，每行两个空格分隔的整数（SLA 和 V），SLA 表示任务的最晚处理时间，V 表示任务对应的积分。
     * <p>
     * 1 ≤ SLA ≤ 100
     * 0 ≤ V ≤ 100000
     * 输出描述
     * 可获得的最多积分
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[][] map = new int[n][2];
        for (int i = 0; i < n; i++) {
            map[i][0] = in.nextInt();
            map[i][1] = in.nextInt();
        }
        Arrays.sort(map, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        int curTIme = 0;
        int res = 0;
        for (int[] ints : map) {
            int endTime = ints[0];
            int score = ints[1];

            if (curTIme < endTime) {
                pq.offer(score);
                res += score;
                curTIme++;
            } else {
                if (pq.isEmpty()) {
                    continue;
                }
                // todo 说明，当前任务，上一个任务在同一个时间点上，判断score大小，保留最大的
                Integer peek = pq.peek();
                if (score > peek) {
                    pq.poll();
                    pq.offer(score);
                    res += score - peek;
                }
            }
        }

        // 由于，t时间限制，超时，poll出score小的
        while (pq.size() > t && t>0) {
            Integer poll = pq.poll();
            res -= poll;
        }

        System.out.println(res);
    }

}
