package test.day2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Hj54 {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Pattern p = Pattern.compile("[+,\\-,*,/]");
        Pattern p1 = Pattern.compile("[0-9]");
        String[] num = p.split(s);
        String[] split = p1.split(s);

//        while (p.matcher(s).find()) {
//            s = excute(s);
//        }
//        Integer integer = Integer.valueOf(s);
//        System.out.println(integer);

    }


//    private static String excute(String s) {
//        int l = 1;
//        while (l < s.length() - 1) {
//
//            if(){
//
//            }
//
//        }
//
//    }
}
