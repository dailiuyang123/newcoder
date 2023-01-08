package test.stack;

import java.util.*;

public class Stack构造顺序 {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            list.add(i);
        }

        Collections.sort(list);

        System.out.println(list.toString());


        System.out.println("stack -----------");
        Deque<Integer> stack = new ArrayDeque<>(list);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }



    }

}
