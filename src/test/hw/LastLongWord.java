package test.hw;

import java.util.Scanner;

public class LastLongWord {

//    获取计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        System.out.println(s1[s1.length-1].length());
    }


}
