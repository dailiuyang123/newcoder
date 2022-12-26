package test.hw;

import java.util.Scanner;

public class HW4 {

//    •连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
//
//    •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (true) {
//            String s = in.nextLine();
//            int l = s.length() / 8;
//            int a = s.length() % 8;
//            for (int i = 0; i < l; i++) {
//                System.out.println(s.substring(i * 8, (i + 1) * 8));
//            }
//            if (a!=0) {
//                System.out.println(s.substring(8*l,s.length())+"0000000".substring(0,(8-a)));
//            }
//        }
//    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            int l = s.length() / 8;
            int a = s.length() % 8;
            for (int i = 0; i < l; i++) {
                System.out.println(s.substring(i * 8, (i + 1) * 8));
            }
            if (a!=0) {
                System.out.println(s.substring(8*l,s.length())+"0000000".substring(0,(8-a)));
            }
        }
    }

}
