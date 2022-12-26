package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 队列测试 {

    public static void main(String[] args) {


        // 队列

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }


    }


}
