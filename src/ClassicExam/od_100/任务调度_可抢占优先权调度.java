package ClassicExam.od_100;

import java.util.*;

public class 任务调度_可抢占优先权调度 {

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

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if ("".equals(s)) {
                break;
            }
            Integer[] arr = Arrays.stream(s.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            list.add(arr);
        }

        getResult(list);
    }

    /**
     * @param tasks 二维矩阵，元素组数含义是[任务ID，任务优先级，执行时间，到达时间]
     */
    public static void getResult(LinkedList<Integer[]> tasks) {
        // 这里的pq代表等待队列，且CPU总是执行等待队列的队头任务
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // 将最先到达的任务加入等待队列pq中
        pq.offer(tasks.removeFirst());

        // 这里的curTime会记录最新的任务结时刻
        int curTime = 0;
        // ans记录题解，即[任务ID, 结束时刻]
        ArrayList<Integer[]> ans = new ArrayList<>();

        // 遍历出下一个到达的任务
        while (tasks.size() > 0) {
            // 正在执行的任务task1，即等待队列队头任务
            Integer[] task1 = pq.peek();
            // 下一个将要到达的任务task2，tasks已经按照达到时间先后排序，因此tasks队头就是下一个到达任务
            Integer[] task2 = tasks.removeFirst();

            // 解析出task1任务的id，执行时长，到达时刻
            Integer id1 = task1[0];
            Integer need1 = task1[2];
            Integer arrived1 = task1[3];

            // 解析出task2任务的到达时刻
            Integer arrived2 = task2[3];

            // end表示正在执行的任务task1的理想结束时刻
            int end = arrived1 + need1;

            // 如果task2的到达时刻  大于等于  正在执行任务task1的理想结束时刻
            if (arrived2 >= end) {
                // 则说明 正在执行的task1任务可以执行完，因此end就是正在执行任务的实际结束时刻，将其统计进ans题解
                ans.add(new Integer[]{id1, end});
                // 并且执行完的任务从等待队列pq出队
                pq.poll();

                // 如果如果下一个任务的到达时刻  大于  正在执行任务的理想结束时刻，则说明存在CPU空转
                if (arrived2 > end) {
                    // more记录CPU空转时长
                    int more = arrived2 - end;

                    // 此时如果等待队列pq还有任务，则应该取出最高优先级任务交给CPU执行
                    while (pq.size() > 0) {
                        // 我们用task3表示从等待队列中取出的最高优先级任务
                        Integer[] task3 = pq.peek();

                        // 解析task3任务的id和执行时长
                        Integer id3 = task3[0];
                        Integer need3 = task3[2];

                        // 如果task3所需的执行时长，小于CPU空转时长，则说明我们还可以取出等待队列的队头任务继续执行
                        if (need3 <= more) {
                            end += need3;
                            more -= need3;
                            ans.add(new Integer[]{id3, end});
                            pq.poll();
                        }
                        // 否则只能将等待队列task3任务执行部分时间，无法执行完成，若想继续执行，需要看下一个任务和task3任务的优先级谁高
                        else {
                            task3[2] -= more;
                            break;
                        }
                    }
                }
            }
            // 如果task2的到达时刻  小于  正在执行任务task1的理想结束时刻
            else {
                // 则task1只能执行部分时间，无法执行完，后续是否能继续执行，得看task2和task1的优先级谁高
                task1[2] -= arrived2 - arrived1;
            }

            // 下一个任务到达时间，就是当前任务执行结束时间（非严格执行结束时间，后面还会比较优先级，如果当前任务优先级高，则下一轮循环，还是执行当前任务）
            curTime = arrived2;
            // 将下一个任务加入到等待队列，并进行优先级比较，如果优先级高，就会到队头位置，
            pq.offer(task2);
        }

        // 任务遍历结束后，则看等待队列是否有任务，如果有，则任务均已按照优先级从高到低排序好，此时我们只需要依次执行即可，不需要再比较优先级
        while (pq.size() > 0) {
            Integer[] task = pq.poll();

            Integer id = task[0];
            Integer need = task[2];

            curTime += need;
            ans.add(new Integer[]{id, curTime});
        }

        ans.forEach(task -> System.out.println(task[0] + " " + task[1]));
    }


}
