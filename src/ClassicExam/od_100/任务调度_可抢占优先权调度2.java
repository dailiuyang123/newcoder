package ClassicExam.od_100;

import java.util.*;

public class 任务调度_可抢占优先权调度2 {

    /**
     * 题目描述
     * 现有一个CPU和一些任务需要处理，已提前获知每个任务的任务ID、优先级、所需执行时间和到达时间。
     * CPU同时只能运行一个任务，请编写一个任务调度程序，采用“可抢占优先权调度”调度算法进行任务调度，规则如下：
     * <p>
     * 如果一个任务到来时，CPU是空闲的，则CPU可以运行该任务直到任务执行完毕。
     * 但是如果运行中有一个更高优先级的任务到来，则CPU必须暂停当前任务去运行这个优先级更高的任务；
     * 如果一个任务到来时，CPU正在运行一个比他优先级更高的任务时，信道大的任务必须等待；
     * 当CPU空闲时，如果还有任务在等待，CPU会从这些任务中选择一个优先级最高的任务执行，相同优先级的任务选择到达时间最早的任务。
     * 输入描述
     * 输入有若干行，每一行有四个数字（均小于10^8）,分别为任务ID，任务优先级，执行时间和到达时间。
     * <p>
     * 每个任务的任务ID不同，优先级数字越大优先级越高，并且相同优先级的任务不会同时到达。
     * <p>
     * 输入的任务已按照到达时间从小到大排序，并且保证在任何时间，处于等待的任务不超过10000个。
     * <p>
     * 输出描述
     * 按照任务执行结束的顺序
     * <p>
     * 用例
     * 输入
     * 1 3 5 1
     * 2 1 5 10
     * 3 2 7 12
     * 4 3 2 20
     * 5 4 9 21
     * 6 4 2 22
     * 输出
     * 1 6
     * 3 19
     * 5 30
     * 6 32
     * 4 33
     * 2 35
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer[]> list = new LinkedList<>();

        int length = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if ("".equals(s)) {
                break;
            }
            Integer[] arr = Arrays.stream(s.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            list.add(arr);
            length += arr[2];
        }

        int[] times = new int[length + list.get(list.size() - 1)[3] + 1];

        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[1] - o1[1];
            }
        });

        PriorityQueue<Integer[]> tempQ = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[1] - o1[1];
            }
        });

        // 既然是优先级为王，把所有 task 都放在优先极队列里。

        for (int i = 1; i < times.length; i++) {
            // 循环判断
            int ct = 0;

            for (int j = 0; j < list.size(); j++) {
                Integer[] temp = list.get(i);
                int left = temp[3];
                int right = temp[3] + temp[2];

                if (i <= right && i >= left) {
                    // 加入到优先极队列
                    tempQ.add(temp);
                    ct++;
                }

            }

            // 当前时间空闲，则取检查优先级队列里优先极最大的等待队列
            if (ct == 0) {
                Integer[] poll = priorityQueue.poll();
                times[i] = poll[0];
                poll[2] = poll[2] - 1;
                priorityQueue.add(poll);
            } else if (ct == 1) { // 说明当前只有一个符合执行之
                Integer[] poll = tempQ.poll();
                times[i] = poll[0];
                tempQ.clear();
            } else {  // 大于1个符合，则比较优先极，优先极别大的执行，极别低的放入等待队列。
                Integer[] poll = tempQ.poll();
            }


        }

        getResult(list);
    }

    /**
     * @param tasks 二维矩阵，元素组数含义是[任务ID，任务优先级，执行时间，到达时间]
     */
    public static void getResult(LinkedList<Integer[]> tasks) {


    }


}
