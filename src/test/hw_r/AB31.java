package test.hw_r;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AB31 {

    // 给定nn个活动，每个活动安排的时间为[a_i,b_i)[a
    //i
    //​
    // ,b
    //i
    //​
    // )。求最多可以选择多少个活动，满足选择的活动时间两两之间没有重合。


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            Node node = new Node(a, b);
            nodes.add(node);
        }

        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.b - o2.b;
            }
        });

        int count = 0;
        // 设置结束标志
        int begin = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).a >= begin) {
                begin = nodes.get(i).b;
                count++;
            }
        }

        System.out.println(count);

    }


    public static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }


}
