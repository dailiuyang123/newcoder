package ClassicExam.od_200;

import java.util.*;

public class 连接器问题 {


    /**
     * 题目描述
     * 有一组区间[a0，b0]，[a1，b1]，…（a，b表示起点，终点），区间有可能重叠、相邻，重叠或相邻则可以合并为更大的区间；
     * <p>
     * 给定一组连接器[x1，x2，x3，…]（x表示连接器的最大可连接长度，即x>=gap），可用于将分离的区间连接起来，但两个分离区间之间只能使用1个连接器；
     * <p>
     * 请编程实现使用连接器后，最少的区间数结果。
     * <p>
     * 区间数量<10000，a,b均 <=10000
     * 连接器梳理<10000；x <= 10000
     * <p>
     * 输入描述
     * 区间组：[1,10],[15,20],[18,30],[33，40]
     * 连接器组：[5,4,3,2]
     * <p>
     * 输出描述
     * 1
     * <p>
     * 说明：
     * <p>
     * 合并后：[1,10],[15,30],[33,40]，使用5, 3两个连接器连接后只剩下 [1, 40]。
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        String[] lengthstr = t.substring(1, t.length() - 1).split("\\,");
        int[] length = new int[lengthstr.length];
        for (int i = 0; i < lengthstr.length; i++) {
            length[i] = Integer.valueOf(lengthstr[i]);
        }


        String[] split = s.substring(1, s.length() - 1).split("\\]\\,\\[");

        // 利用差分合并数组
        int[] arr = new int[10001];
        for (String s1 : split) {
            String[] split1 = s1.split("\\,");
            int l = Integer.valueOf(split1[0]);
            int r = Integer.valueOf(split1[1]);
            for (int i = l; i <= r; i++) {
                if (arr[i] == 0) {
                    arr[i] = 1;
                }
            }
        }


        // 找出需要链接的区间的个数，与长度
        List<Integer> counts = new ArrayList<>();

        int left = 0;
        int right = 0;
        for (int i = 1; i < arr.length; i++) {
            // 结束标识
            if (arr[i] == 0 && arr[i - 1] == 1) {
                left = i;
            }


            // 开始标识
            if (arr[i] == 1 && arr[i - 1] == 0 && left > 0) {
                right = i;
                counts.add(right - left + 1);
                left = 0;
                right = 0;
            }
        }

        // 给链接器排序
        Arrays.sort(length);

        // 排序，从最小的需要连接器链接的长度
        Collections.sort(counts);

        Deque<Integer> stack = new ArrayDeque<>(counts);

        for (int i = 0; i < length.length; i++) {
            if (stack.peek() <= length[i]) {
                stack.pop();
            }
        }

        System.out.println(stack.size() + 1);

    }


}
