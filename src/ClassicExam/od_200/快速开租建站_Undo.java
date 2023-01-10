package ClassicExam.od_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class 快速开租建站_Undo {

    /**
     * 题目描述
     * 当前IT部门支撑了子公司颗粒化业务，该部门需要实现为子公司快速开租建站的能力，建站是指在一个全新的环境部署一套IT服务。
     * <p>
     * 每个站点开站会由一系列部署任务项构成，每个任务项部署完成时间都是固定和相等的，设为1。
     * 部署任务项之间可能存在依赖，假如任务2依赖任务1，那么等任务1部署完，任务2才能部署。
     * 任务有多个依赖任务则需要等所有依赖任务都部署完该任务才能部署。
     * 没有依赖的任务可以并行部署，优秀的员工们会做到完全并行无等待的部署。
     * 给定一个站点部署任务项和它们之间的依赖关系，请给出一个站点的最短开站时间。
     * <p>
     * 输入描述
     * 第一行是任务数taskNum,第二行是任务的依赖关系数relationsNum
     * <p>
     * 接下来 relationsNum 行，每行包含两个id，描述一个依赖关系，格式为：IDi IDj，表示部署任务i部署完成了，部署任务j才能部署，IDi 和 IDj 值的范围为：[0, taskNum)
     * <p>
     * 注：输入保证部署任务之间的依赖不会存在环。
     * <p>
     * 输出描述
     * 一个整数，表示一个站点的最短开站时间。
     *
     * 测试用例：
     * 5
     * 3
     * 0 3
     * 0 4
     * 1 3
     *
     * 输出：2
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int taskNum = sc.nextInt();
        int relationsNum = sc.nextInt();

        int[][] relations = new int[relationsNum][2];
        for (int i = 0; i < relationsNum; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        System.out.println(getResult(relations, taskNum));
    }

    public static int getResult(int[][] relations, int taskNum) {
        HashMap<Integer, ArrayList<Integer>> next = new HashMap<>();
        int[] inDegree = new int[taskNum];

        for (int[] relation : relations) {
            int a = relation[0];
            int b = relation[1];

            next.putIfAbsent(a, new ArrayList<>());
            next.get(a).add(b); // a的下一个顶点有b
            inDegree[b]++; // b顶点的入度++
        }

        LinkedList<Integer[]> queue = new LinkedList<>();
        int t = 1;

        for (int i = 0; i < taskNum; i++) {
            if (inDegree[i] == 0) {
                queue.add(new Integer[]{i, t}); // i含义是入度为0的顶点，t含义是该顶点所处建站时间
            }
        }

        while (queue.size() > 0) {
            Integer[] tmp = queue.removeFirst(); // 注意这里为了维持t，一定要使用队列先进先出，出队代表删除某顶点
            int task = tmp[0];
            int time = tmp[1];

            if (next.containsKey(task) && next.get(task).size() > 0) {
                for (Integer nxt : next.get(task)) {
                    // 该顶点被删除，则其后继点的入度值--，若--后入度为0，则将成为新的出队点
                    if (--inDegree[nxt] == 0) {
                        t = time + 1; // 此时建站时间+1
                        queue.add(new Integer[]{nxt, t});
                    }
                }
            }
        }

        return t;
    }

}
