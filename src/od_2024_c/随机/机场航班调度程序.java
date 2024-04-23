package od_2024_c.随机;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringJoiner;

public class 机场航班调度程序 {
    /**
     * 2024/4/22
     * URL ：https://hydro.ac/d/HWOD2023/p/OD375
     * 题目描述：
     **/
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        Plan[] plans = new Plan[split.length];
        for (int i = 0; i < plans.length; i++) {
            plans[i] = new Plan(split[i].substring(0, 2), Integer.valueOf(split[i].substring(2)));
        }

        Arrays.sort(plans, new Comparator<Plan>() {
            @Override
            public int compare(Plan o1, Plan o2) {
                if (!o1.head.equals(o2.head)) {
                    return o1.head.compareTo(o2.head);
                } else {
                    return o1.number - o2.number;
                }
            }
        });

        StringJoiner sj = new StringJoiner(",");
        for (Plan plan : plans) {
            sj.add(plan.head + plan.number);
        }

        System.out.println(sj);
    }

    static class Plan {

        String head;
        int number;

        public Plan(String head, int number) {
            this.head = head;
            this.number = number;
        }
    }

}
