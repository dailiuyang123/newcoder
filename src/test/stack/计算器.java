package test.stack;

import java.util.Stack;

public class 计算器 {


    // 计算器 加，减，乘，除

    public static void main(String[] args) {

        String s = "4/2";
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        char oper = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int tmp = sum;
                sum = sum * 10 + c - '0';
                if (i < s.length()-1) {
                    continue;
                }
            }
            if (!Character.isDigit(c) && c != ' ' || i < s.length()) {

                if (oper == '+') {
                    stack.push(sum);
                }
                if (oper == '-') {
                    stack.push(-sum);
                }
                if (oper == '*') {
                    stack.push(stack.pop() * sum);
                }
                if (oper == '/') {
                    stack.push(stack.pop() / sum);
                }
                sum = 0;
                oper = c;
            }

        }

        for (Integer I : stack) {
            sum += I;
        }

        System.out.println(sum);
    }


}
