package second;

import java.util.Scanner;

public class HJ2 {


    // 计算某字符出现次数
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String lowerCase = s.toLowerCase();
        String ch = in.nextLine();
        String lowerCase1 = ch.toLowerCase();
        String replace = lowerCase.replace(lowerCase1, "");
        System.out.println(s.length()-replace.length());

    }


}
