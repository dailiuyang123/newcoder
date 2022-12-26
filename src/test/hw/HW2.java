package test.hw;

import java.util.Scanner;

public class HW2 {

//    获取计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String s2 = in.nextLine();
        String s1 = s.toLowerCase();
        String s3 = s2.toLowerCase();
        String replace = s1.replace(s3, "");
        System.out.println(s.length()-replace.length());
    }


}
