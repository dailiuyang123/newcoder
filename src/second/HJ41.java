package second;


import java.util.*;

/**
 * 称砝码
 * <p>
 * 现有n种砝码，重量互不相等，分别为：m1,m2,m3,m4...mn
 * 每种砝码对应的数量是 x1,x2.....xn. 现在要用这些砝码去成物体的重量，问能chengchu
 * 多上种不同的重量。
 */
public class HJ41 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {

            int n = in.nextInt();

            int[] w_arr = new int[n];

            int[] num_arr = new int[n];

            List<Integer> catanas = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                w_arr[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                num_arr[i] = in.nextInt();
                Integer[] a = new Integer[num_arr[i]];
                Arrays.fill(a, w_arr[i]);
                catanas.addAll(Arrays.asList(a));
            }

            int max = Arrays.stream(num_arr).sum();

            Set<Integer> res = new HashSet<>();

            for (int i = 1; i <= max; i++) {
                // 采用 dfs
                int length = i;
                Deque<Integer> path = new ArrayDeque<>();
                dfs(catanas, path, res, 0, length, 0);
            }
            System.out.println(res.size() + 1);
        }

    }


    static void dfs(List<Integer> catanas, Deque<Integer> path, Set<Integer> res, int index, int length, int sum) {

        // 判断条件
        if (path.size() == length) {
            res.add(sum);
            return;
        }

        // 循环执行
        for (int i = index; i < catanas.size(); i++) {
            path.push(catanas.get(i));
            sum += catanas.get(i);
            dfs(catanas, path, res, i + 1, length, sum);
            // 回退
            path.pop();
            sum -= catanas.get(i);
        }

    }


}
