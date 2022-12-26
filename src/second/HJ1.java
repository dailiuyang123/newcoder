package second;

import java.util.Scanner;

public class HJ1 {

    /**
     *  查找字符串最后一个单词的长度
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int index = s.lastIndexOf(" ");
        System.out.println(s.length()-1-index);

    }



}
