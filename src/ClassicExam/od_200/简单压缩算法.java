package ClassicExam.od_200;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 简单压缩算法 {

    /**
     * 题目描述
     * 现需要实现一种算法，能将一组压缩字符串还原成原始字符串，还原规则如下：
     * <p>
     * 1、字符后面加数字N，表示重复字符N次。例如：压缩内容为A3，表示原始字符串为AAA。
     * 2、花括号中的字符串加数字N，表示花括号中的字符重复N次。例如压缩内容为{AB}3，表示原始字符串为ABABAB。
     * 3、字符加N和花括号后面加N，支持任意的嵌套，包括互相嵌套，例如：压缩内容可以{A3B1{C}3}3
     * <p>
     * 输入描述
     * 输入一行压缩后的字符串
     * <p>
     * 输出描述
     * 输出压缩前的字符串
     * <p>
     * 用例
     * 输入	{A3B1{C}3}3
     * 输出	AAABCCCAAABCCCAAABCCC
     * 说明	{A3B1{C}3}3代表A字符重复3次，B字符重复1次，花括号中的C字符重复3次，最外层花括号中的AAABCCC重复3次。
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        String temps = "";
        String rs = "";
        int index = 0;
        Deque<Character> stack = new ArrayDeque<>();
        boolean ispop = false;
        while (index < s.length()) {

            char c = s.charAt(index);

            if (ispop && Character.isDigit(c)) {
                String tag = temps;
                for (int i = 1; i < (c - '0'); i++) {
                    temps += tag;
                }
                ispop = false;
                index++;
                continue;
            }

            // 消除递归花括号 "{ .... }"
            if (!stack.isEmpty() && c == '}') {
                ispop = true;
                StringBuilder temp = new StringBuilder();
                while (stack.peek() != '{') {
                    temp.append(stack.pop());
                }
                stack.pop();
                temps = temp.reverse().toString() + temps;
            } else {
                stack.push(c);
            }
            index++;
        }

        if (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            temps = temps + sb.reverse().toString();
        }

        temps = unzip(temps);
        System.out.println(temps);
    }


    public static String unzip(String zip) {
        String full = zip.charAt(0) + "";
        for (int i = 1; i < zip.length(); i++) {
            if (Character.isDigit(zip.charAt(i)) && Character.isLetter(zip.charAt(i - 1))) {
                char c = zip.charAt(i - 1);
                for (int j = 1; j < zip.charAt(i) - '0'; j++) {
                    full += c;
                }
            } else {
                full += zip.charAt(i);
            }
        }
        return full;
    }


}
