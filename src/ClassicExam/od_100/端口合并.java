package ClassicExam.od_100;

import java.util.*;
import java.util.stream.Collectors;

public class 端口合并 {

    public static int min_num;

    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        int m = Integer.parseInt(in.nextLine());

        //利用treeset来保存区间，方便判断是否有相交
        List<TreeSet<Integer>> ranges = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<Integer> range_list =Arrays.stream(in.nextLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            TreeSet<Integer> range_set = new TreeSet<>();
            for (Integer x : range_list) {
                range_set.add(x);
            }
            ranges.add(range_set);
        }

        //合并区间
        while (merge(ranges)) {
            ;
        }

        System.out.println(ranges);
    }

    public static boolean merge(List<TreeSet<Integer>> ranges) {
        for (int i = 0; i < ranges.size(); i++) {
            for (int j = i + 1; j < ranges.size(); j++) {
                TreeSet<Integer> range1 = ranges.get(i);
                TreeSet<Integer> range2 = ranges.get(j);
                if (check(ranges.get(i), ranges.get(j))) {
                    range1.addAll(range2);
                    ranges.remove(j);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(TreeSet<Integer> range1, TreeSet<Integer> range2) {
        int count = 0;
        for (Integer x : range1) {
            if (range2.contains(x)) {
                count++;
            }
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }


}
